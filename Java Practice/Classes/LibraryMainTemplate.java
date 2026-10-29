import java.io.*;
import java.util.*;

public class LibraryMainTemplate {
    public static final int MAX_BOOKS = 50;      // the most books the array can hold
    public static final int LOW_THRESHOLD = 2;   // a book is low when fewer copies than this are available

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        giveIntro();

        Scanner input = getInput(console);
        Book[] books = new Book[MAX_BOOKS];     // empty slots (null); the Book objects are constructed in readBook()
        int count = readBooks(input, books);    // count = how many slots are in use

        printLowBooks(books, count);

        input.close();
        console.close();
    }

    public static void giveIntro() {
        System.out.println("This program reads a library catalog file and lists the books that are running low.");
        System.out.println("A book is low when fewer than " + LOW_THRESHOLD + " copies are available.");
        System.out.println();
    }
    public static Scanner getInput(Scanner console) throws FileNotFoundException {
        System.out.print("Catalog file name? ");
        File f = new File(console.nextLine());
        while (!f.canRead()) {
            System.out.println("File not found. Try Again");
            System.out.print("Catalog File name? ");
            f = new File(console.nextLine());
        }
        return new Scanner(f); //This method must return a result of type ScannerJava(603979884) adding this fixed that error
    }

    public static int readBooks(Scanner input, Book[] books) {
        int counter = 0; // establish counter for le books
        if (input.hasNextLine()){
            input.nextLine();
        }// This part does the skiping the frist line
        while (counter < books.length && input.hasNextLine()){
            String line = input.nextLine(); // reads the next line from the fiel !
            if (line.trim().length()>0) {
                books[counter] = readBook(line);// Takes book and splits it into the parts of the class. then counter stores it itno the array. thwn obvioulsy coutner counts up
                counter ++;
            }


        }

        return counter; 
    }
    public static Book readBook(String line) {
        Scanner data = new Scanner(System.in);
        // Although it sounds scary its pretty simple. It takes in data and then split it with (Whatever is in here) for each indivual data type in side of it. this case it goes String, int , int the spliter is the comma
        data.useDelimiter(","); 

        String title = data.next();
        int totalCopies = data.nextInt();
        int checkedout = data.nextInt();
        data.close();// close the scanner

        return new Book(title, totalCopies, checkedout);
    }
    public static void printLowBooks(Book[] books, int count) {
        System.out.print("Books running low!!:");

        int lowCount = 0;

        for (int i = 0; i < count; i++){
            if(books[i].getAvailable() < LOW_THRESHOLD){
                System.out.print(" "+ books[i]);
                lowCount++;
            }

            if (lowCount == 0){
                System.out.print("None.");
            }
            System.out.println();
            System.out.print(count + " books are in the catalog, " + lowCount + " running low.");
    
        }
    }
}
