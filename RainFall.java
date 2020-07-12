import java.util.Scanner;

public class RainFall {

    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);
        double[] rainfall = new double[12];
        for(int index = 0 ; index < rainfall.length; index++){
            System.out.printf("Enter the rainfall amount for month %d:\n", index+1);
            rainfall[index] = keyboard.nextDouble();

        }
        System.out.printf("Maximum rainfall: %s, %.1f inches\n", monthMax(rainfall), max(rainfall));
        System.out.printf("Minimum rainfall: %s, %.1f inches\n", monthMin(rainfall), min(rainfall));
        System.out.printf("Total rainfall: %.1f inches\n", total(rainfall));
        System.out.printf("Average rainfall: %.1f inches\n", average(rainfall));

    }

    private static double total(double[] rainfall){

        double sum = 0;

        for(double element : rainfall){
            sum+= element;
        }

        return sum;
    }
    private static double average(double[] rainfall){

        return total(rainfall)/rainfall.length;
    }
    private static double max(double[] rainfall){

        double currentMax = rainfall[0];
        for(int index =1 ; index <rainfall.length; index++)
        {
            if (rainfall [index ] > currentMax) {
                currentMax = rainfall[index];
            }
        }

        return currentMax;
    }
    private static double min(double[] rainfall){

        double currentMin = rainfall[0];
        for (int index = 1 ; index < rainfall.length; index++){
            if (rainfall[index]< currentMin){
                currentMin = rainfall[index];
            }
        }

        return currentMin;
    }

    private static String monthMin(double[] rainfall){
        String resultMonth = "";
        int indexMonth = 0;
        String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (int index = 0; index<rainfall.length; index++) {
            if (rainfall[index] == min(rainfall)) {
                indexMonth = index;
                resultMonth = month[indexMonth];
            }
        }

        return resultMonth;

    }

    private static String monthMax(double[] rainfall){
        String resultMonth = "";
        int indexMonth = 0;
        String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (int index = 0; index<rainfall.length; index++) {
            if (rainfall[index] == max(rainfall)) {
                indexMonth = index;
                resultMonth = month[indexMonth];
            }
        }

        return resultMonth;

    }
}
