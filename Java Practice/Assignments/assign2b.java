package Assignments;
import java.util.Scanner;

public class assign2b{
    
    public static final double INTEREST_RATE = 0.065;

    public static final int YEAR_WIDTH = 6;

    public static final int MONEY_WIDTH = 16;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        }

    public static void printTable(double initialDEPO,double annualDEPO,double rate, int years){
        System.out.println("Year, initial, rate, annual");

        for (int year = 1; year <= years; year++) {
            double balance = initialDEPO;

            if (year == 1) {
                deposit = 0.0;
            }

            double intrest = balance * rate;
            balance = balance + deposit + intrest;
            
        }



    }

    }
