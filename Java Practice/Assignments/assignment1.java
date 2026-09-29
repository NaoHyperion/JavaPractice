package Assignments;

public class assignment1 {
        public static void main(String[] args){
            for ( int line = 1; line <6; line++){
                int num = 2 * line - 1;

                for (int x = 1; x <= (6 - line); x++){
                    System.out.print("-");
            }
                for (int y = 1; y <= num; y++){
                    System.out.print(num);
                    // using the formula set in the outer loop yuo can always have an odd num
            }
                for (int x = 1; x <= (6 - line); x ++){
                    System.out.print("-");
                    //exact same as the other line loop didint need extra changes
                }

                System.out.println();
                // Seperates them so they dont clump on one line
            }

        }
 }
