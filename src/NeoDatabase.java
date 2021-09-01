/**
 * The NeoDatabase class contains and manages the NearEarthObject
 * records that's downloaded from online dataset
 * @author Yanhui Chen
 *      e-mail: yanhui.chen@stonybrook.edu
 * Data members: List<NearEarthObject> objects
 *               static final String API_KEY
 *               static final String API_ROOT
 */
import big.data.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.net.URL;
import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class NeoDatabase {
    public static final String API_KEY = "hqvTCf5HWxK379EAhgkgtISDepnsyAuKWgdNaBV1";
    public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";

    private List<NearEarthObject> objects;

    /**
     * returns an instance of NeoDatabase object
     */
    public NeoDatabase(){
        objects = new ArrayList<NearEarthObject>();
    }

    /**
     * build a query URL given a page number
     *
     * @param pageNumber
     *      the pageNumber of the online dataset
     * @precondition
     *      page number is in between and includes 0 to 715
     * @return
     *      a String representation of the queryURL
     * @throws IllegalArgumentException
     *      thrown if precondition is violated
     */
    public String buildQueryURL(int pageNumber) throws IllegalArgumentException {
        if (pageNumber < 0 || pageNumber > 715)
            throw new IllegalArgumentException();

        return API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY;
    }

    /**
     * Opens a connection to the data source indicated by queryURL and
     * adds all NearEarthObjects found in the dataset
     *
     * @param queryURL
     *      String containing the URL requesting a dataset from online
     * @precondtion
     *      queryURL is a non-null string representing a valid API request to the dataset
     * @postcondition
     *      All NearEarthObject record returned have been added to the database
     * @throws IllegalArgumentException
     *      thrown when queryURL is not valid or null
     */
    public void addAll(String queryURL) throws IllegalArgumentException {
        if (queryURL == null)
            throw new IllegalArgumentException();

        try {
            URL getRequest = new URL(queryURL);
            JSONTokener tokener = new JSONTokener(getRequest.openStream());
            JSONObject root = new JSONObject(tokener);
            JSONArray jsonArray = root.getJSONArray("near_earth_objects");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = (JSONObject) jsonArray.get(i);
                int id = obj.getInt("neo_reference_id");
                String name = (String) obj.get("name");
                double abMagnitude = obj.getDouble("absolute_magnitude_h");
                JSONObject diameter = (JSONObject) obj.get("estimated_diameter");
                JSONObject kilometer = (JSONObject) diameter.get("kilometers");
                double minDiameter = kilometer.getDouble("estimated_diameter_min");
                double maxDiameter = kilometer.getDouble("estimated_diameter_max");
                boolean isDangerous = obj.getBoolean("is_potentially_hazardous_asteroid");
                JSONArray appDate = (JSONArray) obj.get("close_approach_data");
                JSONObject appDateindex = (JSONObject) appDate.get(0);
                long closestDate = appDateindex.getLong("epoch_date_close_approach");
                JSONObject mssDis = (JSONObject) appDateindex.get("miss_distance");
                double missDis = mssDis.getDouble("kilometers");
                String orbBody = (String) appDateindex.get("orbiting_body");
                NearEarthObject asteroid = new NearEarthObject(id,name,abMagnitude,minDiameter,maxDiameter,isDangerous,
                        closestDate,missDis,orbBody);
                objects.add(asteroid);
            }

        } catch (IOException e){

        } catch (JSONException e) {

        }
    }

    /**
     * sort the database using the specified Comparator of NearEarthObject
     *
     * @param comp
     *      predefined Comparator of NearEarthObject
     * @precondition
     *      comp is not null
     * @postcondition
     *      The database has been sorted based on the given Comparator
     * @throws IllegalArgumentException
     *      thrown when precondition is violated
     */
    public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException{
        if (comp == null)
            throw new IllegalArgumentException();
        Collections.sort(objects, comp);
    }

    /**
     * displays the data base in a neat, tabular form, listing all
     * member variables for each NearEarthObject
     *
     * @precondition
     *      This NeoDatabase is initialized and not null
     * @postconditon
     *      the table has been printed to console but remains unchanged
     */
    public void printTable(){

        String head = String.format("%-12s%-40s%-8s%-10s%-10s%-15s%-15s%-7s","ID","Name","Mag.","Diameter",
                "Danger","Close Date","Miss Dist","Orbits");
        System.out.println(head);
        for (NearEarthObject a : objects)
            System.out.println(a.toString());
    }

}
