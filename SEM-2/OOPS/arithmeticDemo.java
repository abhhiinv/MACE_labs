import arithmetic.*;

public class arithmeticDemo {
    public static void main(String[] args) {
        Operation add = new Add();
        Operation subtract = new Subtract();
        Operation multiply = new Multiply();
        Operation divide = new Divide();

        System.out.println("2 + 3 = " + add.calculate(2, 3));
        System.out.println("5 - 2 = " + subtract.calculate(5, 2));
        System.out.println("4 * 3 = " + multiply.calculate(4, 3));
        System.out.println("10 / 2 = " + divide.calculate(10, 2));
    }
}
