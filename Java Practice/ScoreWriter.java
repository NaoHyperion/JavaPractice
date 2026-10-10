package Assignments;
import java.io.*;
import java.util.*;

public class ScoreWriter {
    public static final String OUTPUT_FILE = "scores.txt" ;
    public static final String QUIT = "quit";
    
    public static void main(String[] args) throws FileNotFoundException{
        printIntro();

        Scanner console = new Scanner(System.in);
        PrintStream output = new PrintStream(OUTPUT_FILE); // THIS BUILDS PRINTSTREAM NAMED OUTPUT THAT WILL WRITE TO A FILE CALLED OUTPUT_FILE

        int count = 0;
        String name = getName(console);  // Priming for reading names

        while (!name.equalsIgnoreCase(QUIT)){  // the sentinal stops at "quit"
        writesStudent(console,output,name); // writes the student and scores to the file
        count++;
        name = getName(console); // Reads again

        }

        System.out.println();
        System.out.println(count + "Student records written to " + OUTPUT_FILE);
    }

    // NEXT INTRO JARGON
    public static void printIntro() {
        System.out.println("This program records students midterm and final scores in " + OUTPUT_FILE + ".");
        System.out.println("Enter each students name, then the two Scores (0-100). ");
        System.out.println("Enter '" + QUIT + "' as a name when you're finishe.");
        System.out.println();
        
    }
    // Prompt for returns one name ( 1 single toekn)
    public static String getName(Scanner console) {
        System.out.print("Student name (or " + QUIT + "): ");
        return console.next();
    }

    // GEt the Midterm score by valling getScore(), passing the prompt "MIdterm exam score for Name"
    // get the final exam score same way as ^^^^ prompt being Final exam score for name
    // print the name and 2 scores on ome line to the output file with println()
    // Note: printing to the file uses 'output'; only prompts use console.

    public static void writesStudent(Scanner console, PrintStream output, String name) {
        //// YOU CAN PUT THE PROMPT INSDE THE GETSCORE SO NO NEED TO MAKE 2 SEPERATE STRING Prompts!
        int midterm = getScore(console, "Midterm exam score for " + name + " ");

        int finalExam = getScore(console,"Final exam score for " + name + " ");

        output.println( name + " " + midterm + " "+finalExam );


    }

//  }


    // make a fencepost loop to promopt for one more score until a valid one is recived then returms it

    //1. print the prompt that was passed in and read an int priming read

    //2. While score is not valid (Delegate the test to isvalidScore()) and print a error message
    // Then prompt the prompt again and read another int. read again
    // 3. Return the validated score.
    
    public static int getScore(Scanner console, String prompt) {
        System.out.print(prompt);

        int score = console.nextInt();

        while (!isvalidScore(score)) { // adding the "!" means that while isvalidSCore becomes isINvalid!!! or since its a boolean it becomes while it is isvalid is FALSE 
            System.out.print("Impossible grade, Try Agian");
            System.out.print(prompt);
            score = console.nextInt();
        }


     // NO NEED TO ADD THE 2nd WHILE LOOP AS ISVLAID METHOD DOES EVERYTHING ALREADYU
        return score;
    }

    // Returns true of score is legal score from 0 to 100

    public static boolean isvalidScore(int score) {
        return score >= 0 && score <= 100;
    }







}

