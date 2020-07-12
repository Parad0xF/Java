/* prohibited to say global, functions, goto. */

// function - we say in java method

// global variable - we say in java field

public class SimpleMethod {

    int j = 2; //field
    public static void main(String[] args){

        int k =3; //local variable



        System.out.println("Hello from the main method");
        displayMessege();
        System.out.println("Back un the main method");

        System.exit(0);
    }
    public static void displayMessege(){
        System.out.println("Hello form the displayMessege.");
    }
}
