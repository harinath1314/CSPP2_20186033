// import java.util.Scanner;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Class for show.
 */

class Show {
    /**
     * class variable for name of the movie.
     */
    private String movieName;
    /**
     * time of the movie.
     */
    private String movieTime;
    /**
     * Seats available for the show.
     */
    private String[] movieSeats;
    /**
     * Constructs the object.
     *
     * @param      movie     The movie
     * @param      showTime  The show time
     * @param      seats     The seats
     */

    Show(final String movie, String showTime, String[] seats) {
        movieName = movie;
        movieTime = showTime;
        movieSeats = seats;
    }
   /**
     * Gets the movie.
     *
     * @return     The movie.
     */
    String getMovie() {
        return movieName;
    }

    /**
     * Gets the movie time.
     *
     * @return     The movie time.
     */
    String getMovieTime() {
        return movieTime;
    }

    /**
     * Gets the seats.
     *
     * @return     The seats.
     */
    String[] getSeats () {
        return movieSeats;
    }

    /**
     * Sets the seats.
     *
     * @param      index  The index
     */
    void setSeats(int index) {
        movieSeats[index] = "N/A";
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return movieName + "," + movieTime;
    }
}
/**
 * Class for book your show.
 */
class BookYourShow {
    ArrayList<Show> showList;
    ArrayList<String> ticketList;
    /**
     * Constructs the object.
     */
    BookYourShow() {
        showList = new ArrayList<>();
        ticketList = new ArrayList<>();
    }
    /**
     * Adds a show.
     *
     * @param      shw   The shw
     */
    void addAShow(Show shw) {
        showList.add(shw);
    }
    /**
     * Gets a show.
     *
     * @param      mve      The mve
     * @param      mvetime  The mvetime
     *
     * @return     A show.
     */
    Show getAShow(String mve, String mvetime) {
        for (Show show : showList)
            if (show.getMovie().equals(mve) && show.getMovieTime().equals(mvetime))
                return show;
        return null;
    }
    /**
     * { function_description }
     *
     * @param      movie     The movie
     * @param      showTime  The show time
     * @param      patron    The patron
     * @param      seats     The seats
     */
    void bookAShow(String movie, String showTime, Patron patron, String[] seats) {
        Show show = getAShow(movie, showTime);
        if (show == null) {
            System.out.println("No show");
            return;
        }
        boolean flag = false;
        String[] sseats = show.getSeats();
        for (String seat : seats) {
            for (int i = 0; i < seats.length; i++) {
                if (seat.equals(sseats[i]))
                    show.setSeats(i);
                flag = true;
            }
        }
        if (flag) {
            ticketList.add(patron.getNumber() + " " + movie + " " + showTime);
        }
    }
    /**
     * { function_description }
     *
     * @param      movie     The movie
     * @param      showTime  The show time
     * @param      number    The number
     */
    void printTicket(String movie, String showTime, String number) {
        String t = number + " " + movie + " " + showTime;
        for (String ticket : ticketList ) {
            if (t.equals(ticket)) {
                System.out.println(t);
            } else {
                System.out.println("Invalid");
            }
        }
    }
    /**
     * Shows all.
     */
    void showAll() {
        for (Show show : showList ) {
            System.out.println(show.toString() + "," + Arrays.toString(show.getSeats()).replace(" ", ""));
        }
    }

}

/**
 * Class for patron.
 */
class Patron {

    private String patName;
    private String patNumber;

    /**
     * Constructs the object.
     */
    Patron(String nm, String mob) {
        patName = nm;
        patNumber = mob;
    }

    /**
     * Gets the name.
     *
     * @return     The name.
     */
    String getName() {
        return patName;
    }

    /**
     * Gets the number.
     *
     * @return     The number.
     */
    String getNumber() {
        return patNumber;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return patName + " " + patNumber;
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
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                              replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
            case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

            case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.bookAShow(check[1], tokens[1],
                              new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

            case "get":
                Show show = bys.getAShow(check[1], tokens[1]);
                if (show != null) {
                    System.out.println(show);
                } else {
                    System.out.println("No show");
                }
                break;

            case "print":
                bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

            case "showAll":
                bys.showAll();
                break;

            default:
                break;
            }
        }
    }
}

