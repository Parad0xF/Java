import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        displayMenu();

        Scanner keyboard = new Scanner(System.in);
        int userChoice = keyboard.nextInt();
        int computerChoice = 1;
        String x = decisions(userChoice);
        String b = decisions(computerChoice);
        boolean flag = true;

        while (displayTheResults(userChoice, computerChoice))
        {
            System.out.println("User decision is: " + x);
            System.out.println("Computer decision is: " + b);
            System.out.println("It's a tie! Please Try again: ");
            userChoice = keyboard.nextInt();
            x = decisions(userChoice);
        }

        if (x.equals("Paper") || x.equals("Rock") || x.equals("Scissors")) {
            getResult(x, b);
        } else
            System.out.println("Invalid Input " + userChoice);
    }




    public static void displayMenu() {

        System.out.println("Please Select from the following: \n" +
                "1. Rock\n" +
                "2. Paper\n" +
                "3. Scissors\n");

        String r = "Rock";
        String p = "Paper";
        String s = "Scissors";

    }

    public static Boolean displayTheResults(int userChoice, int computerChoice) {
        boolean even = false;
        if (userChoice == computerChoice) {
            even = true;
        }
        return even;
    }

    public static int rand() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    public static String decisions(int x) {
        String r = "Rock";
        String p = "Paper";
        String s = "Scissors";

        String decis = "";

        if (x == 1) {
            decis += r;

        }
        if (x == 2) {
            decis += p;
        }
        if (x == 3) {
            decis += s;
        }

        return decis;
    }

    public static void getResult(String usersMove, String computersMove) {
        System.out.println("User decision is: " + usersMove);
        System.out.println("Computer decision is: " + computersMove);

        if (usersMove.equals(computersMove)) {
            System.out.println("It's a tie!");
        } else if (usersMove.equals("Rock")) {
            if (computersMove.equals("Scissors"))
                System.out.println("You win!! Rock crushes scissors.");
            else if (computersMove.equals("Paper"))
                System.out.println("You lose!! Paper eats rock.");
        } else if (usersMove.equals("Paper")) {
            if (computersMove.equals("Rock"))
                System.out.println("You win!! Paper eats rock.");
            else if (computersMove.equals("Scissors"))
                System.out.println("You lose!! Scissor cuts paper.");
        } else if (usersMove.equals("Scissors")) {
            if (computersMove.equals("Papers"))
                System.out.println("You win!! Scissor cuts paper.");
            else if (computersMove.equals("Rock"))
                System.out.println("You lose!! Rock breaks scissors.");
        } else
            System.out.println("Invalid user input.");
    }
}

/*1. When the program begins, a random number in the range of 1 through 3 is generated. If the number is 1, then the computer has chosen rock. If the number is 2, then the computer
        has chosen paper. If the number is 3, then the computer has chosen scissors. (Don�t display the computer�s choice yet.)
        2. The user enters his or her choice of "rock", "paper", or "scissors" at the keyboard. (You can use a menu if you prefer.)
        3. The computer�s choice is displayed.
        4. A winner is selected according to the following rules:
        If one player chooses rock and the other player chooses scissors, then rock wins. (The rock smashes the scissors.)
        If one player chooses scissors and the other player chooses paper, then scissors wins. (Scissors cuts paper.)
        If one player chooses paper and the other player chooses rock, then paper wins. (Paper wraps rock.)
        If both players make the same choice, the game must be played again to determine the winner.
        Be sure to divide the program into methods that perform each major task.
*/