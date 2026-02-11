import java.awt.*;
import java.awt.event.*;

// Printable Interface
interface Printable {
    void printDetails();
}

// Computable Interface
interface Computable {
    void compute();
}

// Drawable Interface
interface Drawable {
    void draw(Graphics g);
}

// Rectangle Class
class Rectangles implements Printable, Computable, Drawable {
    int length, width;
    int area;

    Rectangles(int l, int w) {
        length = l;
        width = w;
    }

    public void compute() {
        area = length * width;
    }

    public void printDetails() {
        System.out.println("Rectangle:");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + area);
    }

    public void draw(Graphics g) {
        g.drawRect(50, 100, length, width);
    }
}

// Sphere Class
class Sphere implements Printable, Computable, Drawable {
    int radius;
    double volume;

    Sphere(int r) {
        radius = r;
    }

    public void compute() {
        volume = (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    public void printDetails() {
        System.out.println("\nSphere:");
        System.out.println("Radius: " + radius);
        System.out.println("Volume: " + volume);
    }

    public void draw(Graphics g) {
        g.drawOval(200, 100, radius * 2, radius * 2);
    }
}

// Main Frame Class
public class Shape extends Frame {

    Rectangles rect;
    Sphere sphere;

    Shape() {
        rect = new Rectangles(150, 80);
        sphere = new Sphere(60);

        rect.compute();
        sphere.compute();

        rect.printDetails();
        sphere.printDetails();

        setSize(400, 300);
        setTitle("Drawable Shapes using AWT");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        rect.draw(g);
        sphere.draw(g);
    }

    public static void main(String[] args) {
        new Shape();
    }
}
