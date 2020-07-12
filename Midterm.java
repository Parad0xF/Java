import java.awt.geom.Area;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Midterm {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Please enter the file name or type QUIT to exit:");
        Scanner keyboard = new Scanner(System.in);
        String fileInput = "input1.txt"; //keyboard.nextLine();
        File file = new File(fileInput);
        Scanner inputFile = new Scanner(fileInput);
        fileInput.toLowerCase();

        String flagQuit = "quit";

        if (!inputFile.hasNext()){
            System.out.printf("File '%s' is empty.\n", fileInput);
            System.exit(0);
            inputFile.close();
        }

        inputFile.close();

        if (fileInput.equals(flagQuit)) {
            inputFile.close();
            System.exit(0);

        }


        while (!file.exists()) {
            System.out.printf("File %s is not found.\n", fileInput);
            System.out.println("Please re-enter the file name or type QUIT to exit:");
            fileInput = keyboard.nextLine();
            file = new File(fileInput);

            if (fileInput.equals(flagQuit)) {
                inputFile.close();
                System.exit(0);
            }
        }
        ArrayList<String> arrayDatafile = load(file);
        //System.out.println(arrayDatafile);

        //System.out.println(countTheOccurrences(arrayDatafile, "Michael"));


       for (int i = 0; i < countElements(file); i++) {
            String element= (String) arrayDatafile.get(i);
           int occurrence = countTheOccurrences(arrayDatafile, element);
            if (occurrence >=2) {
                indexOf(arrayDatafile, element);
            }
        }

       System.out.printf("Total of %d matches found.\n", totalMatches(arrayDatafile));
    }

    private static int totalMatches(ArrayList<String> list ){
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            String element = (String) list.get(i);
            int occurrence = countTheOccurrences(list, element);
            if (occurrence >=2) {
                count++;
            }
        }

        return count;

    }

    private static void indexOf(ArrayList<String> list, String element){
        System.out.printf("Match found: '%s' on lines %d and %d.\n", element, list.indexOf(element) +1, list.lastIndexOf(element) +1);
    }
    private static int countTheOccurrences(ArrayList<String> list, String element ){
        int theCount = 0;
        for (int i =0; i < list.size(); i++){
            if (element.equals(list.get(i))){
                    theCount++;
            }
        }
        return theCount;
    }


    private static int countElements(File file) throws FileNotFoundException {
        int acumullator = 0;
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext())
        {
            String fileData = inputFile.nextLine();
            acumullator++;
        }
        inputFile.close();
        return acumullator;
    }
    private static ArrayList<String> load(File file) throws FileNotFoundException {
        Scanner inputFile = new Scanner(file);
        ArrayList<String> result = new ArrayList<String>(countElements(file));
        
        for (int index = 0; index < countElements(file); index++){
            result.add(inputFile.nextLine());
        }
        inputFile.close();

        return result;
    }
}