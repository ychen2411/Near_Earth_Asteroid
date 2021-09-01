public class MissDistanceComparator {
    /**
     * The MissDistanceComparator class is used to compare the compare the missDistance
     * of two NearEarthObject objects
     * field of two NearEarthObject instances
     * @author Yanhui Chen
     *      e-mail: yanhui.chen@stonybrook.edu
     */
    public class MissDistanceComparator implements java.util.Comparator<NearEarthObject> {
        /**
         * compares the missDistance of two NearEarthObject object
         *
         * @param leftSide
         *      NearEarthObject instance in an ArrayList on a position
         * @param rightSide
         *      NearEarthObject on the ArrayList one position after the leftSide
         * @return
         *      1, if missDistance on the left is greater, -1 if missDistance on the left is smaller,
         *      0 is they are equal
         */
        public int compare(NearEarthObject leftSide, NearEarthObject rightSide) {

            if (leftSide.getMissDistance() == rightSide.getMissDistance())
                return 0;
            else if (leftSide.getMissDistance() > rightSide.getMissDistance())
                return 1;
            else
                return -1;
        }
    }
}
