/*
	Do not modify this main function.
	*/
import java.util.Scanner;
/**the class of solution.
    *Author : Harinatha reddy
    *date : 29/08/18
 */
public class Solution {
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
 
        Scanner s = new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /**
     * { item_description }
     */
    static int gcd(final int n1, final int n2) {
        int temp = 0;
        for (int i = 1;i <= (n1 * n2); i++) {
            if ((n1 % i == 0) && (n2 % i == 0)){
                temp = i;
            }
        }
        return (temp);
    }

    /*
	*
	*/
}
