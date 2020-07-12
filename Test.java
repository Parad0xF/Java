public class Test {
    public static boolean isValidMine(int number){

        return (number >= 1 && number <= 100);



    }

    public static boolean isValid(int number){
        boolean status;

        if(number >=1&& number <=100){
            status =true;
        }
        else{
            status = false;
        }

        return status;
    }

    public static void main(String[] args){


        int i = 150;

        System.out.println(isValid(i));


    }
}
