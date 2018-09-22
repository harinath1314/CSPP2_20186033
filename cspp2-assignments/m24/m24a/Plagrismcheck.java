/**
 *this is a program for plagarism detection.
 * author:harinath reddy
 * date: 20/9/18.
 */
import java.io.FileReader;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;
/**
 * Class for plagrism.
 */
class Plagrismcheck {
    /**
     * this is the main function.
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File test = new File(input.nextLine());
        File[] tested = test.listFiles();
        Arrays.sort(tested);
        for (File name : tested) {
            System.out.print("\t" + name.getName());
        }
        try {
            for (File each : tested) {
                String input1 = new String(Files.readAllBytes(Paths.get(each.getAbsolutePath())));
                System.out.println();
                System.out.print(each.getName() + "\t");
                for (File next : tested) {
                    String input2 = new String(Files.readAllBytes(Paths.get(next.getAbsolutePath())));
                    TreeMap<String, Integer> freq = new TreeMap<>();
                    TreeMap<String, Integer> freq2 = new TreeMap<>();
                    String[] line = input2.replaceAll("[^a-zA-Z_ ]", "").replaceAll("\n","").toLowerCase().split(" ");
                    for (String elem : line) {
                        if (freq.containsKey(elem)) {
                            freq.put(elem, freq.get(elem) + 1);
                        } else {
                            freq.put(elem, 1);
                        }
                        if (!freq2.containsKey(elem)) {
                            freq2.put(elem, 0);
                        }
                    }
                    String [] line2 = input1.replaceAll("[^a-zA-Z_ ]", "").replaceAll("\n","").toLowerCase().split(" ");
                    for (String elem : line2) {
                        if (freq2.containsKey(elem)) {
                            freq2.put(elem, freq2.get(elem) + 1);
                        } else {
                            freq2.put(elem, 1);
                        }
                        if (!freq.containsKey(elem)) {
                            freq.put(elem, 0);
                        }
                    }
                    System.out.print(plag_percent(freq, freq2) + "\t");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");

        } catch (IOException e) {
            System.out.println("Invalid Input");
        }
        System.out.println();
    }
    /**
     * plagrism percentage calculation.
     * @param      freq   The frequency
     * @param      freq2  The frequency 2
     * @return     { description_of_the_return_value }
     */
    public static int plag_percent(TreeMap<String, Integer> freq,
                                   TreeMap<String, Integer> freq2) {
        int sum = 0,sum2 = 0,dot = 0;
        for (String each : freq.keySet()) {
            sum += freq.get(each) * freq.get(each);
            sum2 += freq2.get(each) * freq2.get(each);
            dot += freq.get(each) * freq2.get(each);
        }
        return ((int)((dot / (Math.sqrt(sum) * Math.sqrt(sum2))) * 100));
    }
}
