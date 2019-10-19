import java.util.Scanner;
import java.security.SecureRandom;

public class ArithmeticQuiz {
    private static final int CORRECT = 1;
    private static final int INCORRECT = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String repeat = "";
        int score;
        int percentScore;
        int difficulty;
        int problemType;

        // Creates 10 question quizzes until the user inputs "No".
        while(!repeat.equalsIgnoreCase("No")) {

            // Prompts user for difficulty level. If input is not valid, sets difficulty level to 1.
            System.out.println("Select a difficulty level (1, 2, 3, or 4):");
            difficulty = in.nextInt();
            if((difficulty < 1) || (difficulty > 4)) {
                System.out.println("Invalid difficulty, using difficulty level 1.");
                difficulty = 1;
            }

            // Prompts user for the problem type. If input is not valid, sets the problem type to random.
            System.out.println("Select a problem type. 1 = addition, 2 = multiplication, 3 = subtraction, 4 = division, 5 = random");
            problemType = in.nextInt();
            if((problemType < 1) || (problemType > 5)) {
                System.out.println("Invalid problem type, using type 5 (random).");
                problemType = 5;
            }

            // Creates the quiz and saves the score the user gets. generateQuestion is method used both to print
            // the question and read the answer, and it returns 1 for correct answers and 0 for incorrect answers.
            score = 0;
            for(int i = 0; i < 10; i++) {
                score += generateQuestion(in, difficulty, problemType);
            }

            // Calculates the percent score, then prints the number of correct answers, number of incorrect answers.
            // In addition, prints an positive or negative statement depending on the percent score achieved.
            percentScore = (score * 100) / 10;
            System.out.println("Correct answers: " + score);
            System.out.println("Incorrect answers: " + (10 - score));
            if(percentScore < 75) {
                System.out.println("Please ask your teacher for extra help.");
            }
            else {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }

            // Prompts user for if they would like to continue to do more
            // quizzes. Any input other than "No" will lead to another quiz.
            System.out.println("Would you like to go again? (Yes/No)");
            repeat = in.next();
        }
        in.close();
        return;
    }

    public static int generateQuestion(Scanner in, int difficulty, int problemType) {
        SecureRandom rand = new SecureRandom();
        double ans;
        double solution;
        int numA;
        int numB;
        String operation;

        // Calls method to assign two random integer values based on the difficulty to numA and numB.
        numA = generateRandomInt(difficulty);
        numB = generateRandomInt(difficulty);

        /* A switch on problemType is used to both calculate the solution for that type and
         * save a string with the word used for a question using each problem type.
         * Since two values are being changed, a method was not created for this, as it would only have one return.
         */
        if(problemType == 5) {
            problemType = rand.nextInt(4) + 1;
        }
        switch(problemType) {
            case 1:
                solution = (double) numA + numB;
                operation = "plus";
                break;
            case 2:
                solution = (double) numA * numB;
                operation = "times";
                break;
            case 3:
                solution = (double) numA - numB;
                operation = "minus";
                break;
            case 4:
                solution = (double) numA / numB;
                operation = "divided by";
                break;
            default:
                solution = (double) numA * numB;
                operation = "times";
        }

        // Using the random integers and the operation string based on problem type, the random question is printed.
        System.out.printf("How much is %d %s %d?\n", numA, operation, numB);

        // User input is scanned and checked against the solution using floating point comparison. To make user
        // input not need extreme precision, the given answer only has to be within 0.01 of the true solution.
        ans = in.nextDouble();
        if(Math.abs(ans - solution) < 0.01) {

            // If the answer was correct, prints a random positive response and returns value of 1 to be added to score.
            printRightAnswer();
            return CORRECT;
        }
        else {

            // If answer was incorrect, prints a random negative response and returns values of 0 to be added to score.
            printWrongAnswer();
            return INCORRECT;
        }
    }

    public static int generateRandomInt(int difficulty) {
        SecureRandom rand = new SecureRandom();
        switch(difficulty) {
            case 1:
                return (rand.nextInt(9) + 1);
            case 2:
                return (rand.nextInt(99) + 1);
            case 3:
                return (rand.nextInt(999) + 1);
            case 4:
                return (rand.nextInt(9999) + 1);
            default:
                return (rand.nextInt(9) + 1);
        }
    }

    public static void printWrongAnswer() {
        SecureRandom rand = new SecureRandom();
        int response = rand.nextInt(4) + 1;

        // Switch which uses the randomly generated int from 1 to 4 to print one of 4 positive responses.
        switch (response) {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
            default:
                System.out.println("Error");
        }
        return;
    }

    public static void printRightAnswer() {
        SecureRandom rand = new SecureRandom();
        int response = rand.nextInt(4) + 1;

        // Switch which uses the randomly generated int from 1 to 4 to print one of 4 negative responses.
        switch (response) {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
            default:
                System.out.println("Error");
        }
        return;
    }
}