//import the package required for using the Scanner class
/* write your code here */
package Assignments;
// This program prints a table showing how a savings account grows at
// 6.5% annual interest. The user enters the initial deposit, the amount
// deposited every year after the first, and the number of years to show.

import java.util.*;   // for Scanner

public class Savings {
    // constant for the bank's annual interest rate
    public static final double INTEREST_RATE = 0.065;

    // column widths used to line up the table (in characters)
    public static final int YEAR_WIDTH = 6;
    public static final int MONEY_WIDTH = 16;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("initial deposit? ");
        double initialDeposit = console.nextDouble();
        if (initialDeposit < 0){
                console.close();
                throw new IllegalArgumentException("Initial Deposit Cannot be negitive: "+ initialDeposit);
            }
        System.out.print("annual deposit? ");
        double annualDeposit = console.nextDouble();
        if (annualDeposit < 0){
                console.close();
                throw new IllegalArgumentException("Annual Deposit Cannot be negitive: "+ annualDeposit);
            }

        System.out.print("number of years? ");
        int years = console.nextInt();
        if (years <= 0){
                console.close();
                throw new IllegalArgumentException("Years must be positive: "+ years);
            }
        System.out.println();

        printTable(initialDeposit, annualDeposit, INTEREST_RATE, years);

        console.close();
    }

    // Prints a table of `years` rows showing the starting balance,
    // interest earned that year, the annual deposit, and the resulting new balance. 
    // format the table to align the cell, and round up to two decimal places.
    public static void printTable(double initialDeposit, double annualDeposit,
                                   double rate, int years) {
        //print table header                           
        printField("year", YEAR_WIDTH);
        printField("current balance", MONEY_WIDTH);
        printField("interest", MONEY_WIDTH);
        printField("deposit", MONEY_WIDTH);
        printField("new balance", MONEY_WIDTH);
        System.out.println();
        double overall = 0.0;
        double balance = initialDeposit;
        for (int year = 1; year <= years; year++) {
            double currentBalance = balance; //starting balance
            double interest = round2(currentBalance * rate); //interest
            double deposit = 0.0; //first-year deposit
            if(year != 1 ){
                deposit = annualDeposit; //annual deposit
            }
            double newBalance = round2(currentBalance + interest + deposit); //resulting end-year balance
            overall += interest;

            //print table row
            printField("" + year, YEAR_WIDTH);
            printField("" + currentBalance, MONEY_WIDTH);
            printField("" + interest, MONEY_WIDTH);
            printField("" + deposit, MONEY_WIDTH);
            printField("" + newBalance, MONEY_WIDTH);
            System.out.println();
            

            balance = newBalance; //move resulting balance to next-year starting balance
        }
        // got rid of the print line here to keep it on the row
        System.out.println("Total Intrest earned: "+ round2(overall));
    }

    // print the value by padding the unfilled width with space
    public static void printField(String text, int width) {
        System.out.print(text);
        for (int i = text.length(); i < width; i++) {
            System.out.print(" ");
        }
    }

    // rounds to 2 digits after the decimal point
    public static double round2(double n) {
        return (int) (n * 100.0 + 0.5) / 100.0;
    }
}
