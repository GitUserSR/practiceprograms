package lang.thread;

/**
 * Created by srapolu on 2/21/17.
 */
public class OverrideThreadClassStartMethod {
    public static void main(String[] args) {
        OverrideThreadClassStartMethodThread thread = new OverrideThreadClassStartMethodThread();
        thread.start();
        System.out.println("OverrideThreadClassStartMethod.main");
    }
}

class OverrideThreadClassStartMethodThread extends Thread{
    @Override
    public synchronized void start() {
        super.start();
        System.out.println("OverrideThreadClassStartThread.start");
    }

    @Override
    public void run() {
        System.out.println("OverrideThreadClassStartThread.run");
    }
}