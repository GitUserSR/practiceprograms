package lang.thread;

public class DaemonTest {

	public static void main(String[] args) {
		new WorkerThread().start();
		try {
			Thread.sleep(7500);
		} catch (InterruptedException e) {
		}
		System.out.println("Main Thread ending");
	}

}

class WorkerThread extends Thread {

	public WorkerThread() {
		
		setDaemon(true); // When false, (i.e. when it's a user thread),
		// the Worker thread continues to run.
		// When true, (i.e. when it's a daemon thread),
		// the Worker thread terminates when the main
		// thread terminates.
	}

	public void run() {
		int count = 0;
		while (true) {
			System.out.println("Hello from Worker " + count++);
			try {
				sleep(5000);
			} catch (InterruptedException e) {
			}
		}
	}
}

/*
 * A daemon thread is a thread, that does not prevent the JVM from exiting when the program finishes but the thread is still running.
 * -When a new thread is created it inherits the daemon status of its parent.
 * -Normal thread and daemon threads differ in what happens when they exit. When the JVM halts any remaining daemon threads are abandoned: **finally blocks are not executed**, stacks are not unwound - JVM just exits. Due to this reason daemon threads should be used sparingly and it is dangerous to use them for tasks that might perform any sort of I/O.
 * */
