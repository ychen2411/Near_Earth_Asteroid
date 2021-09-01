/**
 * The ReferenceIDComparator class is used to compare the referenceID
 * field of two NearEarthObject instances
 * @author Yanhui Chen
 *      e-mail: yanhui.chen@stonybrook.edu
 *
 */
public class ReferenceIDComparator implements java.util.Comparator<NearEarthObject> {
    /**
     * compares the referenceID of two NearEarthObject instance
     *
     * @param leftSide
     *       NearEarthObject instance in an ArrayList on a position
     * @param rightSide
     *      NearEarthObject on the ArrayList one position after the leftSide
     * @return
     *      1 is leftSide's id is greater, -1 if leftSide's id is smaller
     *      0 if id for both sides are equal
     */
    public int compare(NearEarthObject leftSide, NearEarthObject rightSide) {

        if (leftSide.getReferenceID() == rightSide.getReferenceID())
            return 0;
        else if (leftSide.getReferenceID() > rightSide.getReferenceID())
            return 1;
        else
            return -1;
    }

}
