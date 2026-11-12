package Student;

import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        giveIntro();

        System.out.print("How many students? ");
        int numStudents = console.nextInt();
        System.out.println();

        Student[] students = new Student[numStudents];
        for (int i = 0; i < students.length; i++) {
            students[i] = readStudent(console);
        }

        printReport(students);

        console.close();
    }

    public static void giveIntro() {
        System.out.println("This program computes the GPA of each student.");
        System.out.println("For each student, enter the level (S = student, G = graduate, D = doctoral),");
        System.out.println("the name (one word), and the grade points of each course");
        System.out.println("(4.0 = A, 3.0 = B, 2.0 = C, 1.0 = D, 0.0 = F).");
        System.out.println("A graduate student also has a thesis topic, and a doctoral student also has an advisor.");
        System.out.println();
    }

     public static Student readStudent(Scanner console) {
        System.out.print("Level (S/G/D): ");
        String level = console.next().toUpperCase();
        System.out.print("  Student name: ");
        String name = console.next();

        Student student;
        if (level.equals("G")) {
            System.out.print("  Thesis topic (one word): ");
            student = new GraduateStudent(name, console.next());
        } else if (level.equals("D")) {
            System.out.print("  Thesis topic (one word): ");
            String topic = console.next();
            System.out.print("  Advisor (one word): ");
            student = new DoctoralStudent(name, topic, console.next());
        } else {
            student = new Student(name);
        }

        System.out.print("  How many courses? ");
        int numCourses = console.nextInt();
        for (int course = 1; course <= numCourses; course++) {
            System.out.print("  Grade points for course " + course + ": ");
            student.addCourse(console.nextDouble());
        }
        System.out.println();
        return student;
    }

    // Prints a heading line (Name, Level, GPA, Min, Thesis topic), a line of dashes, and then one line per student.
    // Using polymorphism to call getName(), getLevel(), getGPA() and getMinGPA() on every object, which runs
    // its own version, so the loop has no if/else on the level.
    // 1. Print the heading with printf("%-10s %-10s %5s %5s  %s%n", ...) and a line of dashes.
    // 2. For each student, print the name, level, GPA and minimum GPA with printf("%-10s %-10s %5.2f %5.2f", ...)
    //    without ending the line.
    // 3. Remember the Student variable can call only the methods that Student has, and getThesisTopic() is not
    //    one of them. Test the element with  s instanceof GraduateStudent,  then cast it to a GraduateStudent
    //    variable and print two spaces and its thesis topic. A DoctoralStudent passes the test as well.
    // 4. End the line with println().
    public static void printReport(Student[] students) {
        // TODO 1: Implement the method based on the method-level comments.
        //1
        System.out.printf("%-10s %-10s %5s %5s  %s%n", "Name", "Level","GPA","Min","Thesis Topic");
        System.out.printf("------------------------------------");

        for (Student s : students) {
            System.out.printf("%-10s %-10s %5s %5s  %s%n",s.getName(), s.getLevel(), s.getMinGPA());
        

            if (s instanceof GraduateStudent) {
                GraduateStudent g = (GraduateStudent) s;
                System.out.print("  " + g.getThesisTopic());
            }

            System.out.println();
        }
    }
}