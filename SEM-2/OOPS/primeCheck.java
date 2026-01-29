import java.util.Scanner;

class primeCheck {
    void prime(int n){
        if(n<=1){
            System.out.println("Not a prime");
            return;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                System.out.println(n+" is not a prime number");
                return;
            }
        }
        System.out.println(n+" is a prime number");
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a number to check : ");
            int n = sc.nextInt();
            primeCheck obj = new primeCheck();
            obj.prime(n);
        }
    }
}
