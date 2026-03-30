/*Create a class Employee (id, name, department, salary). The program should write an
employee object to a file. Retirive the stored information and diplay the details as a formatted
output. */
import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    int    id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id         = id;
        this.name       = name;
        this.department = department;
        this.salary     = salary;
    }
}

public class EmployeeFile {
    static final String FILE = "employee.dat";

    static void writeEmployee(Employee e) throws IOException {
        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(e);
            System.out.println("Employee written to file: " + FILE);
        }
    }

    static void readEmployee() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(FILE))) {
            Employee e = (Employee) ois.readObject();
            System.out.println("\n========== Employee Details ==========");
            System.out.printf("  ID         : %d%n",   e.id);
            System.out.printf("  Name       : %s%n",   e.name);
            System.out.printf("  Department : %s%n",   e.department);
            System.out.printf("  Salary     : %.2f%n", e.salary);
            System.out.println("======================================");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee emp = new Employee(101, "Alice", "Engineering", 75000.00);
        writeEmployee(emp);
        readEmployee();
    }
}