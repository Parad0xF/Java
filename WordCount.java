import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
	    Scanner keyboard = new Scanner(System.in);
	    System.out.println("Please enter a string or type QUIT to exit:");
	    String userInput = keyboard.nextLine();

        while (!userInput.equalsIgnoreCase("quit")) {
            System.out.printf("There are %d word in or type QUIT to exit:", wordCount(userInput));
            System.out.println("Please enter a string or type QUIT to exit:");
            userInput = keyboard.nextLine();

        }

    }

    private static int wordCount(String userInput){
        StringTokenizer st = new StringTokenizer(userInput, " \t\n\r\f.?!");

        return st.countTokens();

    }
}
