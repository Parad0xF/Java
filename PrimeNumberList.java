import java.util.Scanner;

public class PrimeNumberList
{

    public static void primeNumberList(int in_number){
        for(int i = 2; i < in_number; i++){
            if (isPrime(i)){
                System.out.print(i+ " ");
            }
        }

    }
    public static boolean isPrime(int the_number){
        boolean primeFlag = true;
        for(int i = 2; primeFlag && i < the_number; i++ ){
            if(the_number % i  == 0){
                primeFlag = false;
            }
        }
        return primeFlag;
    }

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int userNumber = keyboard.nextInt();

        primeNumberList(userNumber);

        System.exit(0);
    }
}
