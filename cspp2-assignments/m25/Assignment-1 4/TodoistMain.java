/**
 * Author harinatha reddy
 * date: 22:9:18
 * exam : week-4 cspp2;
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
  * write your code below this comment
  */
/**
 * class of the Test is here.
 */
class Task{
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
	Task(String titl, String pers, int tim, boolean imp, boolean urg, String stat) {
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
	public String toString(){
		return title +", "+assignedTo+", "+timeToComplete+", "+setimp()+", "+seturg()+", "+status;
	}
	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String setimp() {
		if(important == true) {
			return  "Important";
		}else{
			return "Not Important";
		}
	}

	public String seturg(){
		if (urgent == true){
			return "Urgent";
		}else{
			return "Not Urgent";
		}
	}
	// public String setstat() {
	// 	if (status == todo){
	// 		return "todo";
	// 	}
	// }

}
/**
 * Class for todoist.
 */






// class Todoist{
// 	public ArrayList<Task> todolist = new ArrayList<Task>();

// }




/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        // Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                // case "add-task":
                //     testAddTask(todo, tokens);
                // break;
                // case "print-todoist":
                //     System.out.println(todo);
                // break;
                // case "get-next":
                //     System.out.println(todo.getNextTask(tokens[1]));
                // break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
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
    // public static void testAddTask(final Todoist todo, final String[] tokens) {
    //     try {
    //         todo.addTask(createTask(tokens));
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    // }

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
            // System.out.println("title not provided");
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
        if(title.length() == 0){
        	throw new Exception("Title not provide");
        }
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
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
