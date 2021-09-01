/**
 * The NearEarthObject class creates an NearEarthObject object
 * with specified referenceID, name, absoluteMagnitude,
 * averageDiameter, isDangerous, closetApproachDate, missDistance,
 * and orbitingBody
 * @author Yanhui Chen
 *      e-mail: yanhui.chen@stonybrook.edu
 * Data members: int referenceID
 *               String name
 *               double absoluteMagnitude
 *               double averageDiameter
 *               boolean isDangerious
 *               Date closestApproachDate
 *               double missDistance
 *               String orbitingBody
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
public class NearEarthObject {
    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private Date closestApproachDate;
    private double missDistance;
    private String orbitingBody;

    /**
     * returns an instance of NearEarthObject object
     *
     * @param referenceID
     *      ID of the NEO or NearEarthObject
     * @param name
     *      name of the NEO
     * @param absoluteMagnitude
     *      absolute brightness of the orbital body in the sky
     * @param minDiameter
     *      estimated minimum diameter of the orbital body
     * @param maxDiameter
     *      estimated maximum diameter of the orbital body
     * @param isDangerous
     *      whether the orbital body is dangerous
     * @param closestDateTimestamp
     *      Unix timestamp representing the date of closest approach
     * @param missDistance
     *      distance in kilometer at which the orbital body will pass by
     *      the Earth on the date of it's closest approach
     * @param orbitingBody
     *      other orbital body which this NEO orbits
     */
    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter,
                           double maxDiameter, boolean isDangerous, long closestDateTimestamp,
                           double missDistance, String orbitingBody) {
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.averageDiameter = (maxDiameter + minDiameter) / 2;
        this.isDangerous = isDangerous;
        this.closestApproachDate = new Date(closestDateTimestamp);
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;

    }

    /**
     * return referenceID of the instance
     * @return
     *      referenceID of instance
     */
    public int getReferenceID() {
        return referenceID;
    }

    /**
     * set the referenceID with specified value
     *
     * @param id
     *      the number to be set to referenceID
     */
    public void setReferenceID(int id){
        referenceID = id;
    }

    /**
     * return name of instance
     * @return
     *      name of instance
     */
    public String getName() {
        return name;
    }

    /**
     * set name of the instance
     *
     * @param name
     *      the name to be set to the instance
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * return absoluteMagnitude of the instance
     *
     * @return
     *      absoluteMagnitude of the instance
     */
    public double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    /**
     * set absoluteMagnitude of the instance
     *
     * @param absoluteMagnitude
     *      the number of be set to absoluteMagnitude
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    /**
     * return averageDiameter of the instance
     *
     * @return
     *      averageDiameter of the instance
     */
    public double getAverageDiameter() {
        return averageDiameter;
    }

    /**
     * set averageDiameter of the instance
     * @param averageDiameter
     *      number to be set to averageDiameter
     */
    public void setAverageDiameter(double averageDiameter) {
        this.averageDiameter = averageDiameter;
    }

    /**
     * return closestApproachDate of the instance
     *
     * @return
     *      closestApproachDate of the instance
     */
    public Date getClosestApproachDate() {
        return closestApproachDate;
    }

    /**
     * set closestApproachDate of the instance
     * @param closestApproachDate
     *      number to be set to closestApproachDate
     */
    public void setClosestApproachDate(Date closestApproachDate) {
        this.closestApproachDate = closestApproachDate;
    }

    /**
     * return isDangerous of the instance
     * @return
     *      isDangerous of the instance
     */
    public boolean isDangerous() {
        return isDangerous;
    }

    /**
     * set isDangerous of the instance
     *
     * @param dangerous
     *      boolean value to be set to isDangerous
     */
    public void setDangerous(boolean dangerous) {
        isDangerous = dangerous;
    }

    /**
     * return orbitingBody of the instance
     *
     * @return
     *      orbitingBody of the instance
     */
    public String getOrbitingBody() {
        return orbitingBody;
    }

    /**
     * set orbitingBody of the instance
     * @param orbitingBody
     *      name of the new orbitingBody to be set to the instance
     */
    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    /**
     * return missDistance of the instance
     * @return
     *      missDistance of the instance
     */
    public double getMissDistance() {
        return missDistance;
    }

    /**
     * set missDistance of the instance
     * @param missDistance
     *      number to be set to missDistance
     */
    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    /**
     * return a String representation of NearEarthObject object
     *
     * @return
     *      the specified fields of the object in a linear format
     */
    public String toString(){

        String isBoolean = String.valueOf(isDangerous);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        String day = dateFormat.format(closestApproachDate);

        String ans = String.format("%-12d%-40s%-8.1f%-10.3f%-10s%-15s%-15.0f%-7s",referenceID,name,
                absoluteMagnitude,averageDiameter,isBoolean,day,missDistance,orbitingBody);

        return ans;
    }
}
