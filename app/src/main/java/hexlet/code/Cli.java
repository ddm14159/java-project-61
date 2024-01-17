package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greet() {
        String welcomeMessage = "Welcome to the Brain Games!";
        String nameQuestion = "May I have your name?";
        String greeting = "Hello, %s!";

        Scanner scan = new Scanner(System.in);

        System.out.println(welcomeMessage);
        System.out.println(nameQuestion);

        String userName = scan.nextLine();
        System.out.printf(greeting, userName);
    }
}
