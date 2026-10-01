import java.util.*;
public class lab3invalidPer {

    public static boolean invalidPercent(int score) {
// changed the if condition. If less than - or bigger than 100 should be invalid. Previous code made all nnumbers invalid
        if (score < 0 || score > 100) {
            return true;
        } 
        return false; // the return boolean should be apart of the if statment
    }
    
    public static void main(String[] args) { // A MAIN METHOD IS NEEDED FOR CODE TO START
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a Score: ");
        int buford = console.nextInt();
        System.out.println("Score: "+ buford + " is " + invalidPercent(buford));
        console.close();

    }
}

