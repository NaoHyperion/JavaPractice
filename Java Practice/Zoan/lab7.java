package Zoan;
import java.util.Scanner;

public class lab7 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("How many days? ");
        int numDays = console.nextInt();

        int[] temps = new int[numDays];// removed the equal sign

        double sum = 0; // made sum a double instead of int

        for(int i = 0; i < numDays; i++) {  // make i less than intead of <=
            System.out.print("high temp: ");
            temps[i] = console.nextInt();
            sum += temps[i];

        }
        System.out.println("Average = " + sum / numDays);
        console.close();
    }

    
}
