import java.util.Scanner;
/** program to print roll number and name.
    * author: harinath
    * date: 28/08/2018
*/
public final class Solution {
    /**
        *
    */
    private Solution() {
        /**
            *
        */
    }

    /**
        * @param args of the program.
    */
    public static void main(final String[] args) {
        // System.out.println("Name : , Roll Number : ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        int rollno = input.nextInt();
        System.out.println("Name : " + name + "\n" + "Roll Number : " + rollno);
    }
}
