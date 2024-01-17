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

    private static String[] generateData() {
        var data = new String[2];

        int num = Helper.getRandomNumber(MIN, MAX);
        String answer = isEven(num) ? "yes" : "no";

        data[Engine.QUESTION_INDEX] = Integer.toString(num);
        data[Engine.ANSWER_INDEX] = answer;

        return data;
    }

    public static void play() {
        var data = new String[Engine.ROUNDS_AMOUNT][Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        for (var round = 0; round < Engine.ROUNDS_AMOUNT; round++) {
            data[round] = generateData();
        }

        Engine.run(DESCRIPTION, data);
    }
}
