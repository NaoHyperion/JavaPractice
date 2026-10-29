public class Student {
    // fields
    //forgot to add the private and poor spacing
        private String studentName;
        private double totalGrade;
        private int numCourses;
    
    public Student(){
        this.studentName = "Blah";
        this.totalGrade = 0.0;
        this.numCourses = 0;
    }

    public Student(String studentName, double totalGrade, int numCourses){
        this.studentName = studentName;
        this.totalGrade = totalGrade;
        this.numCourses = numCourses;
    }
    public void addCourse(double gradePoints){// accidently put totalgrade(); caused err and no need for "this.numCources ++" just numcoures ++ is fine
        totalGrade += gradePoints;
        numCourses++;
    }        

    public double getGPA(){// same here dont need the ()
        if (numCourses == 0){
            return 0.0; 
        }
        return totalGrade / numCourses;
    }

    
    public String getstudentName(){
        return studentName;
    }
    public double gettotalGrade(){
        return totalGrade;
    }
    public int getnumCourses(){
        return numCourses;
    }

    public String tosString(){
        return "Student Name: " + studentName 
        + "Total Grade: " + totalGrade
        + "Number of Cources: " + numCourses
        + "GPA: " + getGPA();
    }// use +'s to make one big return' fixed 10/28/26
    

    // this part was pretty easy! i used the student class we used in lab 8-3 and made it the same for this one and the templates explained what to add perfectly
}
