import java.util.*;

public class bool {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double sum = 0.0;
        boolean negative = false; //  THIS IS THE FLAG

        System.out.print("How many numbers do you want: ");
        int totalNumber = console.nextInt();
        
        for (int i = 1; i <= totalNumber; i++) {
            double next = console.nextDouble();
            sum += next;
            if (sum < 0.0) {
                negative = true;
            }
        }
        System.out.println("Sum is " + sum);
        System.out.println("Was the sum ever negative? " + negative);
        console.close();
    }

    
}