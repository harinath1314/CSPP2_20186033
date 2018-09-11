import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**.
 * class of lsit.
 */
class List {
    /**
    *private list.
    */
    private int[] list;

    /**.
     * thisiis  probvate int sixe.
     */
    private int size;

    /*
     * The purpose of the constructor is to initialize the class variables with
     * some default values.
     */
    /**
     * Constructs the object.
     */
    public List() {


        final int ten = 10;
        list = new int[ten];
        size = 0;

    }


    /**.
     * add function.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        list[size++] = item;
    }

    /*
     * The size method returns the value of the size. The purpose of the method
     * is to announce the size of the list to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     *
     */
    /**
     *  returns the size of list.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }


    /**
     * remove the element in index.
     *
     * @param      index  The index
     */
    public void remove(final int index) {
        // write the logic for remove here. Think about what to do to the size
        // variable.
        try {
            if (index >= 0 && index < size) {
                for (int k = index; k < size - 1; k++) {
                    list[k] = list[k + 1];
                }
                size--;
            } else {
                throw new Exception();
            }
        } catch (Exception h) {
            System.out.println("Index Position Exception");
        }
    }


    /**.
     * get the elemenet  in that index.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (index >= 0 && index < size) {
            return list[index];
        } else {
            return -1;
        }
    }


    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }

    /**
     * returns true if item is present.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (list[i] == (item)) {
                return true;
            }

        }
        return false;
    }

    /**
     * indexOf gives the index of item.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        // Replace the code below
        for (int  i = 0; i < size; i++) {
            if (list[i] == (item)) {
                return i;
            }
        }
        return -1;
    }
    /*
    Inserts all the elements of specified int array to the end of list
    */
    /**.
     *
     */
    public void resize() {
        list = Arrays.copyOf(list, list.length * list.length);
    }
    /**
    */
    /**
     * Adds all.
     *
     * @param      newArray  The new array
     */
    public void addAll(final int[] newArray) {
        // write the logic
        if (size + newArray.length >= list.length) {
            resize();
        }
        for (int each : newArray) {
            list[size++] = each;
        }
    }
    /*
     Removes all of its elements that are contained in the specified int
     array.
    */
    /**
     * Removes all.
     *
     * @param      newArray  The new array
     */
    public void removeAll(final int[] newArray) {
        // write the logic
        for (int each  : newArray   ) {
            for (int i = 0; i < newArray.length; i++) {
                if (contains(newArray[i])) {
                    remove(indexOf(newArray[i]));
                }
            }
        }


    }

    /**
     * sublist returns a list from strat to endindex.
     *
     * @param      start  The start
     * @param      end    The end
     *
     * @return     { description_of_the_return_value }
     */
    public List subList(final int start, final  int end) {
        // write the logic for subList
        List subliste = new List();
        if (start >= 0 && start < end && size >= end) {
            for (int i = start; i < end; i++) {
                subliste.add(list[i]);
            }
            return subliste;
        } else {
            return null;
        }
    }

    /**
     * returns true if equal .
     *
     * @param      listss  The list
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final List listss) {
        // Replace the code below
        if (listss.size() == this.size()) {
            if (listss.toString().equals(this.toString())) {
                return true;
            }
            return false;
        }
        return false;

    }

    /**
     * clear function.
     */
    public void clear() {
        // write the logic for clear.
        int newsize = size;
        for (int i = 0; i < newsize; i++) {
            remove(0);
        }
    }
}
public class Solution {
    /**.
     * main function starts here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();

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
            case "add":
                if (tokens.length == 2) {
                    String[] t = tokens[1].split(",");
                    if (t.length == 1) {
                        l.add(Integer.parseInt(tokens[1]));
                    }
                }
                break;
            case "size":
                System.out.println(l.size());
                break;
            case "print":
                System.out.println(l);
                break;
            case "remove":
                if (tokens.length == 2) {
                    l.remove(Integer.parseInt(tokens[1]));
                }
                break;
            case "indexOf":
                if (tokens.length == 2) {
                    System.out.println(l.indexOf(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "get":
                if (tokens.length == 2) {
                    System.out.println(l.get(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "contains":
                if (tokens.length == 2) {
                    System.out.println(l.contains(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] t1 = tokens[1].split(",");
                    int[] temp = new int[t1.length];
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = Integer.parseInt(t1[i]);
                    }
                    l.addAll(temp);
                }
                break;
            case "removeAll":
                if (tokens.length == 2) {
                    String[] t2 = tokens[1].split(",");
                    int[] a = new int[t2.length];
                    for (int i = 0; i < t2.length; i++) {
                        a[i] = Integer.parseInt(t2[i]);
                    }
                    l.removeAll(a);
                }
                break;
            case "subList":
                try {
                    if (tokens.length != 2) {
                        break;
                    }
                    String[] arrstring3 = tokens[1].split(",");
                    List object = l.subList(Integer.parseInt(arrstring3[0]),
                                            Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(object);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception h) {
                    System.out.println("Index Out Of Bounds Exception");
                }

                break;

            case "equals":
                if (tokens.length == 2) {
                    String[] lt = tokens[1].split(",");
                    List l2 = new List();
                    for (int k = 0; k < lt.length; k++) {
                        l2.add(Integer.parseInt(lt[k]));
                    }
                    System.out.println(l.equals(l2));
                }
                break;
            case "clear":
                l.clear();
                break;
            default:
                break;
            }
        }
    }
}

