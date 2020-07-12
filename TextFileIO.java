import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;


public class TextFileIO

{
    public static void main(String[] args) throws IOException{



        // get the file name from user

        Scanner keyboard = new Scanner(System.in); // reading data from keyboard

        System.out.println("Please enter the file name or type QUIT to exit:");// display data on console
        String filename = keyboard.nextLine(); // using special method to read "\n"





        // validate that the file exist


        if(filename.equalsIgnoreCase("QUIT")){
            return;

        }
            // open file


            File file = new File(filename);
        while (!file.exists())
        {
            System.out.println("File: " + filename + " does not exist.");
            System.out.println("Please enter the file name again or type QUIT to exit:");// display data on console
            filename = keyboard.nextLine(); // using special method to read "\n"
            if(filename.equalsIgnoreCase("QUIT")){
                return;

            }
            file = new File(filename);

        }



            // process the file



        Scanner inputFile = new Scanner(file); // creating a new object in the memory with file data




            // read each line and print it on the console
            // with corresponding lone numbers


        int linecount = 0;
        while(inputFile.hasNext()) {
            String line = inputFile.nextLine();
            linecount++;
            System.out.println(linecount+ ": "+ line);

        }


            //close file



            inputFile.close();
            keyboard.close();

    }
}
