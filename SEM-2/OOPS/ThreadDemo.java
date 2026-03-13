/*
Wite a java program that creates two threads to perform the following:
    Thread A(Extending Thread):Print the squares of numbers from 1 to 10 with a delay of 500ms between each print
    Thread B(Implementing Runnable):Print the cubes of numbers from 1 to 10 with a delay of 700ms between each print.
Main Thread must ensure that the message "Calculations Complete!" 
is only printed after both threads have finished their execution
*/
class ThreadA extends Thread{
    public void run(){
        try{
            for(int i=1; i<=10; i++){
                System.out.println("Square of "+i+" = "+i*i);
                Thread.sleep(500);
            }
        }
        catch(InterruptedException e){
            e.getMessage();
        }
    }
}

class ThreadB implements Runnable{
    public void run(){
        try{
            for(int i=1;i<=10;i++){
                System.out.println("Cube of "+i+" = "+i*i*i);
                Thread.sleep(700);
            }
        }
        catch(InterruptedException e){
            e.getMessage();
        }
    }
}

public class ThreadDemo{
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA();
        ThreadB tB = new ThreadB();
        Thread t2  = new Thread(tB);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.getMessage();
        }
        System.out.println("Calculations Complete!");
    }
}