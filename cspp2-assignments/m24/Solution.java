import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.File;

/**
 * Class for stringmatch.
 */

final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // default constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        try {
        final int hun = 100;
        Stringmatch f = new Stringmatch();
        Scanner sc = new Scanner(System.in);
        // String line = sc.next();
        File inp = new File(sc.next());
        File[] listoffiles = inp.listFiles();
        // for (File name:listoffiles) {
        //  System.out.println(name);
        // }
        double max = 0;
        String res1 = "";
        int length = listoffiles.length;
        double[][] res = new double[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    res[i][j] = hun;
                } else {
                res[i][j] = Stringmatch.similarString(
                    Stringmatch.toString(listoffiles[i]),
                    Stringmatch.toString(listoffiles[j]));
                if (max < res[i][j]) {
                    max = res[i][j];
                res1 = "Maximum similarity is in between "
                    + listoffiles[i].getName() + " and "
                    + listoffiles[j].getName();
                }
            }
            }
        }
        System.out.print("\t");
        for (int i = 0; i < length; i++) {
            System.out.print("\t" + listoffiles[i].getName());
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(listoffiles[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                System.out.print(res[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println(res1);


    } catch (Exception e) {
        System.out.println("Empty Directory");
    }

        // String stext1 = sc.nextLine().toLowerCase();
        // String stext2 = sc.nextLine().toLowerCase();
        // Stringmatch feq = new Stringmatch();
    }
}
