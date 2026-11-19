public class DoctoralStudent extends GraduateStudent {
    public static final String LEVEL = "Doctoral";   // the level of a doctoral student (hides GraduateStudent.LEVEL)
    public static final double MIN_GPA = 3.5;        // the minimum GPA of a doctoral student (hides GraduateStudent.MIN_GPA)

    private String advisor;   // the name of the faculty advisor

    // Constructs a doctoral student with the given name, thesis topic and advisor, and no courses recorded.
    // Precondition: name != null && thesisTopic != null && advisor != null
    public DoctoralStudent(String name, String thesisTopic, String advisor) {
        super(name, thesisTopic);
        if (advisor == null) {
            throw new NullPointerException();
        }
        this.advisor = advisor;
    }

    // Returns the name of the faculty advisor.
    public String getAdvisor() {
        return advisor;
    }

    // Overrides GraduateStudent: the level of a doctoral student.
    @Override 
    public String getLevel() {
        return LEVEL;
    }

    // Overrides GraduateStudent: a doctoral student needs a GPA of at least 3.5.
    @Override 
    public double getMinGPA() {
        return MIN_GPA;
    }

    // Overrides GraduateStudent: the GraduateStudent text followed by the advisor, such as
    // Student[name=Carol, totalGradePoints=7.5, courseCount=2] thesisTopic=Networks advisor=Lee
    public String toString() {
        return super.toString() + " advisor=" + advisor;
    }
}
