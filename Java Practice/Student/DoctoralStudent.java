package Student;

/* A DoctoralStudent is a GraduateStudent who also has a faculty advisor. The hierarchy has three
   levels: Student, GraduateStudent, DoctoralStudent.


   Write GraduateStudent first. This class does not compile until its constructor calls super(...). */

public class DoctoralStudent extends GraduateStudent {

    private String advisor;


    // TODO 2: Constructor (reference lecture 9, section 9.2).
    // Header:  public DoctoralStudent(String name, String thesisTopic, String advisor)
    // The first statement must be super(name, thesisTopic); it runs the GraduateStudent constructor.
    // Then throw a NullPointerException if the advisor is null, and store it in the field.
    public DoctoralStudent(String name, String thesisTopic, String advisor) {; // forgot to add the paramators
        super(name, thesisTopic);
        if (advisor == null){
            throw new NullPointerException();
        }
        this.advisor = advisor; // called this to early, this sholud be here! not at the top

    }

    public String getAdvisor() {
        return advisor;
    }


    // TODO 4: Override getLevel (reference lecture 9, section 9.1).
    // Header:  public String getLevel()
    // Returns "Doctoral".
    @Override 
    public String getLevel() {
        return "Doctoral";
    }

    @Override 
    public double getMinGPA() {
        return 3.5;
    }


    // TODO 6: Override toString (reference lecture 9, section 9.2).
    // Header:  public String toString()
    // Returns the text of GraduateStudent's toString (call super.toString()) followed by " advisor=" and the advisor, e.g.
    //     Student[name=Carol, totalGradePoints=6.0, courseCount=2] thesisTopic=Networks advisor=Lee
    @Override
    public String toString() {
        return super.toString() + " advisor =" + advisor;
    }

}
