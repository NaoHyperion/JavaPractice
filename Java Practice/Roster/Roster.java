import java.util.*;

// import Condens.dimensionalarray; WHERE DID THIS COME FROM??

// A roster of students. The students are stored in ONE ArrayList of type Student, so the list can hold
// Student, GraduateStudent and DoctoralStudent objects together and grows by itself as students are added.
public class Roster {
    private ArrayList<Student> students;   // every student of the roster

    // Constructs an empty roster.
    public Roster() {
        students = new ArrayList<>();
    }

    // Adds a student at the end of the roster.
    // Precondition: student != null (throw a NullPointerException otherwise)
    public void add(Student student) {
        if (student == null){
            throw new NullPointerException();
        }
        students.add(student); 
        // the array list DOT add(built in method that resizes and add item to back) Student is just the object thingy
    }

    // Returns the number of students in the roster.
    public int size() {
        return students.size();
    }

    // Returns the first student with the given name (ignoring upper and lower case), or null if there is none.
    public Student find(String name) {
        for (Student s : students){ // this goes down the list and s is whos being looked at rn
            if(s.getName().equalsIgnoreCase(name)){ // if looks for the student with the s being who youre looking for then get that syudent. ignore = is just saing NATE and nate are the same
                return s;
            }
        }
        return null;

        
    }

    // Removes the student with the given name. Returns true if a student was removed, false if the name was not found.
    // Hint: call find, then students.remove(theStudentObject), which removes an object, not an index.
    public boolean removeByName(String name) {
        Student block = find(name);
        if (block == null){
            return false;
        }
        return students.remove(block);
    }

    // Returns a NEW list that holds only the students whose level equals the given level, such as "Graduate".
    // The roster itself is not changed. A DoctoralStudent has the level "Doctoral", so it is not a "Graduate" here.
    public ArrayList<Student> getByLevel(String level) {
        ArrayList<Student> result = new ArrayList<>(); // mskrs the list
        for (Student s : students) {
            if (s.getLevel().equals(level)) { // .equals compares strings so its saying each students level and sees if it equals (level) and then they get added to result which is then returned
                result.add(s);
            }
        }
        return result;
    }

    // Removes every student that is not in good standing (see isGoodStanding) and returns how many were removed.
    // Hint: loop backward, so a removal only shifts students that were already checked.
    public int removeNotInGoodStanding() {
        int gone = 0;

        for (int i = students.size() - 1; i >= 0; i--) {
            if (!students.get(i).isGoodStanding()){
                students.remove(i);
                gone++;
            }
        }
        return gone;

        // gone is how many students got removed
        // !students means the student isnt in good standing so then the students.remove(i) removes who was in the position thats getting decramented

    }

    // Returns the average of the GPA of all students, or 0.0 if the roster is empty.
    public double averageGPA() {
        double TotalGpa = 0.0;
        
        if(students.size() == 0){
            return 0.0;
        }
        for (int i = 0; i < students.size(); i++) {
            Student stu = students.get(i);
            TotalGpa += stu.getGPA();
        }

        return TotalGpa / students.size();
    }

    // Prints one line per student: name, level, GPA and minimum GPA, and for a graduate or doctoral student
    // the thesis topic. The same calls work for every kind of student; each object answers for itself.
    // A Student variable cannot call getThesisTopic(), so test with instanceof GraduateStudent, then cast.
    public void printReport() {
        System.out.printf("%-10s %-10s %5s %5s  %s%n", "Name", "Level", "GPA", "Min", "Thesis topic");
        System.out.println("------------------------------------------------");

         for (Student s : students) {
            System.out.printf("%-10s %-10s %5.2f %5.2f", s.getName(), s.getLevel(),s.getGPA(), s.getMinGPA());

            if (s instanceof GraduateStudent){
                GraduateStudent g = (GraduateStudent) s;
                System.out.printf(" %s", g.getThesisTopic());

            }
            System.out.println(); // that extra line
         }
    }
}
