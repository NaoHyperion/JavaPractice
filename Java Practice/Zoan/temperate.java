package Zoan;
package java.util;

public class temperate {

    public static void main(String[] args) {

        int numDays = console.nextInt();
        int[] temps = new int[numDays];

        int sum = 0;

        for (int i = 0; i < numDays; i++ ){
            System.out.print("Day " + (i + 1) + "'s high temp: ");
            temps[i] = console.nextInt();
            sum += temps[i];
        }
        double average = (double) sum / numDays;

        int above = 0;
        for (int i = 0; i < temps.length; i++){
            if (temps[i] > average) {
                above++;
            }
        }
    }
    
}
