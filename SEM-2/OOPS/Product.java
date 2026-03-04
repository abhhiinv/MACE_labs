import java.util.*;

public class Product {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <String> products = new ArrayList<>();
        int ch;
        while(true){
            System.out.print("\n1)Add product\n2)Sort products\n3)Display products\n4)Exit\nEnter your choice : ");
            ch = sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:{
                    System.out.print("Enter name of the product : ");
                    products.add(sc.nextLine());
                    break;
                }
                case 2:{
                    System.out.print("Sorting...");
                    Collections.sort(products);
                    break;
                }
                case 3:{
                for(String x:products){
                   System.out.print(x+"\n");
                }
                break;
                }
                case 4:{
                    return;
                }
            }
        }
    }
}
