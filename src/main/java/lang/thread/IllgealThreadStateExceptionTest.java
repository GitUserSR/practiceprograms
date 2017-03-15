package lang.thread;

/**
 * Created by srapolu on 2/22/17.
 */
public class IllgealThreadStateExceptionTest {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println("IllgealThreadStateExceptionTest.main " + t.getId());
        t.start();
    }
}
