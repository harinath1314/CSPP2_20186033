/**
 * { item_description }
 */
import java.util.Scanner;
/**
    * Class for solution to find power.
    * author : harinatha reddy
    * date : 29/08/18
 */
public class Solution {
    /*
    Do not modify this main function.
    */
    private Solution() {
        /**
         * { item_description }
         */
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base,exponent);
        System.out.println(result);
    }
    /**
     * power function.
     *
     * @param      base      The base
     * @param      exponent  The exponent
     *
     * @return     { description_of_the_return_value }
     */
    static long power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, (exponent - 1));

    }

}
