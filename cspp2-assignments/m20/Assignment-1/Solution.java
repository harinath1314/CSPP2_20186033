import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private String correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
             final String correctAnswer1,
             final int maxMarks1, final int penalty1) {
        this.questiontext = question1;
        this.choices = choices1;
        this.correctAnswer = correctAnswer1;
        this.maxMarks = maxMarks1;
        this.penalty = penalty1;


    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        String[] refer = choice.split(" ");
        switch (refer[1]) {
        case "a":
            refer[1] = "1";
            break;
        case "b":
            refer[1] = "2";
            break;
        case "c":
            refer[1] = "3";
            break;
        case "d":
            refer[1] = "4";
            break;
        default:
            break;
        }

        if ((this.correctAnswer).equals(refer[1])) {
            return true;
        }
        return false;

    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private static int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[onehundred];
        size = 0;

    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;

    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        return s;
    }
    /**.
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public static int getsize() {
        return size;
    }

}
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
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                if (Integer.parseInt(tokens[1]) >= 1) {
                    loadQuestions(s, q, Integer.parseInt(tokens[1]));
                    break;
                }

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
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
                                     final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (q == 0) {
            System.out.println("Quiz does not have questions");
        } else{
        final int three = 3, four = 4, five = 5;
        for (int i = 0; i < q; i++) {
            String line =  scan.nextLine();
            String[] parts = line.split(":");
            String[] choicelist = parts[1].split(",");
            if (parts.length != five) {
                System.out.println("Error! Malformed question");
                break;
            } else {
                if (choicelist.length < 2) {
                    System.out.println(parts[0]
                                       + "does not have enough answer choices");
                    break;
                } else {
                    if (Integer.parseInt(parts[2])
                            < 1 || Integer.parseInt(parts[2])
                            > choicelist.length) {
                        System.out.println(
                            "Error! Correct answer choice"
                            + "number is out of range for "
                            + parts[0]);
                        break;

                    } else {
                        if (Integer.parseInt(parts[three]) > 0) {
                            if (Integer.parseInt(parts[four]) <= 0) {
                                Question w = new Question(parts[0], choicelist,
                                    (parts[2]), Integer.parseInt(parts[three]),
                                    Integer.parseInt(parts[four]));
                                quiz.addQuestion(w);

                            } else {
                                System.out.println("Invalid max marks for "
                                                   + parts[0]);
                                break;
                            }

                        } else {
                            System.out.println("Invalid max marks for "
                                               + parts[0]);
                            break;

                        }
                    }


                }

            }
        }



        }
        if (Quiz.getsize() == q) {
            System.out.println(q + " are added to the quiz");
        }

    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
                                 final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        //
        for (int i = 0; i < quiz.getsize(); i++) {
            int j;
            System.out.println((quiz.getQuestion(i)).getQuestionText()
                               + "(" + (quiz.getQuestion(i)).getMaxMarks() + ")");
            for (j = 0; j
                    < (((quiz.getQuestion(i)).getChoice()).length) - 1; j++) {
                System.out.print(((quiz.getQuestion(i)).getChoice())[j] + "\t");

            }
            System.out.print(((quiz.getQuestion(i)).getChoice())[j]);
            System.out.println();
            System.out.println();
            quiz.getQuestion(i).setResponse(scan.nextLine());

        }

    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        int totalscore = 0;
        for (int i = 0; i < quiz.getsize(); i++) {
            Question l = quiz.getQuestion(i);
            System.out.println(l.getQuestionText());
            if (l.evaluateResponse(l.getResponse())) {
                System.out.println(" Correct Answer! - Marks Awarded: "
                                   + l.getMaxMarks());
                totalscore += l.getMaxMarks();
            } else {
                System.out.println(" Wrong Answer! - Penalty: "
                                   + l.getPenalty());
                totalscore += l.getPenalty();

            }


        }
        System.out.println("Total Score: " + totalscore);
    }
}

