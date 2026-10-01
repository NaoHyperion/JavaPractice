package Cool;

import java.util.*;

public class Newtemp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the Temperature Value: ");

        double tempv = console.nextDouble();
        double absoC = -273.15;
        double absoF = -459.67;     

        System.out.print("Fahrenheight or Celcius: ");
        char temp = console.next().charAt(0);
        // 0 is the first thing typed
        // should i have used equals methos? Still works but is it efficent??

        while (temp != 'f' && temp != 'c') {
            System.err.println("Invalid Temperature type. f or c!: ");
            temp = console.next().charAt(0);
        }

        if (temp == 'f'){
            while (tempv <= absoF) {
                System.out.println("Your Fahrenheight value Cannot go below absolute zero, please try again ");
                tempv = console.nextDouble();
            }
            ftoc(tempv);
            System.out.println("Celcius is " + ftoc(tempv));
            // Calling the calc functions at the bot will send it to the celcius to farhen and replace the tempf with the users input
            // then with the return thats downthere it comes back
            // ALSO FORGETTING TO USE THE "ftoc" part will cause it to repeat user input back
            

            }else if (temp == 'c'){
                ctof(tempv);
                System.out.println("Fahrenheight is " + ctof(tempv));

                while (tempv <= absoC) {
                    System.out.println("Your celcius value Cannot go below absolute zero, please try again ");
                    tempv = console.nextDouble();
                }
            // Same thing but in reverse
            }
            console.close();
            }



            public static double ftoc(double tempf)
            {

                double tempc = (tempf-32)* 5/9;
                return tempc;

            }
            public static double ctof(double tempc) {
                double tempf = (tempc * 9.0/5.0) + 32;
                return tempf;
        
            }
}
//THIS TOOK ME 65 minutes (including the other attempt)
// REMINDER WRITE THE SUMMARAY
// Understanding how tempv bascially became tempf or c when you call the function
// I STRUGGLED ON HOW THE INPUT WOULD BE CALCULATED, BUT THATS THE POINT OF RETURN, LIKE PYTHON YOU CAN CALL A FUNCTION
// Having to close the console in the illegal arguments, i thought the other close in the code would be enough
// Questionoing if equals or charAt would be better here
// 
