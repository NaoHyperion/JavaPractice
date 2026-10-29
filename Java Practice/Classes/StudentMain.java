import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        giveIntro();

        System.out.print("How many students? ");
        int numStudents = console.nextInt();

        // making a empty array
        Student[] students = new Student[numStudents];
        for (int i = 0; i < students.length; i++) {
            students[i] = readStudent(console);
        }
    
        printReport(students);
        console.close();
    }


    public static void giveIntro(){
        System.out.println("This program computes the GPA of each student.");
        System.out.println("Enter each student's name (one word), then the grade points of each course");
        System.out.println("(4.0 = A, 3.0 = B, 2.0 = C, 1.0 = D, 0.0 = F).");
        System.out.println();    
    }

    // Reads one student's name, the number of courses, and the grade points of each course,
    // and returns the Student object for that student.
    // OBJECT CONSTRUCTION: construct the Student object here, as soon as you have the name (new Student(...)).
    // OBJECT BEHAVIOR: after each grade points value is read, ask the Student object to record it
    //     by calling its addCourse method.
    // Print a blank line after the last course so the next student's prompts are easy to read.
    public static Student readStudent(Scanner console) {
        System.out.print(" Student Name: ");// dont use print line all the time it puts the answer i type below it not next to XD
        String name = console.next();// using next insead of next line messes up the order when asking qurstions

        System.out.print(" Number of Courses: ");
        int numCourses = console.nextInt();

        Student student = new Student(name,0.0,0);// this had me comepletly lost for a while. Didnt dawn on me that id have to put the other variable that existed in the object already like grade and courses when i, talking about jsut name

        for (int i = 0; i < numCourses; i++) {
            System.out.print(" Grade Points for course " + (i + 1) + " : ");
            double gradePoints = console.nextDouble();
            student.addCourse(gradePoints);
        }
        System.out.println();
        return student;
    }


    // Prints a heading line (Name and GPA), a line of dashes, and then one line per student with
    // the name (left-aligned in 12 columns) and the GPA with 2 digits after the decimal point.
    //     Alice        3.50
    // OBJECT BEHAVIOR: ask each Student object for its name and its GPA with the accessor methods.
    // The client never reaches into the fields of a Student.
    public static void printReport(Student[] students) {
        System.out.println("Name:" + "            " +  "GPA:");
        System.out.println("-----------------------");

        for (Student student : students){//Student the class holds what a student is. students is the array of students added and the for loop goes through each student and prints name and gpa
            System.out.printf("%-12s%.2f%n",student.getstudentName() + student.getGPA());
            // %-12s%.2f%n makes barely any sense to me. But i kinda does. its just like python's rounding but the %-12s makes it 12 characters wide %.2f is just like python where it gets rounded and then %n is like what i learned in c++ '\n' makes a new line
        }
    }
}







// ok this one is the hard part




//report LOOKS TERRIBLE FIX THAT
//Name            GPA:-----------------------
//Bosu40.666666666666664
//steve53.0

// need a gap between the students and their GPA
// ------ Should have its own line
//