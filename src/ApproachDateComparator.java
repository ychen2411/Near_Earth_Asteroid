/**
 * The ApproachDateComparator class is used to compare the compare the closestApproachDate
 * of two NearEarthObject objects
 * field of two NearEarthObject instances
 * @author Yanhui Chen
 *      e-mail: yanhui.chen@stonybrook.edu
 *
 *
 */
public class ApproachDateComparator implements java.util.Comparator<NearEarthObject>{
    /**
     * compares the closestApproachDate of two NearEarthObject object
     * @param leftSide
     *      NearEarthObject instance in an ArrayList on a position
     * @param rightSide
     *      NearEarthObject on the ArrayList one position after the leftSide
     * @return
     *      1, if date on the left is greater, -1 if date on the left is smaller,
     *      0 is they are equal
     */
    public int compare(NearEarthObject leftSide, NearEarthObject rightSide) {
        return (leftSide.getClosestApproachDate().compareTo(rightSide.getClosestApproachDate()));
    }
}