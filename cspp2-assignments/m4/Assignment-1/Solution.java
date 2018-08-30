/**
 * { item_description }
 */
import java.util.*;
/**.
    * Class for solution.
    * Author : harinatha reddy
    * date : 30/8/18 
 */

public class Solution {
/*
    Fill this main function to print maximum of given array
    */
    /**
     * {this is the main function }
     *
     * @param      args  The arguments
     */
    private Solution() {
        /**.
         * this is for checkstyle.
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input number of elements in an array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("inout array elements - ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println("the maximum of elements in array - ");
        System.out.println(array[(array.length) - 1]);
    }
}
