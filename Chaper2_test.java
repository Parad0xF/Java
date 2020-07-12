import java.util.Scanner;

public class Chaper2_test {
    public static void main(String[] args){
        //float f1 = 123456789F;
        //
        // System.out.printf("%.10f", f1);

        Scanner kdb = new Scanner(System.in);
        System.out.print("Please enter the number of books ypu wold like to purchase");

        int books = kdb.nextInt();
        System.out.println("You like to purchase " + books + " book." + ( books == 1 ? "." : "s."));

    }
    public static void main(){
        boolean b1 = true;
        boolean b2 = false;

        if ( b1 && b2){

        }

        if (b1 || b2) {
            // do something
        }

        String abc =  "abac";

        if ( abc != null || abc.length() > 10){

        }
    }
}
