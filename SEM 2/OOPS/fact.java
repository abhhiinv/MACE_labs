import java.util.Scanner;
public class fact{
    static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void main(String[] args){
        
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a number");
            int n = sc.nextInt();
            System.out.println("Factorial of "+ n +" = "+factorial(n));
        }
    }
}
