import java.util.Scanner;
import java.util.StringTokenizer;

public class wordCount2 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a series of numbers separated only by commas or type QUIT to exit:");
        String userInput = keyboard.nextLine();

        while (!userInput.equalsIgnoreCase("quit")) {
            if (isChar(userInput)) {
                System.out.println("Invalid input.");
                System.out.println("Enter a series of numbers separated only by commas or type QUIT to exit:");
                userInput = keyboard.nextLine();

            }
            else if (userInput.isEmpty()) {
                System.out.println("Empty string.");
                System.out.println("Enter a series of numbers separated only by commas or type QUIT to exit:");
                userInput = keyboard.nextLine();
            }
            else {
                System.out.printf("The sum of those numbers is %.2f\n", wordCount(userInput));
                System.out.println("Enter a series of numbers separated only by commas or type QUIT to exit:");
                userInput = keyboard.nextLine();
            }

        }
    }
    private static boolean isChar(String userInput){
        boolean flag = false;

        for (int i = 0 ; i < userInput.length(); i++){
            if(Character.isLetter(userInput.charAt(i)))
            {
                flag = true;
            }

        }
        return flag;
    }
    private static double wordCount(String userInput){

        double the_sum = 0;
        StringTokenizer str = new StringTokenizer(userInput, ",");
        while (str.hasMoreTokens()){
            String token = str.nextToken();
            the_sum += Double.parseDouble(token);
        }

        return  the_sum;
    }

}

