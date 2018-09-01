import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : Harinatha reddy 
 * @date : 1/09/18
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param n upto which we have to find composite numbers.
     */
    static void oddComposites(final int n) {
    //my code is here
        for (int i = 9; i < n; i++ ) {
            
        int temp = 0;
            for (int j = 1; j <= i ; j++) {
                if (i % j == 0){
                    temp += 1;
                }
            }

            if(temp > 2 && i %2 != 0){
            System.out.println(i);
            }
        }
                
             
    }

    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}
