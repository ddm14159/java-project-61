package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

public class Gcd {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN = 1;
    private static final int MAX = 100;

    private static String[] generateData() {
        var data = new String[Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        int num1 = Helper.getRandomNumber(MIN, MAX);
        int num2 = Helper.getRandomNumber(MIN, MAX);
        String answer = Integer.toString(calculateGcd(num1, num2));

        data[Engine.QUESTION_INDEX] = num1 + " " + num2;
        data[Engine.ANSWER_INDEX] = answer;

        return data;
    }

    private static int calculateGcd(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            throw new IllegalArgumentException("Numbers must be greater than 0");
        }

        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }

        return num1;
    }

    public static void play() {
        var data = new String[Engine.ROUNDS_AMOUNT][Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        for (var round = 0; round < Engine.ROUNDS_AMOUNT; round++) {
            data[round] = generateData();
        }

        Engine.run(DESCRIPTION, data);
    }
}
