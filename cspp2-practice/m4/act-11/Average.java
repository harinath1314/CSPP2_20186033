/**.
 * Class for average.
 * author harinatha reddy
 * date : 30-8-18
 */
import java.util.*;

public class Average {
	/**
	 * main function of program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int ar_num = input.nextInt();
		int[] arra = new int [ar_num];
		for (int i = 0;i < ar_num; i++) {
			arra[i] = input.nextInt();
		}
		System.out.println(Arrays.toString(arra));
		float temp = 0;
		for (int i : arra) {
			temp+= i;
		}
		System.out.println(temp/arra.length);
	}
}