package lang.thread;

/**
 * Created by srapolu on 2/17/17.
 */
public class MainAndMyThreadTest {
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();
        for(int i=0; i<2; i++){
            System.out.println("Main Thread");
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0; i<2; i++){
            System.out.println("Child Thread");
        }
    }
}
