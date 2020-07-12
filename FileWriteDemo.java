import jdk.internal.cmm.SystemResourcePressureImpl;

import java.io.FileWriter;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class FileWriteDemo
{

    public static void main(String[] args) throws IOException
    {

        String filename;
        String friendName;
        int numFriends;

        Scanner keyboard = new Scanner(System.in);

        // Get the number of friends.
        System.out.print("How many friends do you have? ");
        numFriends = keyboard.nextInt();

        // Consume the remaining newline character.
        keyboard.nextLine();

        // Get the filename.
        System.out.print("Enter the filename: ");
        filename = keyboard.nextLine();

        // Open the file.
        FileWriter fw = new FileWriter(filename, true);
        PrintWriter outputFile = new PrintWriter(fw);


        for(int i =1 ; i<= numFriends; i++)
        {

            System.out.print("Enter the name of friend" + "number" + i +  ":");
            friendName = keyboard.nextLine();
            outputFile.println(friendName);
        }

        outputFile.close();
        System.out.print("Data written to the file.");

    }
}
