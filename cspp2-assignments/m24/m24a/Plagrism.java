/**
 *this is a program for plagarism detection.
 * author:harinath reddy
 * date: 20/9/18.
 */
import java.io.FileReader;
import java.lang.*;
import java.io.*;
import java.util.*;
/**
 * Class for plagrism.
 */
class Plagrism {
    /**
     * this is the main function.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // while(input.hasNext()){
        //     throw new FileNotFoundException();
        // }
        try{
            if(input.nextLine().length() == 0)
                throw new Exception();
        } catch (Exception e){
            System.out.println("empty directory");
            return;
        }
        File test = new File(input.nextLine());

        File[] tested = test.listFiles();
        // System.out.print("\t\t");
        Arrays.sort(tested);
        for (File name : tested) {
            System.out.print("\t" + name.getName());

        }
        for (File each : tested) {
            String input1 = each.getAbsolutePath();
            // System.out.println(input1);
            System.out.println();

            System.out.print(each.getName() + "\t");

            for (File next : tested) {
                String input2 = next.getAbsolutePath();
                // System.out.println(input2);
                try {
                    FileReader inp = new FileReader(input1);
                    if(input1.equals(null)){
                        throw new FileNotFoundException();
                    }
                    FileReader inp2 = new FileReader(input2);

                    BufferedReader buff = new BufferedReader(inp);
                    BufferedReader buff2 = new BufferedReader(inp2);
                    HashMap<String, Integer> freq = new HashMap<>();
                    HashMap<String, Integer> freq2 = new HashMap<>();

                    String lines;
                    while ((lines = buff.readLine()) != null ) {
                        String[] line = lines.replaceAll("[^a-zA-Z_0-9. ]", "").replaceAll("\n"," ").toLowerCase().split(" ");
                        // System.out.println(Arrays.toString(line));
                        // String[] line = lines.toLowerCase().split(" ");
                        // if (line[0] != "\n") {
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
                            // System.out.println(freq);

                        // }


                    }

                    while ((lines = buff2.readLine()) != null ) {
                        String [] line = lines.replaceAll("[^a-zA-Z_0-9. ]", "").replaceAll("\n"," ").toLowerCase().split(" ");


                        // String [] line = lines.toLowerCase().split(" ");
                        // if (line[0] != "\n") {
                            for (String elem : line) {
                                if (freq2.containsKey(elem)) {
                                    freq2.put(elem, freq2.get(elem) + 1);

                                } else {
                                    freq2.put(elem, 1);
                                }
                                if (!freq.containsKey(elem)) {
                                    freq.put(elem, 0);

                                }

                            }
                            // System.out.println(freq2);
                        // }



                    }
                    System.out.print(plag_percent(freq, freq2) + "\t");
                } catch (FileNotFoundException e) {
                    System.out.println("File not Found");

                } catch (IOException e) {
                    System.out.println("Invalid Input");

                }

            }

        }
        System.out.println();
        // String input1 = "dfghjklkhgvfcghj/fghjklkjh/";
        //String input2 = "/Users/harinathareddy/Desktop/MSIT COURSES/CSPP2_20186033/cspp2-assignments/m23/input002.txt";


    }
    /**
     * plagrism percentage calculation.
     *
     * @param      freq   The frequency
     * @param      freq2  The frequency 2
     *
     * @return     { description_of_the_return_value }
     */
    public static int plag_percent(HashMap<String, Integer> freq,
                                   HashMap<String, Integer> freq2) {
        int sum = 0 ;
        int sum2 = 0;
        int dot = 0;
        // System.out.println(freq + "    " + freq2);
        for (String each : freq.keySet()) {
            sum += freq.get(each) * freq.get(each);
            // System.out.println(sum);
            sum2 += freq2.get(each) * freq2.get(each);
            // System.out.println(sum2);
            dot += freq.get(each) * freq2.get(each);
            // System.out.println(dot);

        }
        return ((int)((dot / (Math.sqrt(sum) * Math.sqrt(sum2))) * 100));
    }

}
