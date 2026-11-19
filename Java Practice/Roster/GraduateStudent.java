public class GraduateStudent extends Student {
    public static final String LEVEL = "Graduate";   // the level of a graduate student (hides Student.LEVEL)
    public static final double MIN_GPA = 3.0;        // the minimum GPA of a graduate student (hides Student.MIN_GPA)

    private String thesisTopic;   // the topic of this student's thesis

    // Constructs a graduate student with the given name and thesis topic and no courses recorded.
    // Precondition: name != null && thesisTopic != null
    public GraduateStudent(String name, String thesisTopic) {
        super(name);
        if (thesisTopic == null) {
            throw new NullPointerException();
        }
        this.thesisTopic = thesisTopic;
    }

    // Returns the topic of this student's thesis.
    public String getThesisTopic() {
        return thesisTopic;
    }

    // Overrides Student: the level of a graduate student.
    @Override 
    public String getLevel() {
        return LEVEL;
    }

    @Override 
    // Overrides Student: a graduate student needs a GPA of at least 3.0.
    public double getMinGPA() {
        return MIN_GPA;
    }

    // Overrides Student: the Student text followed by the thesis topic, such as
    // Student[name=Bob, totalGradePoints=7.0, courseCount=2] thesisTopic=Robotics
    public String toString() {
        return super.toString() + " thesisTopic=" + thesisTopic;
    }
}
