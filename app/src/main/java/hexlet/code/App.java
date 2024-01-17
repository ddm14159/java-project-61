package hexlet.code;

import hexlet.code.games.IsEven;

import java.util.Scanner;

public class App {
    private static final String INTRO = "Please enter the game number and press Enter.";
    private static final String OUTRO = "Bye-bye!";
    private static final String OPTION_GREET = "Greet";
    private static final String OPTION_IS_EVEN = "Even";
    private static final String OPTION_EXIT = "Exit";
    private static final String LINE_SEPARATOR = "\n";
    public static void main(String[] args) {
        System.out.println(INTRO);
        System.out.println(
                "1 - " + OPTION_GREET + LINE_SEPARATOR
              + "2 - " + OPTION_IS_EVEN + LINE_SEPARATOR
              + "0 - " + OPTION_EXIT + LINE_SEPARATOR
        );

        Scanner scan = new Scanner(System.in);
        String option = scan.nextLine();

        switch (option) {
            case "1":
                Cli.greet();
                break;
            case "2":
                IsEven.play();
                break;
            case "0":
            default:
                System.out.println(OUTRO);
                break;
        }
    }
}
