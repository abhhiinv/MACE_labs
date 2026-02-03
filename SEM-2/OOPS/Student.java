class Student {
    int rollNo;
    String name;
    int marks;
    static int count;

    // Default constructor
    public Student() {
        this.rollNo = 0;
        this.name = "Unknown";
        this.marks = 0;
        count++;
    }

    // Parameterized constructor
    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        count++;
    }

    // Copy constructor
    public Student(Student other) {
        this.rollNo = other.rollNo;
        this.name = other.name;
        this.marks = other.marks;
        count++;
    }

    void show() {
        System.out.println("Roll: " + rollNo + " | Name: " + name + " | Marks: " + marks);
    }

    static void showCount() {
        System.out.println("Total Students: " + count);
    }

    void compare(Student other) {
        if (this.marks > other.marks) {
            System.out.println(this.name + " has higher marks than " + other.name);
        } else if (this.marks < other.marks) {
            System.out.println(other.name + " has higher marks than " + this.name);
        } else {
            System.out.println(this.name + " and " + other.name + " have same marks");
        }
    }

    static void sort(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].marks < students[j].marks) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create N objects using different constructors
        Student s1 = new Student(101, "Alice", 85);
        Student s2 = new Student(102, "Bob", 92);
        Student s3 = new Student(103, "Charlie", 78);
        Student s4 = new Student(s1);  // Copy constructor demo
        
        Student[] students = {s1, s2, s3, s4};

        // Generate rank list
        sort(students);
        System.out.println("Rank List:");
        for (int i = 0; i < students.length; i++) {
            System.out.print("Rank " + (i + 1) + ": ");
            students[i].show();
        }

        // Display total students
        System.out.println();
        showCount();

        // Compare two students
        System.out.println();
        students[0].compare(students[1]);
    }
}