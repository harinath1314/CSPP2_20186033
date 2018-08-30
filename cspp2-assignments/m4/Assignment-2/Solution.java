/**.
 * { we are importing packages of java}
 */
import java.util.Scanner;

/**.
    * Class for solution.
    * author harinath reddy
    * date : 30/8/18
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * { item_description }
         */
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int m = Integer.parseInt(input.next());
        int n = Integer.parseInt(input.next());

        int[][] mat1 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat1[i][j] = Integer.parseInt(input.next());
            }

        }
        int o = Integer.parseInt(input.next());
        int p = Integer.parseInt(input.next());

        int[][] mat2 = new int[o][p];

        for (int i = 0; i < o; i++) {
            for (int j = 0; j < p; j++) {
                mat2[i][j] = Integer.parseInt(input.next());
            }
        }
        if (m == o && n == p) {
            for (int i = 0; i < m; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    mat1[i][j] = mat1[i][j] + mat2[i][j];
                    s += mat1[i][j] + " ";
                }
                System.out.println(s.substring(0, s.length() - 1));
            }
        } else {
            System.out.println("not possible");
        }
    }
}
