package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

public class IsEven {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN = 1;
    private static final int MAX = 100;

    private static boolean isEven(int x) {
        return x % 2 == 0;
    }

    private static String[][] generateData() {
        var data = new String[Engine.ROUNDS_AMOUNT][Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        for (var round = 0; round < Engine.ROUNDS_AMOUNT; round++) {
            int num = Helper.getRandomNumber(MIN, MAX);
            String answer = isEven(num) ? "yes" : "no";

            data[round][Engine.QUESTION_INDEX] = Integer.toString(num);
            data[round][Engine.ANSWER_INDEX] = answer;
        }

        return data;
    }

    public static void play() {
        String[][] data = generateData();

        Engine.run(DESCRIPTION, data);
    }
}
