import java.util.*;
public class lab2CountPositive {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int count = 0;
        System.out.print("Print an int -1 to quit");
        int n = console.nextInt();
        console.close();

        while (n != -1){
            if (n<0) {
                count++;
            }
        }
        return count;
    }
    
}
