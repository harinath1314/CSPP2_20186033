import java.io.BufferedInputStream;
import java.util.Scanner;
//A Class is implemented for Student details
/*.
*class called Student is build.
*/
/**.
* student class
*/
//thisii s a class called student.
class Student {
    /**.
     * { var_description }
     */
    private String name;
    /**.
     * object constructor.
     *
     * @param      names  The name
     */
    Student(final String names) {
        //A constructor used to initialize the instance variables
        this.name = names;
    }
    /*
     *getter od string.
    */
    /**
     * getname function.
     *
     * @return     The name.
     */
    public String getName() {
        //Getter method which returns the value of instance variable
        return this.name;
    }

    @Override
    /**
     * boolean function returns
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final Object other) {
        //This method is to check if two students
        //names are equal or not
        if (!(other instanceof Student)) {
            return false;
        }

        Student that = (Student) other;
        return this.getName().equals(that.getName());
    }
    /**
     * thisi is to remove a error in checkstyle 
     *
     * @return     { description_of_the_return_value }
     */
    public int hashCode() {
        return this.hashCode();
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name;
    }
}
/**.
 * class of solution
 */
public final class Solution {
    /**.
     * private constructor
     */
    private Solution() {
        /**.
         * { item_description }
         */
    }

    /**.
     * main functoion,.
     *
     * @param      args  The arguments
     *
     */ 
}

