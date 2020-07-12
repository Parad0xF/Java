/*
Write a program that asks the user to enter a string, and then converts-
that string to Morse code and prints on the screen.

Use hyphens for dashes and periods for dots.

The Morse code table is given in a text file morse.txt.

When printing morse code, display eight codes on each line except the last line.

Codes should be separated from each other with one space.

There should be no extra spaces at the beginning and at the end of the output.

Uppercase and lowercase letters are translated the same way.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class morseCodeConverter {

    public static void main(String[] args) throws FileNotFoundException {

       /*
        String fileMorse = "morse.txt";
        Scanner morseFile = new Scanner(new File(fileMorse));

        ArrayList<Character> alphabet = new ArrayList<>();
        ArrayList<String> codes = new ArrayList<>();
        while (morseFile.hasNext()){
            String line = morseFile.nextLine();
            String[] tokens = line.split("[\t]");
            alphabet.add(tokens[0].charAt(0));
            codes.add(tokens[1]);
        }
        morseFile.close();
*/
        String fileMorse = "morse.txt";

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a string to convert to Morse code:");
        String userInput = keyboard.nextLine();


        ArrayList<Character> alphabet = new ArrayList<>(arrayCharacter(fileMorse));
        ArrayList<String> codes = new ArrayList<>(arrayString(fileMorse));

        System.out.println(testNestedArray(fileMorse));



        String morses = convertStringToMorse(userInput, alphabet, codes);

        System.out.println(morses);



    }


    private static String convertStringToMorse(String str, ArrayList<Character> alphabet, ArrayList<String> codes){

        StringBuilder result = new StringBuilder();
        for(int i =0; i <str.length(); i++){
            char c = str.charAt(i);
            int position = find(c, alphabet);
            if(position != 1){
                result.append(codes.get(position));
            }else {
                result.append('?');
            }
            result.append(' ');
        }
        return result.toString();
    };



    // find();
    // Finds the position of character in the ArrayList

    private static int find(char c, ArrayList<Character> alphabet){
            boolean found = false;
            int position = -1;

            for(int i = 0; !found && i < alphabet.size() ; i++){
                if(Character.toLowerCase(c) == Character.toLowerCase(alphabet.get(i))){
                    position = i;
                    found = true;
                }
            }
        return position;


    };




    private static  ArrayList<ArrayList<String>>  testNestedArray(String fileName) throws FileNotFoundException {

        Scanner myReader = new Scanner(new File(fileName));
        ArrayList<String> alphabet = new ArrayList<>();
        ArrayList<String> codes = new ArrayList<>();
        while (myReader.hasNext()){
            String line = myReader.nextLine();
            String[] tokens = line.split("[\t]");
            ( String)alphabet.add(tokens[0].charAt(0));
            codes.add(tokens[1]);
        }
        myReader.close();

        ArrayList<ArrayList<String>> myList = new ArrayList<ArrayList<String>>();

        myList.add(alphabet);
        myList.add(codes);


        return myList;
    }
    private static ArrayList<String> arrayString(String fileName) throws FileNotFoundException {

        Scanner myReader = new Scanner(new File(fileName));

        ArrayList<String> codes = new ArrayList<>();
        while (myReader.hasNext()){
            String line = myReader.nextLine();
            String[] tokens = line.split("[\t]");
            codes.add(tokens[1]);
        }
        myReader.close();

        return codes;
    }


    private static ArrayList<Character> arrayCharacter(String fileName) throws FileNotFoundException {

        Scanner myReader = new Scanner(new File(fileName));

        ArrayList<Character> alphabet = new ArrayList<>();
        while (myReader.hasNext()){
            String line = myReader.nextLine();
            String[] tokens = line.split("[\t]");
            alphabet.add(tokens[0].charAt(0));
        }
        myReader.close();

        return alphabet;
    }
}
