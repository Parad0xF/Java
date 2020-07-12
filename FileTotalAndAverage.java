import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileTotalAndAverage {

    public static void main(String[] args) throws FileNotFoundException {

        // get the file name from user

        Scanner keyboard = new Scanner(System.in); // reading data from keyboard

        System.out.println("Please enter the file name or type QUIT to exit:");// display data on console
        String file_name = keyboard.nextLine(); // using special method to read "\n"

        if (file_name.equalsIgnoreCase("QUIT")) {
            return;

        }
        // open file


        File file = new File(file_name);
        while (!file.exists()) {
            System.out.println("File: " + file_name + " does not exist.");
            System.out.println("Please enter the file name again or type QUIT to exit:");// display data on console
            file_name = keyboard.nextLine(); // using special method to read "\n"
            if (file_name.equalsIgnoreCase("QUIT")) {
                return;
            }
            file = new File(file_name);
        }


        keyboard = new Scanner(file);

        if (file.length() != 0){
            int the_counter = 1;
            double the_total = 0;
            double len = keyboard.nextDouble();
            the_total += len;

            while (keyboard.hasNext()) {
                String line = keyboard.nextLine();
                len = keyboard.nextDouble();
                the_counter++;
                the_total += len;
            }
            //System.out.println("File" + file_name+"is empty.");

            System.out.format("Total: %.3f%n", the_total);
            double the_average = (the_total / the_counter);
            System.out.format("Average: %.3f%n", the_average);
            keyboard.close();
        }else
        {
            System.out.println("File "+ file_name + " is empty.");
        }
    }
}


