import java.util.Scanner;

public class Retail_Price_Calculator {

    public static boolean checkTheWholeSaleValue(double x){
        boolean flagNumber = false;
        if(x < -100){
            flagNumber = true;
        }
        return flagNumber;
    }

    public static boolean checkTheMarkUoValue(double x){
        boolean flagNumber = false;
        if(x < -100 ){
            flagNumber = true;
        }
        return flagNumber;
    }

    public static double calculateRetail(double x, double y){
        double total = 0;

        if(x > 0 && y > 0) {
            total = (x * (y / 100)) + x;
        }
        return total;
    }




    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);



        System.out.println("Please enter the wholesale cost or -1 exit:");
        int wholeSalePrice = keyboard.nextInt();
        checkTheWholeSaleValue(wholeSalePrice);
        if (wholeSalePrice == -1) {
            return;
        } else if (checkTheWholeSaleValue(wholeSalePrice)) {
            System.out.println("Wholesale cost cannot be a negative value.");
            while (wholeSalePrice < 0){
                System.out.println("Please enter the wholesale cost again or -1 exit:");
                wholeSalePrice = keyboard.nextInt();
            }
        }



        System.out.println("Please enter the markup percentage or -1 exit:");
        double markUpPrice = keyboard.nextInt();
        checkTheMarkUoValue(markUpPrice);
        if (markUpPrice == -1) {
            return;
        } else if (checkTheMarkUoValue(markUpPrice)) {
            System.out.println("Markup cannot be less than -100%.");
            do {
                System.out.println("Please enter the markup again or -1 exit:");
                markUpPrice = keyboard.nextInt();
            } while (markUpPrice < 0 );
        }

        System.out.println("The retail price is: " + calculateRetail(wholeSalePrice, markUpPrice) + "0");






        while (wholeSalePrice != -1 && markUpPrice != -1) {
            System.out.println("Please enter the wholesale cost or -1 exit:");
            wholeSalePrice = keyboard.nextInt();

            if (checkTheWholeSaleValue(wholeSalePrice)) {
                System.out.println("Wholesale cost cannot be a negative value.");
                while(!checkTheWholeSaleValue(wholeSalePrice)) {
                    System.out.println("Please enter the wholesale cost again or -1 exit:");
                    wholeSalePrice = keyboard.nextInt();
                }
            } else if (wholeSalePrice == -1) {
                return;
            }




            System.out.println("Please enter the markup percentage or -1 exit:");



            markUpPrice = keyboard.nextInt();
            if (checkTheMarkUoValue(markUpPrice)) {
                System.out.println("Markup cannot be less than -100%.");
                while (!checkTheMarkUoValue(markUpPrice)) {
                    System.out.println("Please enter the markup again or -1 exit:");
                    wholeSalePrice = keyboard.nextInt();
                }
            } else if (markUpPrice == -1) {
                    return;
                }

            System.out.println("The retail price is: " + calculateRetail(wholeSalePrice, markUpPrice) + "0");
        }
    }
}
