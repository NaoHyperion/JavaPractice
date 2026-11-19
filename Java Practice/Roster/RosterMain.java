import java.util.*;

public class RosterMain {
    public static void main(String[] args) {
        giveIntro();

        Roster roster = buildRoster();
        System.out.println("The roster has " + roster.size() + " students.");
        System.out.println();
        System.out.printf("Average GPA: %.2f%n", roster.averageGPA());
        System.out.println();

        System.out.println("Looking for Dan: " + roster.find("Dan"));
        System.out.println("Looking for Zoe: " + roster.find("Zoe"));
        System.out.println();

        System.out.println("Bob leaves the University: removed = " + roster.removeByName("Bob"));
        System.out.println("Zoe Leaves the Univerity: removed = " + roster.removeByName("Zoe"));
        System.out.println();

        System.out.println("The graduate students:");
        ArrayList<Student> grads = roster.getByLevel(GraduateStudent.LEVEL);
        printList(grads);
        System.out.println();

        int removed = roster.removeNotInGoodStanding();
        System.out.println(removed + " Students are not in good standing and have been removed. ");
        roster.printReport();
        System.out.printf("Average GPA: %.2f%n", roster.averageGPA());
    }

    public static void giveIntro() {
        System.out.println("This program keeps a roster of students in an ArrayList.");
        System.out.println("The roster holds plain, graduate and doctoral students together.");
        System.out.println();
    }

    // Builds the roster. Every student is added to the same list of Student objects, whether it is a
    // Student, a GraduateStudent or a DoctoralStudent.
    public static Roster buildRoster() {
        Roster roster = new Roster();
        roster.add(withGrades(new Student("Alice"), new double[] {4.0, 3.5, 3.0}));
        roster.add(withGrades(new Student("Bob"), new double[] {2.0, 1.5, 1.0}));
        roster.add(withGrades(new GraduateStudent("Carol", "Robotics"), new double[] {3.5, 3.0}));
        roster.add(withGrades(new GraduateStudent("Dan", "Networks"), new double[] {3.0, 2.5}));
        roster.add(withGrades(new DoctoralStudent("Eve", "AI", "Lee"), new double[] {4.0, 3.0}));
        roster.add(withGrades(new DoctoralStudent("Fay", "Security", "Park"), new double[] {3.5, 3.0}));
        return roster;
    }

    // Records the grade points of the given courses for the student and returns the same student.
    public static Student withGrades(Student student, double[] gradePoints) {
        for (double points : gradePoints) {
            student.addCourse(points);
        }
        return student;
    }

    // Prints the name and level of every student in the given list, such as "  Carol (Graduate)",
    // or "  (none)" if the list is empty.
    public static void printList(ArrayList<Student> list) {
        if(list.isEmpty()) { // this has been used alot in these assignments is this a standard?
            System.out.println("  (none)");
            return;
        }
        for (Student s:list) {
            System.out.println("  "+ s.getName() + " (" + s.getLevel() + ")");
        }

    }
}
