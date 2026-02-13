/*
Create an interface Comparable with methods to find volume 
and compare objects by their volume.
Create classes Cuboid and Cylinder and compare their objects.
*/

import java.util.Scanner;

interface ComparableShape {
    double volume();
    int compare(ComparableShape other);
}

class Cuboid implements ComparableShape {
    int len, bre, hei;

    Cuboid(int l, int b, int h) {
        len = l;
        bre = b;
        hei = h;
    }

    public double volume() {
        return len * bre * hei;
    }

    public int compare(ComparableShape other) {
        if (this.volume() > other.volume())
            return 1;
        else if (this.volume() < other.volume())
            return -1;
        else
            return 0;
    }
}

class Cylinder implements ComparableShape {
    int rad, hei;

    Cylinder(int r, int h) {
        rad = r;
        hei = h;
    }

    public double volume() {
        return Math.PI * rad * rad * hei;
    }

    public int compare(ComparableShape other) {
        if (this.volume() > other.volume())
            return 1;
        else if (this.volume() < other.volume())
            return -1;
        else
            return 0;
    }
}

public class VolumeMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Cuboid dimensions:");
        System.out.print("Length: ");
        int l = sc.nextInt();
        System.out.print("Breadth: ");
        int b = sc.nextInt();
        System.out.print("Height: ");
        int h1 = sc.nextInt();

        System.out.println("\nEnter Cylinder dimensions:");
        System.out.print("Radius: ");
        int r = sc.nextInt();
        System.out.print("Height: ");
        int h2 = sc.nextInt();

        Cuboid c1 = new Cuboid(l, b, h1);
        Cylinder c2 = new Cylinder(r, h2);

        double v1 = c1.volume();
        double v2 = c2.volume();

        System.out.println("\nCuboid Volume: " + v1);
        System.out.println("Cylinder Volume: " + v2);

        int result = c1.compare(c2);

        if (result > 0)
            System.out.println("Cuboid has greater volume.");
        else if (result < 0)
            System.out.println("Cylinder has greater volume.");
        else
            System.out.println("Both have equal volume.");

        sc.close();
    }
}
