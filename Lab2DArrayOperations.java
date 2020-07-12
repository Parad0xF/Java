
import java.lang.reflect.Array;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab2DArrayOperations {

    public static void main(String[] args) throws FileNotFoundException, NoSuchElementException, InterruptedException {

        System.out.println("Please enter the file name or type QUIT to exit:");
        Scanner keyboard = new Scanner(System.in);

        String userInput = keyboard.nextLine();
        userInput = "input8.txt";

        if (userInput.equalsIgnoreCase("quit")) {
            System.exit(0);
        }


        File file = new File(userInput);

        while (!file.exists()) {
            System.out.printf("File: %s does not exist.\n", userInput);
            System.out.print("Please enter the file name again or type QUIT to exit:\n");
            keyboard = new Scanner(System.in);
            userInput = keyboard.nextLine();

            file = new File(userInput);
            if (userInput.equalsIgnoreCase("quit")) {
                System.exit(0);
            }
        }


        if (file.exists()) {
            ArrayList<ArrayList<Double>> spreadsheet = load(file);

            for (int row = 0; row < spreadsheet.size(); row++) {
                //System.out.printf("Row %d Length: %d, Subtotal: %.3f\n", row, getLength(spreadsheet,row), getRowTotal(spreadsheet, row));
            }

            int temp = getHighestRow(spreadsheet);

            spreadsheet.forEach(System.out::println);

            for (int col = 0; col < spreadsheet.size(); col++) {
                System.out.println(getColumnTotal(spreadsheet, col));
                //System.out.printf("Column %d Height: %d, Subtotal %.3f:\n",col, getHeight(spreadsheet,col), getColumnTotal(spreadsheet,col));
            }

            //System.out.printf("Array Elements: %d, Total: %.3f\n",getTotalElements(spreadsheet), getTotal(spreadsheet));

        }
    }

    private static int getHighestRow(ArrayList<ArrayList<Double>> table) {
        int totalLength = 0;
        int temp = table.get(0).size();
        for (int col = 0; col < table.size(); col++) {
            for (int row = 0; row < table.get(col).size(); row++) {
                totalLength += 1;
            }
            if (temp < totalLength)
                temp = totalLength;

            totalLength = 0;
        }
        return temp;
    }

    private static int getHeight(ArrayList<ArrayList<Double>> table, int col) {
        int count = 0;
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).size() > col) {
                count++;
            }
        }
        return count;
    }

    private static int getLength(ArrayList<ArrayList<Double>> table, int col) {
        int totalLength = 0;
        for (int row = 0; row < table.get(col).size(); row++)
            totalLength += 1;
        return totalLength;
    }

    private static ArrayList<ArrayList<Double>> load(File file) throws FileNotFoundException {
        Scanner inputFile = new Scanner(file);
        ArrayList<ArrayList<Double>> result = new ArrayList<>();
        while (inputFile.hasNext()) {
            String line = inputFile.nextLine();
            result.add(new ArrayList<>());
            Scanner numbers = new Scanner(line);
            while (numbers.hasNext()) {
                result.get(result.size() - 1).add(numbers.nextDouble());
            }
            numbers.close();
        }
        inputFile.close();
        return (result);

    }

    private static int getTotalElements(ArrayList<ArrayList<Double>> table) {
        int temp = 0;

        for (int col = 0; col < table.size(); col++) {
            for (int row = 0; row < getHeight(table, col); row++)
                temp++;
        }

        return temp;
    }

    private static double getTotal(ArrayList<ArrayList<Double>> table) {
        double sum = 0.0;

        for (ArrayList<Double> row : table) {
            for (double number : row) {
                sum += number;
            }
        }
        return sum;

    }

    private static double getAverage(ArrayList<ArrayList<Double>> table) {

        return getTotal(table) / table.size() / table.get(0).size();

    }

    private static double getRowTotal(ArrayList<ArrayList<Double>> table, int row) {
        double sum = 0.0;
        for (double number : table.get(row)) {
            sum += number;
        }
        return sum;

    }

    private static double getColumnTotal(ArrayList<ArrayList<Double>> table, int col) {
            double sum = 0;
            //System.out.println(getHeight(table,col));

            //System.out.println(getHeight(table,row));
            //sum += table.get(row).get(col);
        return sum;
}


    private static double getHighestInRow(ArrayList<ArrayList<Double>> table, int row) {

        double highest = table.get(row).get(0);
        for(int col =1; col<table.get(row).size();col++) {
            if(highest<table.get(row).get(col)) {
                highest = table.get(row).get(col);

            }
        }
        return highest;

    }
    private static double getLowestInRow(ArrayList<ArrayList<Double>> table, int row) {

        double lowest = table.get(row).get(0);
        for(int col =1; col<table.get(row).size();col++) {
            if(lowest > table.get(row).get(col)) {
                lowest = table.get(row).get(col);
            }
        }

        return lowest;

    }
}
