/** thsi is main program to find the area of triangle.
    *Author : hatinatha reddy
    *date : 28/08/18
*/
import java.util.Scanner;
import java.lang.*;


public class Solution {
    /*
    Do not modify this main function.
    */
    /**.
        *function of area.
        *
    */
    double areaOfTriangle(final int base, final int height) {
        // gives the area of triangle.
        final double l = 0.5;
        double a = (base * height) * l;
        return a;
    }
    /**
        *
    */
    public static void main(final String[] args) {
        /**
            *main string to find area.
        */
        Scanner scan = new Scanner(System.in);
        System.out.print("input base length -");
        int base = scan.nextInt();
        System.out.print("input height of triangle -");
        int height = scan.nextInt();
        Solution area = new Solution();
        System.out.println("area of triangle = ");
        System.out.println(area.areaOfTriangle(base, height));
    }

}
