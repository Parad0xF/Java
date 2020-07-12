import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArraysH {


    public static void main(String[] args) throws FileNotFoundException {


        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the file name: ");
        String fileName = keyboard.nextLine();

        File file = new File(fileName);
        while (!file.exists()) {
            System.out.printf("File '%s' does not exist.\n", fileName);
            System.out.println("Please enter the file name again: ");
            fileName = keyboard.nextLine();
            file = new File(fileName);
        }
        if (file.exists()) {
            ArrayList<ArrayList<Double>> spreadsheet = load(file);
            System.out.printf("Total: %,.3f\n", getTotal(spreadsheet));
            System.out.printf("Average: %,.3f\n", getAverage(spreadsheet));

        }
    }


    private static double getTotal(ArrayList<ArrayList<Double>> table) {
        double sum = 0.0 ;

        for(ArrayList<Double> row : table) {
            for(double number : row) {
                sum += number;
            }
        }
        return sum;

    }

    private static double getAverage(ArrayList<ArrayList<Double>> table) {

        return getTotal(table)/ table.size() / table.get(0).size();

    }




    private static ArrayList<ArrayList<Double>> load(File file) throws FileNotFoundException {
        Scanner inputFile = new Scanner(file);
        ArrayList<ArrayList<Double>> result = new ArrayList<>();
        while(inputFile.hasNext()) {
            String line = inputFile.nextLine();
            result.add(new ArrayList<Double>());
            Scanner numbers = new Scanner(line);
            while(numbers.hasNext()) {
                result.get(result.size() -1).add(numbers.nextDouble());
            }
            numbers.close();
        }
        inputFile.close();
        return (result);

    }
}




