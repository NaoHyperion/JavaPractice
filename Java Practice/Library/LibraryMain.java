package Library;

import java.util.*;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        giveIntro();

        LibraryItem[] items = buildCatalog();
        printCatalog(items);

        int daysLate = getDaysLate(console);
        printFees(items, daysLate);

        console.close();
    }

    public static void giveIntro() {
        System.out.println("This program simulates a library catalog of books, DVDs and magazines.");
        System.out.println("It computes the late fee of every item for a number of days late.");
        System.out.println();
    }

    // Builds the catalog. Every element is a LibraryItem variable that refers to a Book, a Dvd or
    // a Magazine object. new LibraryItem(...) would not compile: LibraryItem is abstract.
    public static LibraryItem[] buildCatalog() {
        LibraryItem[] items = new LibraryItem[10];
        items[0] = new Book("Building Java Programs", "Reges and Stepp", 6, 4);
        items[1] = new Book("Clean Code", "Robert Martin", 3, 3);
        items[2] = new Book("The Great Gatsby", "F. Scott Fitzgerald", 8, 5);
        items[3] = new Book("1984", "George Orwell", 7, 6);
        items[4] = new Dvd("The Matrix", 136, 3, 3);
        items[5] = new Dvd("Apollo 13", 140, 4, 1);
        items[6] = new Dvd("Inception", 148, 2, 1);
        items[7] = new Magazine("National Geographic", "Oct 2026", 5, 5);
        items[8] = new Magazine("Wired", "Sep 2026", 4, 2);
        items[9] = new Magazine("Time", "Oct 2026", 6, 2);
        return items;
    }

   public static void printCatalog(LibraryItem[] items) {
        System.out.println("The catalog:");
        for (int i = 0; i < items.length; i++) {
            System.out.println("  " + items[i]);
        }
        System.out.println();
    }

    // Prompts "How many days late are the items returned? " and returns the number the user enters.
    public static int getDaysLate(Scanner console) {
        System.out.print("How many days late are the items returned? ");
        int days = console.nextInt();
        while (days < 0) {
            System.out.println("The number of days cannot be negative. Try again.");
            System.out.print("How many days late are the items returned? ");
            days = console.nextInt();
        }
        return days;
    }
    
    public static void printFees(LibraryItem[] items, int daysLate) {
        System.out.println();
        System.out.println("Late fees if every item is returned " + daysLate + " days late:");
        System.out.printf("%-24s %-9s %5s %8s%n", "Title", "Type", "Loan", "Fee");
        System.out.println("---------------------------------------------------");

        //TODO 1 - iterate the array polymorphimsly to print the late fee for each library item. 
        //       use this formatter for each row: printf("%-24s %-9s %2d d %8.2f%n", ...)
        //       sum the total late fees of all items
        double total = 0.0; // fee start at 0
        for (LibraryItem item : items){
            double fee = item.getLateFee(daysLate); //obvi the late fee
            System.out.printf("%-24s %-9s %2d d %8.2f%n", item.getTitle(), item.getType(), item.getLoanDays(), fee); //MEGA row of all the values

            total += fee; // finally the final owed fee
        }
       
        System.out.println("---------------------------------------------------");
        System.out.printf("%-24s %-9s %5s %8.2f%n", "Total", "", "", total);

    }
}
