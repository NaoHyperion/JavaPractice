import java.util.*;

public class learnWhile {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a name of a funger 1 Playable Character: ");

        String chosenName = console.nextLine();

        console.close();
        
        String[] characters = {"Enki", "Ragnavaldr", "Cahara", "Darce"};

        for( String character : characters) {
            if (chosenName == (character)) {
                System.out.println("You are correct!!!");    
            }else (chosenName != character){
        
            }
            
        }
    }
}