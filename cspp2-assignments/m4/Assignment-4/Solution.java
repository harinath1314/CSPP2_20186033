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
public final class Solution {
    /**.
    * this is main string
    */
    private Solution() {

    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);

    }
    /**.
     * { function_description }
     *
     * @param      s this is the input string.
     *
     * @return     {the return is a string}
     */
    static String reverseString(final String s) {
        String rever = "";
        for (int i = (s.length() - 1); i >= 0; i--) {
            rever += s.charAt(i);
        }
        return rever;
    }

}
