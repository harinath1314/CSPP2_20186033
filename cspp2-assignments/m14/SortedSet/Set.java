package SetOperations;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : harinatha reddy
 * date : 08/09/18
 */
public class Set {
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
    private static int size;
    /**
     * Constructs the object.
     */
    public Set() {
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
    /**.
     * { function_description }.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
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
            if (giset.contains(this.get(i))) {
                newset.add(this.get(i));

            }
        }
        return newset;
    }
    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Set subSet(int a, int b) {
        Set result = new Set();
        for (int i = a; i < b; i++) {
            result.add(hari[i]);
        }
        return result;
    }
    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Set headSet(int a) {
        Set result = new Set();
        for (int i = 0; i < hari.length; i++) {
            if (hari[i] < a) {
                result.add(hari[i]);
            }
        }
        return result;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int last() {
        int test = 0;
        for (int i = 0; i < hari.length; i++) {
            if (hari[i] > test) {
                test = hari[i];
            }
        }
        return test;

    }
    /**
     * gives samleest of elements.
     *
     * @return     { description_of_the_return_value }
     */
    public int first() {
        int test = last();
        for (int i = 0; i < hari.length; i++) {
            if (hari[i] < test) {
                test = hari[i];
            }
        }
        return test;

    }
    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     */
    public void remove(int a) {
        for (int i = a; i<hari.length-1; i++) {
            hari[i] = hari[i+1];
        }
        size--;
    }
    public int index(int a) {
        int index;
        for (int i = 0; i < hari.length; i++) {
            if(hari[i] == a) {
                return i;
            }
        }
        return -1;
    }
    /**
     * gives sorted array.
     */
    public void addAll(int[] a) {
        for (int i = 0; i < size-1; i++) {
            hari[size++] = a[i];
        }
        // Set newsenses = new Set();
        // int j = hari.length;
        // for (int i = 0; i < j; i++) {
        //     int testnumber = first();
        //     remove(index(testnumber));
        //     newsenses.add(testnumber);
        //     System.out.println(newsenses);
        // }
        // return newsenses;
        Arrays.sort(hari);
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
