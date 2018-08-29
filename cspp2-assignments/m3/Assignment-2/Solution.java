/**program to print number of 7's in given number to 1.
 *author harinath
 *date : 29/08/18
 * 
 */
import java.util.Scanner;

/*
	Do not modify this main function.
	*/
/**
 * Class for solution.
 */
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
	/**
	 * { this is main method }
	 *
	 * @param      args  The arguments
	 */
    public static void main(String[] args) {
    	/**
    	 * { var_description }
    	 */

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int refer = 7;
        int count = 0;
        for (int i =7 ;i<=n;i++ ) {
        	{
        		int num =i;
        		while (num>0) {
        			int digit = num % 10;
        			num=num/10;
        			if (digit == refer) count+=1;
        		}
        	}
        	
        }
        System.out.println(count);
    }
}
