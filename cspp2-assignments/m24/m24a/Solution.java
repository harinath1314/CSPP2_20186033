/**
 * Class 
 * author harinatha reddy
 * date 20/9/18
 */

import java.io.FileReader;
import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedReader;
/**.
 * Class for plagrism. 
 */
final class Solution {
    /**.
     * This is solution
     */
    private Solution() {
        //this is solution
    }
    /**
     * this is the main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner filein = new Scanner(System.in);
        File test;
        try {
            test = new File(filein.nextLine());
        } catch (Exception e) {
            System.out.println("empty directory");
            return;
        }
        File[] files = test.listFiles();
        for (File name : files) {
            System.out.print("\t" + name.toString().split("/")[1]);

        }
        for (File each : files) {
            System.out.println();

            System.out.print(each.toString().split("/")[1] + "\t");
            for (File next : files) {
                try {
                    FileReader firfi = new FileReader(each);
                    FileReader secfi = new FileReader(next);

                    BufferedReader reader1 = new BufferedReader(firfi);
                    BufferedReader reader2 = new BufferedReader(secfi);
                    TreeMap<String, Integer> freqco = new TreeMap<>();
                    TreeMap<String, Integer> freqco2 = new TreeMap<>();

                    String lines;
                    while ((lines = reader1.readLine()) != null) {
                        String[] line = lines.
                                        replaceAll("[^a-zA-Z0-9_ ]", "").
                                        toLowerCase().split(" ");
                        // String[] line = lines.toLowerCase().split(" ");
                        for (String element : line) {
                            if (freqco.containsKey(element)) {
                                freqco.
                                put(element, freqco.get(element) + 1);

                            } else {
                                freqco.put(element, 1);
                            }
                            if (!freqco2.containsKey(element)) {
                                freqco2.put(element, 0);
                            }
                        }
                    }

                    while ((lines = reader2.readLine()) != null) {
                        String[] line = lines.
                                        replaceAll("[^a-zA-Z_ ]", "").
                                        toLowerCase().split(" ");
                        for (String element : line) {
                            if (freqco2.containsKey(element)) {
                                freqco2.put(element, freqco2.
                                    get(element) + 1);
                            } else {
                                freqco2.put(element, 1);
                            }
                            if (!freqco.containsKey(element)) {
                                freqco.put(element, 0);
                            }
                        }

                    }
                    System.out.print(plagPercent(
                                         freqco, freqco2) + "\t\t");
                } catch (Exception e) {
                    System.out.println("File not Found");

                } 
            }
        }
        System.out.println();
    }
    /**
     * plagrism percentage calculation.
     *
     * @param      freqco   The frequency
     * @param      freqco2  The frequency 2
     *
     * @return     { description_of_the_return_value }
     */
    public static int plagPercent(final TreeMap<String, Integer> freqco,
                                  final TreeMap<String, Integer> freqco2) {
        int sum1 = 0;
        int sum2 = 0;
        int dot = 0;
        for (String each : freqco.keySet()) {
            sum1 += freqco.get(each) * freqco.get(each);
            sum2 += freqco2.get(each) * freqco2.get(each);
            dot += freqco.get(each) * freqco2.get(each);
        }
        final int hun = 100;
        return ((int) ((dot / (Math.sqrt(sum1) * Math.sqrt(sum2))) * hun));
    }

}
