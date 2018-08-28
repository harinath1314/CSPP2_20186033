/**
 * Class for factorial.
 */
import java.util.Scanner;
public class Factorial {
	/**
	 * { for factorial }
	 *
	 * @param      args gives the number for factorial
	 */
	static int factorial(int a ){
		if (a == 0)
			return 1;
		return a*(factorial(a-1));
	}
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("input a number to find factorial ");
		int a = input.nextInt();
		System.out.println("the factorial of the given number is ");

		System.out.println(factorial(a));
	}
}
