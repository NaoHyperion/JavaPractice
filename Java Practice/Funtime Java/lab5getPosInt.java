import java.util.Scanner;

public class lab5getPosInt {
    public static int getPositiveint(Scanner console) {
        System.out.print("Enter a positive int: ");
        int n = console.nextInt();
        while (n <=0) {
            System.out.println("Not positive Try again");
            System.out.println("Enter a positive int: ");// remember to add a next step in the loop

            n = console.nextInt(); // asks for a new number instead of infinite void

        }
        return n;
        
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = getPositiveint(console);
        System.out.println("This is n: " + n );
    }
    
}
