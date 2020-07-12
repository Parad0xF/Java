
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	if(args.length!=1){
	    System.out.println("Usage: java ArrayOperations <filename>");

        } else {
	    File file = new File(args[0]);
	    if(!file.exists()){
	        System.out.printf("File: %s does not exist. \n", args[0]);

        } else {
	        double[] array = getArrayFromFile(file);
	        System.out.printf("Total: %,.3f\n", getTotal(array));
            System.out.printf("Average: %,.3f\n", getAverage(array));
            System.out.printf("Highest: %,.3f\n", getHighest(array));
            System.out.printf("Lowest: %,.3f\n", getLowest(array));
        }


	    }
    }
    private static double[] getArrayFromFile(File file) throws FileNotFoundException {

        Scanner inputFile = new Scanner(file);
        int count = 0;

        while (inputFile.hasNext()){
            inputFile.nextDouble();
            count++;
        }
        inputFile.close();

        double[] result = new double[count];

        inputFile = new Scanner(file);

        int index = 0;

        while (inputFile.hasNext()){
            result[index] = inputFile.nextDouble();
            index++;
        }
        inputFile.close();

        return result;

    }

    private static double getTotal(double[] array){

        return 0;
    }
    private static double getAverage(double[] array){

        return getTotal(array) /  array.length;
    }
    private static double getHighest(double[] array){

        return 0;
    }
    private static double getLowest(double[] array){

        return 0;
    }
}
