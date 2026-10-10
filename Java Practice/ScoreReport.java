package Assignments;

import java.io.*;
import java.util.*;

public class ScoreReport {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner input = getInput(console);
        processFile(input);
        console.close();
        
    }
    // Prompts for a file name until the user enters a file that can be read, then returns a
    // Scanner on that file (reference lecture 6 slides #40-41).
    // 1. Print the prompt "Input file name? " and read a whole line with console.nextLine()
    //    (why nextLine() and not next()? see slide #40). Build a File object from it.   <- priming read
    // 2. While the file cannot be read (use the canRead() method of File), print
    //    "File not found. Try again.", then prompt and read the file name again.        <- read again
    // 3. Return a new Scanner built from the File that can be read.
    
    public static Scanner getInput(Scanner console) throws FileNotFoundException{
        System.out.println("Input File name");
        File f = new File(console.nextLine());

        while (!f.canRead()) {
            System.out.println("File not found. Please Try again.");
            System.out.print("Input File Name? ");
            f = new File(console.nextLine());
        }

        return new Scanner(f);
    }

    // Processes the file one line at a time. Prints a report line for each student,
    // then the number of students reported.
    // 1. Declare a counter for the students.
    // 2. while-loop input.hasNextLine(). Read one line with nextLine().
    // 3. Skip a blank line using this condition to test "text.trim().length() > 0".
    // 4. For each non-blank line, call reportStudent(text) and count the student.
    // 5. After the loop, print a blank line, then:
    //        Students reported: <number of students>
    public static void processFile(Scanner input) {
        int count = 0; // step 1

        while (input.hasNextLine()) { // 2
            String text = input.nextLine();          //step 3
            if (text.trim().length() > 0) { // 3
                reportStudent(text); //4
                count++; // 4
            }
        }
        System.out.println();
        System.out.print("Students Reported: " + count);
    }

    // Report one line for a student with average of exams, such as "Alice   87.50"
    // Line and token processing combined (reference lecture 6 slides #31-32):
    // 1. Build a second Scanner named 'data' from the String text.
    // 2. Read the student's name with next().
    // 3. Use a cumulative sum and a count while data.hasNextInt(): add each nextInt() to the sum.
    // 4. compute the average as a double and print one line such as "Alice   87.50"
    //        Alice      87.50
    public static void reportStudent(String text) {
        Scanner data = new Scanner(text); // STEP 1 a second scanner
        String student = data.next(); // STEP 2
        int count = 0;
        int sum = 0; // 3 a sum

        while (data.hasNextInt()) {
            sum += data.nextInt();
            count++;
        }

        double average = sum / count; // average as in between the two tests?



        System.out.printf("%s  %.2f%n",student, average); // THIS IS THE SAME AS PYTHON's print(f"BLAH {BLAH}:.2f")
        data.close();
        

    }



    
}
