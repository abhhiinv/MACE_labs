class Geometry {
    // Square: side * side
    static double area(int side) {
        return side * side;
    }

    // Rectangle: length * breadth
    static double area(int length, int breadth) {
        return length * breadth;
    }

    // Circle: pi * r * r
    static double area(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println("Square (side=5):        " + area(5));
        System.out.println("Rectangle (4x6):        " + area(4, 6));
        System.out.println("Circle (radius=3.0):    " + area(3.0));
    }
}
