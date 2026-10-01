import java.util.*;
// asks for a + or - modifer then rolls a d20 dice, adds them together and gives the final result
// I used While loops to handle invaild inputs, do loops to make sure the dice rolls at least once, boolean to choose if the modifer keeps sgoing
public class DndRoll {
    public static int roll20(Random rand) { // This good?
        int z = rand.nextInt(20) + 1; 
        // REMEBER ADD 1 BECAUSE OTHER WISE ITS UP TO 19

     return z;   
    }
    public static int modifier(Scanner console) {// put the Scanner in the method. I couldnt open and close it over and over so now it should just be open here closed in the main
        boolean hasModi = false; //flag

        System.out.println("Do you have a modifer? y/n: ");
        char choiceMod = console.next().charAt(0);

        if(choiceMod == 'n' || choiceMod == 'N') {
            System.out.println("Ok, Proceed!");
            hasModi = false;
            return 0; // learned using this exits the method
        }else if (choiceMod == 'y' || choiceMod =='Y') {
            hasModi = true;
        }
        while (choiceMod != 'y' && choiceMod != 'n') {
            System.err.println("Invalid input y/n??" );
            choiceMod = console.next().charAt(0);
// ADDED THIS, UESR COULD PUT WHATEVER AND IT WOULD KEEP GOING AS IF YOU SAID YES
        }

        while (hasModi == true) {
            System.err.println(" Positive or negative modifier?: (+/-)");
            char newChoice = console.next().charAt(0);
            if (newChoice == '+'){
                return '1';
            }else if (newChoice == '-') {
                return '2';
            }else{
                System.out.println("WRONG CHOICE. ENTER + or - ");// Prevents infiite void
            }
        } 
        return 0;
    }

    public static int advantage(Random Nrand, Scanner Console) { // Nrand is for new Random idk how much the changing matters
        int typeMod = modifier(Console);// I learned that nothing has to be what changes. Return puts that there anyway

        if(typeMod == 1) {
            int plusRoll = Nrand.nextInt(3) + 1;// didnt need to write Random (Random Nrand = new Random();)multiple times
            return plusRoll;

        }else if (typeMod == 2) { // learned negatives dont work here(just have to subtract later)
            int negRoll = Nrand.nextInt(3) + 1;    

            return negRoll;
        }else{
            //no MODI
            return 0;
        }
        
    }

     public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        char reroll =('n');
        do{// the do works here because it will happen once then keep going
            int Diceroll = roll20(rand);
            int trueModify = advantage(rand,console);
            int diceTotal = Diceroll + trueModify;

            System.out.println("You rolled: " + Diceroll);
            System.out.println("You rolled: " + trueModify + " On Modifier.");
            System.out.println("Your Final roll is a  D" + diceTotal  );

            System.out.println("Do you want to Reroll?: y/n: ");
            reroll = console.next().charAt(0);
            
            while (reroll != 'y' && reroll != 'n') {
            System.out.println("Invalid input y/n: ");
            reroll = console.next().charAt(0);
            }
        }while (reroll == 'y' );

// DO the first roll, while reroll stays y continue to roll, while reroll is not y or n its invalid, while reroll n then stop
        console.close();
    }
    
}

// roll20 rolls the dice CHECK*********
// Medthod 2 Do you have modifier? yes or no then pos or neg?(-7 to -1 or 1 to 7) then its rolled, returend then add to dice roll
// METHOD 3 advantage or disadvatage calc?
// MEthod 4 total of final
// result method which will tell you wat the main will say

//NEW DONE SO FAR
// Roll20() Rolls the dice Modifier() asks if there is a pos or neg one
// Advantage() calculates how much is taken or given the main handles the final of it all
// I worry if this is over complicated
// A major struggle was the console, had to look up what was wrong becasuse of how lost i was. having to put the console iniside the method and pass it throughout the program, since it was hard to close without breaking it
// Another struggle was making the example of the do loop work for my program