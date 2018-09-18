import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**.
 * Class for fit byte.
 */
public class fitByte {
    /**
     * this is the maiin function.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner inputdata = new Scanner(new BufferedInputStream(System.in));
        ArrayList<Food> foodlog = new ArrayList<>();
        ArrayList<Drinking> drinkinglog = new ArrayList<>();
        ArrayList<PhyActivity> phyActivitylog = new ArrayList<>();
        ArrayList<Weight> weightlog = new ArrayList<>();
        ArrayList<Sleep> sleeplog = new ArrayList<>();

        while (inputdata.hasNext()) {
            String[] tokens = inputdata.nextLine().split(",");
            switch (tokens[0]) {
            case "Food":
                foodlog.add(new Food(tokens[1], tokens[2],
                                     Integer.parseInt(tokens[2 + 1])));
                break;
            case"Water":
                drinkinglog.add(new Drinking(tokens[2],
                                             Integer.parseInt(tokens[1])));
                break;
            case"PhysicalActivity":
                if (tokens.length == 2 + 2 + 1) {
                    phyActivitylog.add(new PhyActivity(tokens[1], tokens[2],
                                                       tokens[2 + 1], tokens[2 + 2]));
                    break;
                } else {
                    phyActivitylog.add(new PhyActivity(tokens[1], tokens[2],
                                                       tokens[2 + 1], tokens[2 + 2], tokens[2 + 2 + 1]));
                    break;
                }
            case"Weight":
                weightlog.add(new Weight(tokens[1], tokens[2],
                                         tokens[2 + 1]));
                break;
            case"Sleep":
                sleeplog.add(new Sleep(tokens[1], tokens[2]));
                break;
            case"Foodlog":
                for (Food e : foodlog) {
                    // if (tokens[1].equals(e.getdate_time())) {
                    System.out.println(e);
                    // }
                    System.out.println();
                }
                break;
            case"Waterlog":
                for (Drinking e : drinkinglog) {
                    // if (tokens[1].equals(e.getdate_time())) {
                    System.out.println(e);
                    // }
                    System.out.println();
                }
                break;
            case"PhysicalActivitylog":
                for (PhyActivity e : phyActivitylog) {
                    // if (tokens[1].equals(e.getdate())) {
                    System.out.println(e);
                    // }
                    System.out.println();
                }
                break;
            case"Weightlog":
                for (Weight e : weightlog) {
                    // if (tokens[1].equals(e.getdate())) {
                    System.out.println(e);
                    // }
                    System.out.println();
                }
                break;
            case"Sleeplog":
                for (Sleep e : sleeplog) {
                    // if (tokens[1].equals(e.getdate_start())) {
                    System.out.println(e);
                    // }
                    System.out.println();
                }
                break;
            case"Summary":
                for (Food e : foodlog) {
                    System.out.println(e);
                }
                for (Drinking e : drinkinglog) {
                    System.out.println(e);
                }
                for (PhyActivity e : phyActivitylog) {
                    System.out.println(e);
                }
                for (Weight e : weightlog) {
                    System.out.println(e);
                }
                for (Sleep e : sleeplog) {
                    System.out.println(e);
                }

            case"reset":
                foodlog = new ArrayList<>();
                drinkinglog = new ArrayList<>();
                phyActivitylog = new ArrayList<>();
                sleeplog = new ArrayList<>();
                weightlog = new ArrayList<>();
                break;
            default:
                break;
            }
        }
    }
}

/**
 * Class for food.
 */
class Food {
    private String date_time;
    private String fooditem;
    private int quantity;
    /**
     * Constructs the object.
     *
     * @param      d     { parameter_description }
     * @param      f     { parameter_description }
     * @param      q     The quarter
     */
    Food(final String d, final String f, final int q) {
        this.fooditem = d;
        this.date_time = f;
        this.quantity = q;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getfooditem() {
        return fooditem;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getdate_time() {
        return date_time;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getquantity() {
        return quantity;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return "Food: \n" + "name: " + fooditem + "\n" + "Date and time: "
               + date_time + "\n" + "Quantity: " + quantity ;

    }
}
/**
 * Class for drinking.
 */
class Drinking {
    private String date_time;
    private int quantity;
    /**
     * Constructs the object.
     *
     * @param      date_ti  The date ti
     * @param      quant    The quant
     */
    Drinking(final String date_ti, final int quant) {
        this.date_time = date_ti;
        this.quantity = quant;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getquantity() {
        return quantity;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getdate_time() {
        return date_time;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return "water\n" + "Date: " + date_time + "\n" + "Quantity:" + quantity + "ml";

    }
}
/**
 * Class for phy activity.
 */
class PhyActivity {
    private String date;
    private String activity;
    private String start_time;
    private String end_time;
    private String notes;
    private boolean flag;
    /**
     * Constructs the object.
     *
     * @param      d     { parameter_description }
     * @param      a     { parameter_description }
     * @param      s     { parameter_description }
     * @param      e     { parameter_description }
     */
    PhyActivity(final String d, final String a,
                final String s, final String e) {
        this.date = d;
        this.activity = a;
        this.start_time = s;
        this.end_time = e;
        this.flag = false;
    }
    /**
     * Constructs the object.
     *
     * @param      d     { parameter_description }
     * @param      a     { parameter_description }
     * @param      s     { parameter_description }
     * @param      e     { parameter_description }
     * @param      n     { parameter_description }
     */
    PhyActivity(final String d, final String a,
                final String s, final String e, final String n) {
        this.date = d;
        this.activity = a;
        this.start_time = s;
        this.end_time = e;
        this.notes = n;
        this.flag = true;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getdate() {
        return date;
    }

    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getactivity() {
        return activity;
    }

    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getstart() {
        return start_time;
    }

    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getend() {
        return end_time;
    }

    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getnote() {
        return notes;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (flag) {
            return "PhysicalActivity\n" + "name: " + activity + "\n" + "date: " + date + "\n"
                   + "StartTime: " + start_time + "\n" + "Endtime: " + end_time + "\n" + "Notes: " + notes ;

        }
        return "PhysicalActivity\n" + "name: " + activity + "\n" + "date: " + date + "\n"
               + "StartTime: " + start_time + "\n" + "Endtime: " + end_time ;
    }


}
/**
 * Class for weight.
 */
class Weight {
    private String date;
    private String weight;
    private String fat;
    /**
     * Constructs the object.
     *
     * @param      d     { parameter_description }
     * @param      w     { parameter_description }
     * @param      f     { parameter_description }
     */
    Weight(final String d, final String w, final String f) {
        this.date = d;
        this.weight = w;
        this.fat = f;

    }
    /**
     * getdate function.
     *
     * @return     { description_of_the_return_value }
     */
    public String getdate() {
        return date;
    }
    /**
     *getweight.
     *
     * @return     { description_of_the_return_value }
     */
    public String getweight() {
        return weight;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getfat() {
        return fat;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return "Weight\n" + "Date:" + date + "\n" + "Weight" + weight + "\n" + "Fat " + fat;
    }


}
/**
 * Class for sleep.
 */
class Sleep {
    private String date_start;
    private String date_end;
    /**
     * Constructs the object.
     *
     * @param      sd    { parameter_description }
     * @param      ed    { parameter_description }
     */
    Sleep(final String sd, final String ed) {
        this.date_start = sd;
        this.date_end = ed;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getdate_start() {
        return date_start;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getdate_end() {
        return date_end;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return "Sleep\n" + "StartTime: " + date_start + "\n" + "Endtime: " + date_end ;
    }
}

