package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

public class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final String HIDDEN = "..";

    private static String[] generateData() {
        var data = new String[Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        int firstNumber = Helper.getRandomNumber(MIN, MAX);
        int step = Helper.getRandomNumber(MIN, MAX);
        int controlIndex = Helper.getRandomNumber(0, PROGRESSION_LENGTH - 1);
        String[] progression = getProgression(firstNumber, step, PROGRESSION_LENGTH);
        String answer = progression[controlIndex];
        progression[controlIndex] = HIDDEN;

        data[Engine.QUESTION_INDEX] = String.join(" ", progression);
        data[Engine.ANSWER_INDEX] = answer;

        return data;
    }

    private static String[] getProgression(int firstNumber, int step, int length) {
        var progression = new String[length];

        for (int i = 0; i < length; i += 1) {
            progression[i] = Integer.toString(firstNumber + i * step);
        }

        return progression;
    }

    public static void play() {
        var data = new String[Engine.ROUNDS_AMOUNT][Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        for (var round = 0; round < Engine.ROUNDS_AMOUNT; round++) {
            data[round] = generateData();
        }

        Engine.run(DESCRIPTION, data);
    }
}
