import java.util.Scanner;

public class Methods {

    public static boolean isPrime(int the_number){
        boolean primeFlag = true;
        for(int i = 2; primeFlag && i < the_number; i++ ){
                if(the_number % i  == 0){
                    primeFlag = false;
                }else {
                    primeFlag = true;
                }
            }

        return primeFlag;
    }

    public static int promptAndGetTheNumber(Scanner keyboard){
        System.out.println("Please enter a number to check for primality or -1 to exit:");
        int userNumber = keyboard.nextInt();
        return userNumber;
    }

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter a number to check for primality or -1 to exit:");
        int userNumber = keyboard.nextInt();

        while (userNumber != -1){
            while(userNumber < -1 || userNumber ==  0){
                System.out.println("Invalid input.");
                userNumber = promptAndGetTheNumber(keyboard);
                }
            System.out.printf("%d is %sa prime number.\n",
                    userNumber,
                    isPrime(userNumber) ? "": "not ");

            userNumber = promptAndGetTheNumber(keyboard);
            }
        System.exit(0);
    }
}
