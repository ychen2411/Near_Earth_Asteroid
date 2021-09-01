public class DiameterComparator {
    /**
     * The DiameterComparator class is used to compare the compare the averageDiameter
     * of two NearEarthObject objects
     * field of two NearEarthObject instances
     * @author Yanhui Chen
     *      e-mail: yanhui.chen@stonybrook.edu
     *      Stony Brook ID: 112717340
     *      CSE214 HW 7 R04
     *
     */
    public class DiameterComparator implements java.util.Comparator<NearEarthObject> {
        /**
         * compares the averageDiameter of two NearEarthObject object
         *
         * @param leftSide
         *      NearEarthObject instance in an ArrayList on a position
         * @param rightSide
         *      NearEarthObject on the ArrayList one position after the leftSide
         * @return
         *      1, if averageDiameter on the left is greater, -1 if averageDiameter on the left is smaller,
         *      0 is they are equal
         */
        public int compare(NearEarthObject leftSide, NearEarthObject rightSide) {

            if (leftSide.getAverageDiameter() == rightSide.getAverageDiameter())
                return 0;
            else if (leftSide.getAverageDiameter() > rightSide.getAverageDiameter())
                return 1;
            else
                return -1;
        }

    }
}
