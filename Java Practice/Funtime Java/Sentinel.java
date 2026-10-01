import java.util.*;
public class Sentinel {
    // Sentinels are a value that ends the input// Summing Numbers until the user enters a special value
    // -1 is the sentiniel here

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int sum = 0;
        System.out.print("Print an int -1 to quit");
        int number = console.nextInt();
        while (number != -1) {
            sum += number;
            System.out.print("next int (-1 to quit): ");
            number = console.nextInt();
        }
        System.out.println("sum = " + sum);
        console.close();
   }
    
}
// Remeber to prompt the user twice. To compare the user input with the senteinal
// inside the while loop you prompt the user again to continue the cycle