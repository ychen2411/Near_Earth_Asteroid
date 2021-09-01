/**
 * The NeoViewer class tests the NearEarthObject class and
 * the NeoDatabase class and the methods within them.
 * @author Yanhui Chen
 *      e-mail: yanhui.chen@stonybrook.edu
 *
 */
import java.util.Scanner;
public class NeoViewer {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] menu = {"A) Add a page to the database", "S) Sort the database",
                "P) Print the database as a table", "Q) Quit"};
        for (String a : menu)
            System.out.println(a);

        String choice = "";
        String vChoice ="";
        NeoDatabase data = new NeoDatabase();

        do {
            System.out.print("\nSelect a menu option: ");
            choice = input.next();
            vChoice = choice.toUpperCase();

            switch(vChoice) {
                case "A": {
                    System.out.print("\nEnter the page to load: ");
                    int pageNum = input.nextInt();
                    String queryURL = data.buildQueryURL(pageNum);
                    data.addAll(queryURL);
                    System.out.print("Page loaded successfully!");
                    break;
                }
                case "S": {
                    String[] sortMenu = {"R) Sort by referenceID", "D) Sort by diameter",
                            "A) Sort by approach date", "M) Sort by miss distance"};
                    for (String a : sortMenu) {
                        System.out.println(a);
                    }

                    System.out.print("Select a menu option: ");
                    String sortOption = input.next();

                    if (sortOption.equalsIgnoreCase("R")) {
                        data.sort(new ReferenceIDComparator());
                        System.out.print("Table sorted on referenceID");
                    }
                    else if (sortOption.equalsIgnoreCase("D")) {
                        data.sort(new DiameterComparator());
                        System.out.print("Table sorted on diameter");
                    }
                    else if (sortOption.equalsIgnoreCase("A")) {
                        data.sort(new ApproachDateComparator());
                        System.out.print("Table sorted on approach date");
                    }
                    else if (sortOption.equalsIgnoreCase("M")) {
                        data.sort(new MissDistanceComparator());
                        System.out.print("Table sorted on miss distance");
                    }
                    break;
                }
                case "P": {
                    data.printTable();
                    break;
                }
                case "Q": {
                    System.out.print("\n\nProgram terminating normally...");
                    System.exit(0);
                    break;
                }
            }

        } while (!vChoice.equalsIgnoreCase("Q"));
    }
}
