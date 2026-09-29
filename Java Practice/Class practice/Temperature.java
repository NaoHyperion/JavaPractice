import java.util.*;

public class Temperature {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter the Temperature in F: ");

        double tempf = console.nextDouble();
        double tempc = 0.0;
        tempc = ftoc(tempf);

        System.out.println("Celcius temperature -" + tempc);
        console.close();

    }


    public static double ftoc(double tempf)
    {

        double tempc = (tempf-32)* 5/9;
        return tempc;

    }

    
// Scanner is basically the inputs from python. Just add Scanner instead of an set variable for farenheight
}
