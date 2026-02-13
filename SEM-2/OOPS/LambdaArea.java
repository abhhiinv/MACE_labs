// Functional Interface
@FunctionalInterface
interface Dim {
    double area(double x);
}

public class LambdaArea {
    public static void main(String[] args) {

        // a) Square
        Dim square = (side) -> side * side;
        System.out.println("Area of Square: " + square.area(5));

        // b) Cube (Surface Area = 6a²)
        Dim cube = (side) -> 6 * side * side;
        System.out.println("Surface Area of Cube: " + cube.area(4));

        // c) Circle
        Dim circle = (radius) -> Math.PI * radius * radius;
        System.out.println("Area of Circle: " + circle.area(3));

        // d) Sphere (Surface Area = 4πr²)
        Dim sphere = (radius) -> 4 * Math.PI * radius * radius;
        System.out.println("Surface Area of Sphere: " + sphere.area(3));
    }
}
