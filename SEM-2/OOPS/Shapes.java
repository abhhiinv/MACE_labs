import java.util.Scanner;

// 1. Define the Interface
interface Shape {
    void area();
    void perimeter();
}

// 2. Implementation for Circle
class Circle implements Shape {
    double radius;

    Circle(double r) { this.radius = r; }

    public void area() {
        System.out.println("Area of Circle: " + (Math.PI * radius * radius));
    }

    public void perimeter() {
        System.out.println("Perimeter of Circle: " + (2 * Math.PI * radius));
    }
}

// 3. Implementation for Rectangle
class Rectangle implements Shape {
    double length, width;

    Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }

    public void area() {
        System.out.println("Area of Rectangle: " + (length * width));
    }

    public void perimeter() {
        System.out.println("Perimeter of Rectangle: " + (2 * (length + width)));
    }
}

// 4. Menu-Driven Program
public class Shapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Geometry Menu ---");
            System.out.println("1. Circle\n2. Rectangle\n3. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 3) break;

            Shape s = null; // Interface reference

            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    s = new Circle(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter length and width: ");
                    s = new Rectangle(sc.nextDouble(), sc.nextDouble());
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            s.area();
            s.perimeter();
        }
        sc.close();
    }
}
