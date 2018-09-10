import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : harinatha reddy
 * date : 08/09/18
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
    */
    private int[] hari;
    /**.
     * { var_description }
     */
    /**.
     * { var_description }
     */
    private int size;
    /**
     * Constructs the object.
     */
    Set() {
        final int fifty = 50;
        hari = new int[fifty];
        size = 0;
    }
    /**
    * returns a sixe of set.
    *
    * @return     { description_of_the_return_value }
    */
    public int size() {
        return size;
    }
    /**
     * contains function.
     *
     * @param      val   The value we give to check.
     *
     * @return     true or false
     */
    public boolean contains(final int val) {
        for (int i = 0; i < size; i++) {
            if (hari[i] == (val)) {
                return true;
            }
        }
        return false;

    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size != 0) {
            String l = "";
            for (int i = 0; i < size; i++) {
                l += hari[i] + ", ";

            }
            return ("{" + l.substring(0, l.length() - 2) + "}");

        } else {
            return "{}";
        }

    }
    /**.
     * { function_description }.
     *
     * @param      val   The value
     */
    public void add(final int val) {
        if (!contains(val)) {
            hari[size++] = val;
        }
    }
    /**.
     * { function_description }
     */
    public void resize() {
        final int four = 14;
        hari = Arrays.copyOf(hari, hari.length * four);
    }
    /**.
     * add function for add ing array to set.
     *
     * @param      array  The array
     */
    public void add(final int[] array) {
        if ((array.length + size) > hari.length) {
            resize();
        }
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }

    }

    public int get(final int index) {
        if (index < 0 || index >= this.size()) {
            return -1;
        } else {
            return hari[index];
        }
    }

    /**
     * intersection of set.
     *
     * @param      giset  The giset
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(Set giset) {
        Set newset = new Set();
        for (int i = 0; i < this.size(); i++) {
            if(giset.contains(this.get(i))) {
                newset.add(this.get(i));

            }
        }
        return newset;
    }



    /**
     * retain function for retaining all elements of given array
     *
     * @param      array  The array
     *
     * @return     returns a set.
     */
    public Set retainAll(int[] arr) {
        Set other = new Set();
        for (int item : arr) {
            other.add(item);
        }
        return intersection(other);
    }

    /**
     * to find the cartesian product of a given set.
     *
     * @param      giveset  The giveset
     *
     * @return     { description_of_the_return_value }
     */
    public int[][] cartesianProduct(final Set other) {
        int [][] result = new int[this.size() * other.size()][2];
        int k = -1;
        if (this.size() == 0 || other.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < other.size(); j++) {
                result[++k][0] = this.get(i);
                result[k][1] = other.get(j);
            }
        }
        return result;
    }
}




/**
 * Solution class for code-eval.
 */

public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    
    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));

        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(tokens[0]);
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":;
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                System.out.println(s);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
