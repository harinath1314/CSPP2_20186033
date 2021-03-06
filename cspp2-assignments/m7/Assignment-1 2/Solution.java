import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * Write the atrributes and methods for InputValidator.
     */
    private static String name;
    /** the class variable with private access specifier.
    */
    // private static String i;
    /**the constructor is to initialize the given input.
    *@param text String
    */
    protected InputValidator(final String text) {
        this.name = text;
    }
    /**
     * method for checking the length is minimum of 6.
     * @return boolean
     */
    public static boolean validateData() {
        int namelength = name.length();
        final int six = 6;
        return namelength >= six;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
