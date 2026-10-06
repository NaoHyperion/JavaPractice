import java.io.FileNotFoundException;
import  java.util.Scanner;
import java.io.File;

public class USING_FILES {
    public static void main(String[] args) throws FileNotFoundException{
        // Maka da file
        Scanner input = new Scanner(new File("Funtime Java/numbers.dat"));

        // Counter for the file
        int counter = 0;
        while(input.hasNext()){
            input.next();
            counter++;
        }
        input.close();
        System.out.print("There are " + counter + " Numbers");
    }

}
