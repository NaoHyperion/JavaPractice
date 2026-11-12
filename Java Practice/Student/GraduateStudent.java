package Student;

/* A GraduateStudent is a Student who is working on a thesis. A graduate student needs a higher GPA
   (3.0) than a plain Student to stay in good standing.

   Techniques from lecture 9 would be the inheritance, shown by using gsuperclass constructor example (super(name,thesisstopic,etc) Theres also use of @override with getlevel, minGPA and the tostring methods
   // also there is the use of extends 

   Student is the superclass and its fields are private, so reach them only through Student's methods.
   Note: Student has no constructor without parameters, so this class does not compile until you write
   its constructor and call super(...) in it. */

public class GraduateStudent extends Student {
    private String thesisTopic;
    


    public GraduateStudent(String Name, String thesisTopic) {
        super(Name);
        if (thesisTopic == null) {
            throw new NullPointerException();
        }
        this.thesisTopic = thesisTopic;

    }


    public String getThesisTopic(){
        return thesisTopic;
    }


    @Override 
    public String getLevel(){
        return "Graduate";
    }


    @Override
    public double getMinGPA(){
        return 3.0;
    }

    @Override 
    public String toString(){
        return super.toString() + "thesisTopic=" + thesisTopic;
    }
}



// These feel so simple with the explanations