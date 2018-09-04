/**.
 * reverstring program is being written.
 * author : hariatha reddy
 * date : 2/09/18
 */
/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
public class Solution {
    /*.
    * this is main string
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println();
        String reverse = reverseString(s);
        System.out.println(reverse);

    }
    /**
     * { function_description }
     *
     * @param      s this is the input string.
     *
     * @return     {the return is a string}
     */
    static String reverseString(String s) {
        String rever = "";
        System.out.println(s);
        for (int i = (s.length() - 1); i >= 0; i--) {
            rever += s.charAt(i);
        }
        return rever;
    }

}
