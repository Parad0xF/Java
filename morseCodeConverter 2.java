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

/*
Morse code is a code where each letter of the English alphabet, each digit, and various punctuation characters are -
represented by a series of dots and dashes. Write a program that asks the user to enter a file name containing morse -
code, and then converts that code to text and prints it on the screen. The Morse code table is given in a text file -
morse.txt. When printing resulting text, display one sentence on each line. There should be no extra spaces at the -
beginning and at the end of the output.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class morseCodeConverter {

    public static void main(String[] args) throws FileNotFoundException {

        String fileMorse = "morse.txt";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the file name or type QUIT to exit:");
        String fileToDecode = keyboard.nextLine();
        String flag = fileToDecode.toLowerCase();
        File checkFileForExist = new File(fileToDecode);


        while (!flag.equals("quit")) {
            if (!checkFileForExist.exists()) {
                System.out.printf("File '%s' is not found.\n",fileToDecode);
                System.out.println("Please re-enter the file name or type QUIT to exit:");
                fileToDecode = keyboard.nextLine();
                flag = fileToDecode.toLowerCase();
                checkFileForExist = new File(fileToDecode);

            }

            else if (checkFileForExist.exists()){
                String decodedString;
                for (int i = 0; i < getCode(fileToDecode).size(); i++) {
                    decodedString = decodeMorse(nestedArrays(fileMorse), find2(getCode(fileToDecode).get(i),
                            nestedArrays(fileMorse)));
                    if (!checkSeparators(decodedString) ){
                        System.out.print(decodedString);
                    }else {
                        System.out.print(decodedString);
                        System.out.print("\n");
                    }

                }
                System.out.println();
                System.exit(0 );
            }
        }

        //ArrayList<ArrayList<String>> alphabet = new ArrayList<>(testNestedArray(fileMorse));
        //String morses = convertStringToMorse(userInput, alphabet);
        //ArrayList<String> testArray = new ArrayList<>(decodeMorse(fileToDecode));
        //System.out.println(morses);

        return;
    }

    private static boolean checkSeparators(String aa ){
        boolean flag = false;

        if (aa.equals(",") || aa.equals("?") ||aa.equals(".") ){
            flag = true;
        }

        return flag;
    }


    private static String decodeMorse(ArrayList<ArrayList<String>> keysToDecode, int position) {
        return keysToDecode.get(0).get(position);

    }

    private static String convertStringToMorse(String str, ArrayList<ArrayList<String>> alphabet) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            int position = find(c, alphabet);
            if (position != 1) {
                result.append(alphabet.get(1).get(position));
            } else {
                result.append('?');
            }
            result.append(' ');
        }
        return result.toString();
    }


    // find();
    // Finds the position of character in the ArrayList

    private static int find(Character c, ArrayList<ArrayList<String>> alphabet) {
        boolean found = false;
        int position = -1;

        ArrayList<Character> charArray = new ArrayList<>();
        for (int index = 0; index < alphabet.get(0).size(); index++) {
            charArray.add(alphabet.get(0).get(index).charAt(0));
        }


        for (int i = 0; !found && i < alphabet.get(0).size(); i++) {
            if (Character.toLowerCase(c) == Character.toLowerCase(charArray.get(i))) {
                position = i;
                found = true;
            }
        }
        return position;
    }


    private static ArrayList<ArrayList<String>> nestedArrays(String fileName) throws FileNotFoundException {

        Scanner myReader = new Scanner(new File(fileName));
        ArrayList<String> alphabet = new ArrayList<>();
        ArrayList<String> codes = new ArrayList<>();
        while (myReader.hasNext()) {
            String line = myReader.nextLine();
            String[] tokens = line.split("[\t]");
            alphabet.add(tokens[0]);
            codes.add(tokens[1]);
        }

        myReader.close();

        ArrayList<ArrayList<String>> myList = new ArrayList<>();
        myList.add(alphabet);
        myList.add(codes);

        return myList;
    }

    private static ArrayList<String> getCode(String fileName) throws FileNotFoundException {
        Scanner myData = new Scanner(new File(fileName));
        ArrayList<String> arrayLists = new ArrayList<>();

        while (myData.hasNext()) {
            String line = myData.next();
                arrayLists.add(line);
        }
        return arrayLists;
    }

    private static int find2(String elementInFile, ArrayList<ArrayList<String>> elementsToCompare) {
        boolean found = false;
        int position = 0;

        ArrayList<String> elementArray = new ArrayList<>();
        for (int index = 0; index < elementsToCompare.get(0).size(); index++) {
            elementArray.add(elementsToCompare.get(1).get(index));
        }


        for (int i = 0; !found && i < elementsToCompare.get(0).size(); i++) {
            if (elementInFile.equals(elementArray.get(i))) {
                position = i;
                found = true;
            }
        }
        return position;
    }
}