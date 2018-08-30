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
	/**.
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		int o = input.nextInt();
		int p = input.nextInt();
		int[][] mat1 = new int[m][n];
		int[][] mat2 = new int[o][p];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n ; j++ ) {
				mat1[i][j] = input.nextInt();
			}
		}
		for (int i = 0; i < o; i++) {
			for (int j = 0; j < p; j++ ) {
				mat2[i][j] = input.nextInt();
			}
		}
		if (m == o && n == p) {
			for (int i = 0; i < m ; i++) {
				for (int j = 0; j < n; j++ ) {
					mat1[i][j] = mat1[i][j] + mat2[i][j];
				}
			}
		} else
			System.out.println("addition is not possible");
	}
}
