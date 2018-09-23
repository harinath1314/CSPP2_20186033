import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.File;

 public class Stringmatch {
    /**
     * Constructs the object.
     */
    Stringmatch() {
    }
    /**
     * Returns a string representation of the object.
     *
     * @param      filename  The filename
     *
     * @return     String representation of the object.
     */
    public static String toString(final File filename) {
        String str = "";
        try {
            Scanner input = new Scanner(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            while (input.hasNext()) {
                sb.append(input.next());
                sb.append(" ");
            }
            input.close();
            str = sb.toString();
        } catch (Exception e) {
            System.out.println("no file");
        }
        return str;
    }
    /**
     * Removes all.
     *
     * @param      text  The text
     *
     * @return     { description_of_the_return_value }.
     */
    public static Map removeAll(final String text) {
        String[] word1 = text.replaceAll(
            "[^a-zA-Z. ]", "").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();
        int f = 0;
        for (int i = 0; i < word1.length; i++) {
            if (!map.containsKey(word1[i])) {
                map.put(word1[i], 1);
            } else {
                map.put(word1[i], map.get(word1[i]) + 1);
            }
        }
        return map;
    }
    /**
     * { function_description }.
     *
     * @param      s1    The s 1
     * @param      s2    The s 2
     *
     * @return     { description_of_the_return_value }
     */
    public static double similarString(final String s1, final String s2) {
        final int hun1 = 100;
        final double hun2 = 100D;
        int rows = s1.length();
        int columns = s2.length();
        double strLength = rows + columns;
        int[][] max = new int[rows + 1][columns + 1];
        int res = 0;
        double sim = 0;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                if (i == 0 || j == 0) {
                    max[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    max[i][j] = max[i - 1][j - 1] + 1;
                    //result = max(result, maximum[i][j]);
                } else {
                    max[i][j] = 0;
                }
                if (res < max[i][j]) {
                    res = max[i][j];
                }
            }
        }
        //System.out.println(result);
        sim = Math.round((((res * 2) / (strLength)) * hun2) / hun2);
        //System.out.println(stringLength);
        return (sim * hun1);
        }
}
