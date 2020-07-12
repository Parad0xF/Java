import javax.swing.plaf.synth.SynthTextAreaUI;

public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Welcome To CS/Is 130");
        int i = 10;
        //...
        System.out.println("Countdown started! yahooo!\n");
        for(int b =9 ; b >= 0; b--) {

            i -= 1;
            //...
            System.out.println("\t" + i);
            if(i==0)
            {
                System.out.println("<---- / Welcome New Noobies! / ---->");
            }
        }
    }
}