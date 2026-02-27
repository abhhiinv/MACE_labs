package department;

public class Department{
    String Dept_name,Location;
    public Department(String DeptName,String Loc) {
        this.Dept_name = DeptName;
        this.Location = Loc;
    }
    public void setDept(String deptName,String location){
        this.Dept_name = deptName;
        this.Location = location;
    }
    public String getDept(){
        return this.Dept_name + "\n" + this.Location;
    }
    public void display(){
        System.out.println("Department : " + this.Dept_name);
        System.out.println("Location : " + this.Location);
    }
}

