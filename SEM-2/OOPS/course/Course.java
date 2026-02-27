package course;
import department.Department;

public class Course extends Department{
    String course_name;
    int duration;
    public Course(String Dept_name,String Dept_loc,String CourseName, int Duration){
        super(Dept_name, Dept_loc);
        this.course_name = CourseName;
        this.duration = Duration;
    }
    public void setCourse(String Cname ,int dur){
        this.course_name = Cname;
        this.duration = dur;
    }
    public String getCourse(){
        return this.course_name + "\n" + this.duration;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("Course : " + this.course_name);
        System.out.println("Duration " + this.duration);
    }
}
