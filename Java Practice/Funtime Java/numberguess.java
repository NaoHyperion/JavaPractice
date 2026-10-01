import java.util.Random;
import java.util.Scanner;

public class numberguess {

    public static int getInt(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextInt()) {
            console.next(); // discard the input
            System.out.println("Not an int, try again.");
            System.out.print(prompt);
        }
        return console.nextInt();
    }





    public static void main(String[] args) {
        giveIntro();
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        int number = rand.nextInt(100);

        int guess = getGuess(console);
        int numGuesses = 1;
        while (guess != number) {
            int numMatches = matches(number,guess);
            System.out.println("Incorrect (hint: " + numMatches + "digits match)");

            guess = getGuess(console);
            numGuesses++;
        }
        System.out.println("You got it right in" + numGuesses + " tries.");

    }
    
}
