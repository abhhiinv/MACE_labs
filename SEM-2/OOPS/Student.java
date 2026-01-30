import java.util.Scanner;
class Student {
    int Roll_no;
    String Name;
    int marks;
    static int count;
    public Student(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the roll number : ");
        Roll_no = sc.nextInt();
        System.out.println("Enter the name : ");
        Name = sc.nextLine();
        System.out.println("Enter the mark : ");
        marks = sc.nextInt();
        count++;
    }
    public Student(int Roll_no,String Name,int marks){
        this.Roll_no = Roll_no;
        this.Name = Name;
        this.marks = marks;
    }
    public Student(Student other){
        this.Roll_no = other.Roll_no;
        this.Name = other.Name;
        this.marks = other.marks;
    }
    void show(){
        System.out.println("Roll_no : "+Roll_no);
        System.out.println("Name : "+Name);
        System.out.println("Marks : "+marks);
    }
    static void showCount(){
        System.out.println("Count : "+count);
    }
    void compare(Student other){
        if(this.marks > other.marks){
            System.out.println(this.Name +" has higher marks than "+other.Name);
        }else if(this.marks<other.marks){
            System.out.println(other.Name +" has higher marks than "+this.Name);
        }else{
            System.out.println(this.Name +" and "+other.Name +" has same marks");
        }
        showCount();
    }
}

class studentDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students : ");
        int n = sc.nextInt();
        Student s[] = new Student[n];
        for(int i=0; i<n; i++){
            System.out.println("Enter the details of student "+(i+1));
            s[i] = new Student();
        }
        sort(s,n);
        s[0].compare(s[1]);
    }
    static void sort(Student[] s, int n){
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(s[i].marks > s[j].marks){
                    Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        System.out.println("Rank List : ");
        for(int i=0; i<n; i++){
            System.out.println("Rank "+(i+1)+" : ");
            s[i].show();
        }
    }
}
