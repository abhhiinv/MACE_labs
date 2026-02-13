package arithmetic;

public class Divide implements Operation{
    public double calculate(double a,double b){
        if(b==0){
            System.out.println("Cannot divide by zero");
            return 0;
        }
        return a/b;
    }
}
