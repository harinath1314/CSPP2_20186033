/**this is a main class to buils pattern.
 * 
 */
import java.util.Scanner;
public class Pattern {
	public static void main(String[] args) {
		Scanner input_number = new Scanner(System.in);

		int a = input_number.nextInt();
		for (int i = 1;i <= a ;i++ ) {
			for (int line = 1;line<=i ;line++) {
				System.out.print(line + " ");
			}
			System.out.println();
		}


	}
}