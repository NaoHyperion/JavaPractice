package Assignments.labs;

public class Lab {
    public static void main(String[] args) {
        int a = 7; int b = 42;
        int min = minimum (a,b);
        if (min == a) {
            System.out.println("A SMALL");
        }else{
            System.out.println("B SMALL");

        }

    }

    public static int minimum(int a, int b) {
        if (a < b) {
          return a;
        } 
          return b;

    }
}

