/**.
 * { we are importing packages of java}
 */
import java.util.*;
import java.lang.*;

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
		String inp = input.nextLine();
		System.out.println(inp);
		String[] input_array = inp.split(" ");
		System.out.println(Arrays.toString(input_array));
 		int m = Integer.parseInt(input_array[0]);
		int n = Integer.parseInt(input_array[1]);
		int[][] mat1 = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n ; j++ ) {
				mat1[i][j] = input.nextInt();
			}
		}
		String input2 = input.nextLine();
		String[] input_array2 = input2.split(" ");
		int o = Integer.parseInt(input_array2[0]);
		int p = Integer.parseInt(input_array2[1]);
		int[][] mat2 = new int[o][p];
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
			System.out.println("not possible");
	}
}
