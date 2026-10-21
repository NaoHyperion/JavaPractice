package movieSeats;
import java.util.Scanner;

public class WeeklySpending{
public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] days = {"Monday", "Tueday", "Wendsday", "Thusday", "Friday", "Saturday", "Sunday"};

        System.out.println("How much did you spend on each day this week?");
        double[] spending = readSpending(console, days);
        printSpending(days, spending);

        double total = sum(spending);
        int highest = indexOfMax(spending);

        System.out.println("Total spent: " + total + " Daily average: " + (total/spending.length) + " Highest day: " + days[highest]);
        //TODO-2 format the lines to print "Total spent", "Daily average", and "Highest day"

        console.close();
    }

    // TODO-3: Prompts for the amount spent on each day and returns the amounts in a new array.
    // Do not hard-code the new array length. Use indexing-looop to store the value into array.
    public static double[] readSpending(Scanner console, String[] days) {
        double[] given = new double[days.length]; // should hold the inputted numbers and then be returned later
        for (int i = 0; i <days.length; i++) {
            System.out.println("How much did you spend on " + days[i] + "?");//  This will loop through the days
            given[i] = console.nextDouble();
        }

        return given;

    }

    // TODO-4: traverse the loop to print both "Day" and "Amount". 
    // Since both arrays have the same length, they can share the same index 
    // to get the element value of each. Do not hard-code the array length.
    public static void printSpending(String[] days, double[] spending) {
        for (int i = 0; i < days.length; i++) { 
            System.out.println(days[i] + ":" + spending[i]);
        }
    }

    // TODO-5: Use a for-each loop (slide #18) with a cumulative sum to sum the total expense.
    public static double sum(double[] list) {
        double total = 0.0;
        for (double given : list) { // it says for every decimal call the givein inputs for eachh day which is  list
            total += given; // add each given and slaps them together
        }
        return total;
    }

    // TODO-6: Find the index to the largest expense element.
    // Assume the first value is the largest. Traverse the rest of the array 
    // with an indexed loop that starts at 1. Swap the index if the element value is larger. 
    public static int indexOfMax(double[] list) {
        int maxin = 0;

        for (int i = 0; i < list.length; i++) {
            if (list[i] > list[maxin]) {
                maxin = i;
            }
        }
        return maxin;
    }
}
