import java.util.Scanner;
class fibonacci {
    static int fibo(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibo(n-1)+ fibo(n-2); 
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a number : ");
            int n = sc.nextInt();
            System.out.println("Fibonacci of "+n+"th number = "+fibo(n));
        }
    }
}
