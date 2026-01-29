import java.util.Scanner;
class multiTable {
    void table(int n){
        for(int i=1; i<=10; i++){
            System.out.println(n+" x "+i+" = "+(n*i));
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a number : ");
            int n = sc.nextInt();
            multiTable obj = new multiTable();
            obj.table(n);
        }
    }    
}
