package performanceMonitoring.jconsole;

public class DeadlockAnalysisUsingJConsole {
	public static void main(String args[]){
		final String resource1 = "Res1";
		final String resource2 = "Res2";
		
		System.out.println(Integer.toHexString(System.identityHashCode(resource1.hashCode())));
		System.out.println(Integer.toHexString(System.identityHashCode(resource2.hashCode())));
		
		Thread t1 = new Thread(){
			public void run(){
				synchronized (resource1) {
					System.out.println("t1 locked resource1");
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (resource2) {
						System.out.println("t1 locked resource2");
					}
				}
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				synchronized (resource2) {
					System.out.println("t2 locked resource2");
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (resource2) {
						System.out.println("t2 locked resource1");
					}
				}
			}
		};
		t1.start();
		t2.start();
	}
}


