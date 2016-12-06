package lang.ThreadLocal;

/**
 * Created by srapolu on 8/13/15.
 */
public class ThreadLocal1 {

    private static class MyRunnable implements Runnable{

        private ThreadLocal<Integer> myThreadLocal = new ThreadLocal<Integer>();


        @Override
        public void run() {
            myThreadLocal.set((int)(Math.random()*100D));
            System.out.println(Thread.currentThread().getName() + ">> myThreadLocal.get() = " + myThreadLocal.get());
        }

    }

    public static void main(String[] args) throws InterruptedException{
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable,"myThread1");
        Thread thread2 = new Thread(myRunnable,"myThread2");

        thread1.start();
        thread2.start();
    }
}
