/**
 * main program of finding root sof equations.
 * author hrinath
 * date : 28/08/18
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
    *Do not modify this main function.
    */
    private Solution() {
    	/**
    	 * 
    	 */
    }
    /**.
     * { main function or method}
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * main method.
         */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        /**
         *
         */

        rootsOfQuadE(a, b, c);
    }
    /**.
        *this is a roots
    */
    /**.
     * { function_description }
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @param      c     { parameter_description }
     */
    static void rootsOfQuadE(final int a, final  int b, final int c) {
        /**
         * roots
         */
        final int f = 4;
        double det = Math.sqrt((b * b) - f * a * c);
        double root1 = (-b + det) / (2 * a);
        double root2 = (-b - det) / (2 * a);
        System.out.print(root1 + " ");
        System.out.print(root2);
    }
}
