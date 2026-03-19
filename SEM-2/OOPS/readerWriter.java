// READER-WRITER PROBLEM
class Reader implements Runnable {
    static final Object lock = readerWriter.lock;
    static boolean writeDone = false;
 
    @Override
    public void run() {
        synchronized (lock) {
            try {
                while (!writeDone) {
                    lock.wait();
                }
                System.out.println("Read A");
                Thread.sleep(500);
                System.out.println("Read B");
                Thread.sleep(500);
                System.out.println("Read C");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
 
class Writer implements Runnable {
    static final Object lock = readerWriter.lock;
 
    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("Write A");
                Thread.sleep(500);
                System.out.println("Write B");
                Thread.sleep(500);
                System.out.println("Write C");
                Reader.writeDone = true;
                lock.notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
 
public class readerWriter {
    static final Object lock = new Object();
    public static void main(String[] args) {
        Reader reader = new Reader();
        Writer writer = new Writer();
 
        Thread writerThread = new Thread(writer);
        Thread readerThread = new Thread(reader);
        writerThread.start();
        readerThread.start();
    }
}