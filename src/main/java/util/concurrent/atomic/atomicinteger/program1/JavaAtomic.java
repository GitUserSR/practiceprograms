package util.concurrent.atomic.atomicinteger.program1;

/**
 * AtomicInteger is used in applications such as atomically incremented counters.
 *
 */
public class JavaAtomic {
	public static void main(String[] args) throws InterruptedException{
		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Processing count="+ pt.getCount());
		
		ProcessingThreadAtomicInteger ptai = new ProcessingThreadAtomicInteger();
		Thread t3 = new Thread(ptai, "t3");
		t3.start();
		Thread t4 = new Thread(ptai, "t4");
		t4.start();
		t3.join();
		t4.join();
		System.out.println("Processing AtomicInteger count="+ ptai.getAtomicIntegerCount());
	}
}
