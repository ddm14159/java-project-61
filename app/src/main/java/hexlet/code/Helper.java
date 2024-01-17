package hexlet.code;

public class Helper {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static <T> T getRandomArrayElement(T[] array) {
        var length = array.length;
        var randomIndex = getRandomNumber(0, length - 1);

        return array[randomIndex];
    }
}
