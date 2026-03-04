import java.util.*;
public class nameList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <String> names = new ArrayList<>();
        int ch;
        while(true){
            System.out.print("\n1)Add name\n2)Remove name\n3)Search name\n4)Sort names\n5)Display names\n6)exit\nEnter your choice : ");
            ch = sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:{
                    System.out.print("Enter the name : ");
                    names.add(sc.nextLine());
                    break;
                }
                case 2:{
                    System.out.print("Enter the name to remove : ");
                    names.remove(sc.nextLine());
                    break;
                }
                case 3:{
                    System.out.print("Enter the name to search : ");
                    String s = sc.nextLine();
                    if(names.contains(s)){
                        System.out.println("Name found ^_^ ");
                    }
                    else{
                        System.out.println("Name not found !!! ");
                    }
                    break;
                }
                case 4:{
                    System.out.print("Sorting names...");
                    Collections.sort(names);
                    break;
                }
                case 5:{
                for(String x:names){
                   System.out.print(x+"\n");
                }
                break;
                }
                case 6:{
                    return;
                }
                default:{
                    System.out.println("Invalid choice");
                }
            }
            // names.add();
            // names.remove();
            // names.contains();
            // for(String x:names){
            //     System.out.println(x);
            // }
        }
    }
}