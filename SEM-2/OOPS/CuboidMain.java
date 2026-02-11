// Interface to calculate volume
interface Measurable {
    double volume();
}

// Interface to display object details
interface Printable {
    void display();
}

// Rectangle class
class Rectangle {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}

// Cuboid class inherits Rectangle and implements interfaces
class Cuboid extends Rectangle implements Measurable, Printable {

    double height;

    Cuboid(double length, double width, double height) {
        super(length, width);   // Call parent constructor
        this.height = height;
    }

    // Implement volume method
    public double volume() {
        return length * width * height;
    }

    // Implement display method
    public void display() {
        System.out.println("Cuboid Details:");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Volume: " + volume());
    }
}

// Main class
public class CuboidMain {
    public static void main(String[] args) {

        Cuboid c = new Cuboid(5, 4, 3);
        c.display();
    }
}
