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
    public static void main(String[] args) {
        /**
         * main method.
         */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();


        rootsOfQuadE(a, b, c);
    }
    /**
        *this is a roots
    */
    static void rootsOfQuadE(final int a, final  int b, final int c) {
        /**
         * roots
         */
        int f = 4;
        double det = Math.sqrt((b * b) - f * a * c);
        double root1 = (-b + det) / (2 * a);
        double root2 = (-b - det) / (2 * a);
        System.out.print(root1 + " ");
        System.out.print(root2);
    }
}
