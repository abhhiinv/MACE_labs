package scholar;
import course.Course;

public class Scholar extends Course{
    String Stu_name;
    int rank;
    public Scholar(String Dept_name,String Dept_loc,String CourseName, int Duration, String Name,int Rank){
        super(Dept_name,Dept_loc,CourseName,Duration);
        this.Stu_name = Name;
        this.rank = Rank;
    }
    public void setStu(String name, int rank){
        this.Stu_name = name;
        this.rank = rank;
    }
    public String getStu(){
        return this.Stu_name + "\n" +this.rank;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("Student : " + this.Stu_name);
        System.out.println("Rank : " + this.rank);
    }
}