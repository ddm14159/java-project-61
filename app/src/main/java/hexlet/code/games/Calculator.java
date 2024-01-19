package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

public class Calculator {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final String[] OPERATORS = {" + ", " - ", " * "};

    private static String[] generateData() {
        var data = new String[Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        int num1 = Helper.getRandomNumber(MIN, MAX);
        int num2 = Helper.getRandomNumber(MIN, MAX);
        String operator = Helper.getRandomArrayElement(OPERATORS);
        String answer = Integer.toString(calculate(num1, num2, operator));

        data[Engine.QUESTION_INDEX] = num1 + operator + num2;
        data[Engine.ANSWER_INDEX] = answer;

        return data;
    }

    private static int calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case " + " -> num1 + num2;
            case " - " -> num1 - num2;
            case " * " -> num1 * num2;
            default -> throw new IllegalArgumentException("Operator must be one of:" + String.join(",", OPERATORS));
        };
    }

    public static void play() {
        var data = new String[Engine.ROUNDS_AMOUNT][Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        for (var round = 0; round < Engine.ROUNDS_AMOUNT; round++) {
            data[round] = generateData();
        }

        Engine.run(DESCRIPTION, data);
    }
}
