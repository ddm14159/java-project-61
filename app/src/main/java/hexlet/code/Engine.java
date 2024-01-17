package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_AMOUNT = 3;
    public static final int ELEMENTS_FOR_ROUND_AMOUNT = 2;
    public static final int QUESTION_INDEX = 0;
    public static final int ANSWER_INDEX = 1;
    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String NAME_QUESTION = "May I have your name?";
    public static final String GREETING = "Hello, %s!\n";
    private static final String QUESTION = "Question: ";
    private static final String ANSWER = "Your answer: ";
    private static final String APPROVE = "Correct!";
    private static final String REJECT = "Let's try again, %s!\n";
    private static final String CONGRATULATION = "Congratulations, %s!\n";
    
    public static void run(String description, String[][] data) {
        Scanner scan = new Scanner(System.in);

        System.out.println(WELCOME_MESSAGE);
        System.out.println(NAME_QUESTION);
        String userName = scan.nextLine();
        System.out.printf(GREETING, userName);

        System.out.println(description);

        for (var round = 0; round < ROUNDS_AMOUNT; round++) {
            System.out.println(QUESTION + data[round][QUESTION_INDEX]);
            System.out.print(ANSWER);
            String userAnswer = scan.nextLine();

            if (!userAnswer.equals(data[round][ANSWER_INDEX])) {
                System.out.printf(REJECT, userName);
                return;
            }

            System.out.println(APPROVE);
        }

        System.out.printf(CONGRATULATION, userName);
    }
}
