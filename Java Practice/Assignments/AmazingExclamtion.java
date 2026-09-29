package Assignments;

public class AmazingExclamtion {

    // DEFINE TABLE HEight
    
    public static void main(String[] args) {
        int height = 4;
        // DEFINE OUTER LOOP NUM of lines
        for (int line = 1; line < height; line++){
            int para =  2 * line;
            int exa = (4* height - 2) - 4 * line;
            // using other than height broke the output


            // 1st inna loop print \
            // Relationship between line num and num of leading \:
            // leadingi \ = (2*linenumber)
            for (int x = 1; x <= (para); x++){
                System.out.print("\\");
            }

            // 2nd inner loop print excalmation marks
            // relataionship between line number and number of !
            // ! = (4*Height - 4lineNumber)
            for (int y = 1; y <= exa; y++){
                System.out.print("!");
            }
            // 3rd inner loop Trailing slash //
            // relationship  between  line num
            // same as inner loop 1 but with / instead of \
            for (int x = 1; x <= (para); x++){
                System.out.print("/");

            }
            //move to the next line each row
            System.out.println();
        }
    }
    
}
