/*
Find the average of N positive integers, 
raising a user defined exaception for each negative input
*/
import java.util.*;

// User-defined exception for negative numbers
class NegativeNumberException extends Exception {
    public NegativeNumberException(int number) {
        super("Invalid input: " + number + " is a negative number. Only positive integers allowed.");
    }
}

public class excep_numcheck {

    static int checkPositive(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException(number);
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the count of numbers (N): ");
        int n = sc.nextInt();

        int sum = 0;
        int validCount = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            int input = sc.nextInt();

            try {
                int validNumber = checkPositive(input);
                sum += validNumber;
                validCount++;
            } catch (NegativeNumberException e) {
                System.out.println("Exception caught -> " + e.getMessage());
            }
        }

        if (validCount > 0) {
            double average = (double) sum / validCount;
            System.out.println("\nSum of valid inputs     : " + sum);
            System.out.println("Count of valid inputs   : " + validCount);
            System.out.printf("Average of valid inputs : %.2f%n", average);
        } else {
            System.out.println("No valid positive integers were entered.");
        }

        sc.close();
    }
}