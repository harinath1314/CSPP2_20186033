import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	* Constructs the object.
	*/
	private Solution() {
		// leave this blank
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this Quiz
		Quiz q = new Quiz();
		// code to read the test cases input file
		Scanner s = new Scanner(System.in);
		// check if there is one more line to process
		while (s.hasNext()) {
			// read the line
			String line = s.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "LOAD_QUESTIONS":
				System.out.println("|----------------|");
				System.out.println("| Load Questions |");
				System.out.println("|----------------|");
				loadQuestions(s, q, Integer.parseInt(tokens[1]));
				break;
			case "START_QUIZ":
				System.out.println("|------------|");
				System.out.println("| Start Quiz |");
				System.out.println("|------------|");
				startQuiz(s, q, Integer.parseInt(tokens[1]));
				break;
			case "SCORE_REPORT":
				System.out.println("|--------------|");
				System.out.println("| Score Report |");
				System.out.println("|--------------|");
				displayScore(q);
				break;
			default:
				break;
			}
		}
	}
	/**
	 * Loads questions.
	 *
	 * @param      s              The scanner object for user input
	 * @param      quiz           The quiz object
	 * @param      questionCount  The question count
	 */
	public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
		if ( questionCount >= 1) {
			System.out.println(questionCount + " are added to the quiz");
			for (int i = 0; i < questionCount; i++) {
				String line =  s.nextLine();
				String[] parts = line.split(":");
				quiz.addQuestion( parts[0]);
				quiz.addchoices( parts[1]);
				quiz.addrightans( parts[2]);
				quiz.addmaxmarks( parts[3]);
				quiz.addpenalty( parts[4]);
			}
		} else {
			System.out.println("Quiz does not have questions");
		}
	}

	/**
	 * Starts a quiz.
	 *
	 * @param      s            The scanner object for user input
	 * @param      quiz         The quiz object
	 * @param      answerCount  The answer count
	 */
	public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
		// write your code here to display the quiz questions
		// read the user responses from the console
		// store the user respones in the quiz object
		int k = 1;
		for (int i = 0; i < answerCount; i++) {
			if (k > 4 ) {
				k = 1;
			}
			System.out.println(quiz.getQuestion(i) + "(" + k + ")");
			String[] choicesare = quiz.getchoices(i).split(",");
			for (int l = 0; l < 3 ; l++) {
				System.out.print(choicesare[l] + "\t");
			}
			System.out.println(choicesare[3]);
			System.out.println();
			String chosen = s.nextLine();
			quiz.addchosenans(chosen);
			k++;
		}
	}
	/**
	 * Displays the score report
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report
		int totalScore = 0;
		for (int i = 0; i < (quiz.size); i++) {
			// System.out.println(i);
			System.out.println(quiz.getQuestion(i));
			String refer = quiz.getchosen(i);
			// System.out.println(refer);
			String[] reference = refer.split(" ");
			// System.out.println(Arrays.toString(quiz.rightans));
			// System.out.println(Arrays.toString(quiz.chosenans));

			if (reference[1].equals(quiz.getrightans(i))) {
				System.out.println(" Correct Answer! - Marks Awarded: " + quiz.getmaxmarks(i));
				totalScore = totalScore + Integer.parseInt(quiz.getmaxmarks(i));
			} else {
				System.out.println(" Wrong Answer! - Penalty: " + quiz.getpenalty(i));
				totalScore = totalScore + Integer.parseInt(quiz.getpenalty(i));
			}
		}
		System.out.println("Total Score: " + totalScore);

	}
}

class Quiz {
	public String[] questions;
	public String[] choices;
	public String[] rightans;
	public String[] maxmarks;
	public String[] penalty;
	public String[] chosenans;
	public int size;
	public int sizz;

	Quiz() {
		questions = new String[14];
		choices = new String[14];
		rightans = new String[14];
		maxmarks = new String[14];
		penalty = new String[14];
		chosenans = new String[14];
		size = 0;

	}
	public void addQuestion( String quest) {
		questions[size] = quest;
	}

	public void addchoices(String choice) {
		choices[size] = choice;
	}

	public void addrightans(String right) {
		rightans[size] = right;
	}

	public void addmaxmarks( String maxmar) {
		maxmarks[size] = maxmar;
	}

	public void addpenalty(String penal) {
		penalty[size] = penal;
		size++;
	}


	public String getpenalty(int index) {
		return penalty[index];
	}

	public String getQuestion(int index) {
		return questions[index];
	}

	public String getchoices(int index) {
		return choices[index];
	}

	public String getrightans(int index) {
		return rightans[index];
	}

	public String getmaxmarks(int index) {
		return maxmarks[index];
	}

	public void addchosenans(String chosen) {
		chosenans[sizz++] = chosen;

	}
	public String getchosen(int index) {
		return chosenans[index];
	}
}
