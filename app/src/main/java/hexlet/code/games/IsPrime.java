package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

public class IsPrime {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN = 1;
    private static final int MAX = 100;

    private static String[] generateData() {
        var data = new String[Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        int num = Helper.getRandomNumber(MIN, MAX);
        String answer = isPrime(num) ? "yes" : "no";

        data[Engine.QUESTION_INDEX] = Integer.toString(num);
        data[Engine.ANSWER_INDEX] = answer;

        return data;
    }

    private static boolean isPrime(int x) {
        if (x == 0 || x == 1) {
            return false;
        }

        for (var i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void play() {
        var data = new String[Engine.ROUNDS_AMOUNT][Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        for (var round = 0; round < Engine.ROUNDS_AMOUNT; round++) {
            data[round] = generateData();
        }

        Engine.run(DESCRIPTION, data);
    }
}
