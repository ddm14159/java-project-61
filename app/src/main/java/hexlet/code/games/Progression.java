package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Helper;

import java.util.Arrays;

public class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final String HIDDEN = "..";

    private static String[][] generateData() {
        var data = new String[Engine.ROUNDS_AMOUNT][Engine.ELEMENTS_FOR_ROUND_AMOUNT];

        for (var round = 0; round < Engine.ROUNDS_AMOUNT; round++) {
            int firstNumber = Helper.getRandomNumber(MIN, MAX);
            int step = Helper.getRandomNumber(MIN, MAX);
            int controlIndex = Helper.getRandomNumber(0, PROGRESSION_LENGTH - 1);
            String[] progression = getProgression(firstNumber, step);
            String answer = progression[controlIndex];
            progression[controlIndex] = HIDDEN;

            data[round][Engine.QUESTION_INDEX] = String.join(" ", progression);
            data[round][Engine.ANSWER_INDEX] = answer;
        }

        return data;
    }

    private static String[] getProgression(int firstNumber, int step) {
        var progression = new String[PROGRESSION_LENGTH];
        var i = 0;
        var j = firstNumber;

        while (i < PROGRESSION_LENGTH) {
            progression[i] = Integer.toString(j);
            i++;
            j += step;
        }

        return progression;
    }

    public static void play() {
        String[][] data = generateData();

        Engine.run(DESCRIPTION, data);
    }
}
