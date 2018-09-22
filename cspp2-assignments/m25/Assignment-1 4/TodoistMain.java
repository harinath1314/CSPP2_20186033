/**
 * Author harinatha reddy
 * date: 22:9:18
 * exam : week-4 cspp2;
 */
import java.util.Scanner;
import java.util.ArrayList;

/**
  * write your code below this comment
  */
/**
 * class of the Test is here.
 */
class Task {
    String title;
    String assignedTo;
    int timeToComplete;
    boolean important;
    boolean urgent;
    String status;
    /**.
     * constrcts the objects for Test class.
     * @param      titl  The title
     * @param      pers  The person assigned
     * @param      tim   The time taken by person
     * @param      imp   The importance of task
     * @param      urg   The urgency of the task
     * @param      stat  The status of task
     */
    Task(final String titl, final String pers, final int tim, final boolean imp, final boolean urg,
         String stat) {
        this.title = titl;
        this.assignedTo = pers;
        this.timeToComplete = tim;
        this.important = imp;
        this.urgent = urg;
        this.status = stat;

    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return title + ", " + assignedTo + ", " + timeToComplete + ", "
               + setimp() + ", " + seturg() + ", " + status;
    }
    /**.
     * set important function.
     *
     * @return     { description_of_the_return_value }
     */
    public String setimp() {
        if (important == true) {
            return  "Important";
        } else {
            return "Not Important";
        }
    }
    /**.
     * seturgent dunction.
     *
     * @return     { description_of_the_return_value }
     */
    public String seturg() {
        if (urgent == true) {
            return "Urgent";
        } else {
            return "Not Urgent";
        }
    }


}
/**
 * Class for todoist.
 */
class Todoist {
    private final ArrayList<Task> todolist;

    /**
     * Constructs the object for Todoist class.
     */
    Todoist() {
        todolist = new ArrayList<Task>();
    }
    /**
     * addtask add the Task objects.
     *
     * @param      t  is the Task object.
     */
    public void addTask(final Task t) {
        todolist.add(t);
    }
    /**
     * Gets the next task.
     *
     * @param      name  The name
     *
     * @return     The next task.
     */
    public Task getNextTask(final String name) {
        for (Task each : todolist) {
            if (((each.assignedTo.equals(name)) && (each.status.equals("todo")))
                    && ((each.important && (each.urgent!=true)))) {
                return each;
            }
        }
        return null;
    }

    // public Task getNextTask(final String name, final int num) {
    //     for (Task each : todolist) {
    //         if (((each.assignedTo == name) && (each.status == "todo"))
    //                 && ((each.important && each.urgent))) {
    //             return each;
    //         }
    //     }
    //     return null;
    // }
    /**
     * to print function
     */
    public void toprint() {
        for (Task toli : todolist) {
            System.out.println(toli);;
        }
    }
    /**
     * total time function.
     *
     * @return     { description_of_the_return_value }
     */
    public int totalTime4Completion() {
        int totaltime = 0;
        for (Task each : todolist) {
            if (each.status.equals("todo")) {
                totaltime += each.timeToComplete;
            }
        }
        return totaltime;
    }

}




/**
 * Class for todoist main.
 */
public class TodoistMain {
    /**
     * Constructs the object.
     */
    private TodoistMain() {

    }

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "task":
                testTask(tokens);
                break;
            case "add-task":
                testAddTask(todo, tokens);
                break;
            case "print-todoist":
                todo.toprint();
                break;
            case "get-next":
                System.out.println(todo.getNextTask(tokens[1]));
                break;
            // case "get-next-n":
            //     int n = Integer.parseInt(tokens[2]);
            //     Task[] tasks = todo.getNextTask(tokens[1], n);
            //     System.out.println(Arrays.deepToString(tasks));
            // break;
            case "total-time":
                System.out.println(todo.totalTime4Completion());
                break;
            default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        if (title.length() == 0) {
            throw new Exception("Title not provided");
        }
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[2 + 1]);
        if (timeToComplete < 0) {
            throw new Exception("Invalid timeToComplete " + timeToComplete);
        }
        boolean important = tokens[2 + 2].equals("y");
        boolean urgent = tokens[2 + 2 + 1].equals("y");
        String status = tokens[2 + 2 + 2];
        if (status.length() < 2 + 2) {
            throw new Exception("Invalid status " + status);
        }
        return new Task(
                   title, assignedTo, timeToComplete,
                   important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
