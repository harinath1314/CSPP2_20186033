/**
 * { item_description }
 */
import java.util.Scanner;
import java.util.Arrays;
/**.
    * Class for solution.
    * Author : harinatha reddy
    * date : 30/8/18
 */

public final class Solution {
    /**
    Fill this main function to print maximum of given array
    */
    private Solution() {
        /**
         * this is for checkstyle.
         */
    }
    /**.
     * {this is the main function }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println(array[(array.length) - 1]);
    }
}
