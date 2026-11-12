package Student;
public class Student {
    private String name;               // the student's name
    private double totalGradePoints;   // sum of the grade points of all courses recorded
    private int courseCount;           // number of courses recorded

    // Constructs a new Student with no courses recorded.
    // Precondition: name != null
    public Student(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        totalGradePoints = 0.0;
        courseCount = 0;
    }

    // Records the grade points of one more course (4.0 is an A, 3.0 is a B, ... 0.0 is an F).
    // Precondition: 0.0 <= gradePoints <= 4.0
    public void addCourse(double gradePoints) {
        if (gradePoints < 0.0 || gradePoints > 4.0) {
            throw new IllegalArgumentException();
        }
        totalGradePoints += gradePoints;
        courseCount++;
    }

    // Returns the student's name.
    public String getName() {
        return name;
    }

    // Returns the grade point average of all recorded courses, or 0.0 if there are no courses yet.
    public double getGPA() {
        if (courseCount == 0) {
            return 0.0;
        }
        return totalGradePoints / courseCount;
    }

    // Returns the level of this student. Subclasses override it.
    public String getLevel() {
        return "Student";
    }

    // Returns the minimum GPA that keeps this student in good standing. Subclasses override it.
    public double getMinGPA() {
        return 2.0;
    }

    // Returns true if this student's GPA is at least the minimum GPA for this kind of student.
    // The call to getMinGPA() runs the version that belongs to the actual object: a GraduateStudent
    // is judged by 3.0 even though this method is written only once, here in Student.
    public boolean isGoodStanding() {
        return getGPA() >= getMinGPA();
    }

    // Returns a String that shows the contents of this object, such as
    // Student[name=Alice, totalGradePoints=10.5, courseCount=3]
    public String toString() {
        return "Student[name=" + name + ", totalGradePoints=" + totalGradePoints
                + ", courseCount=" + courseCount + "]";
    }
}
