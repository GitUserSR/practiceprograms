package util.Runnable;

public class TestRunnable {
	
	public static void main(String args[]){
		
	Thread t1 = new Thread(new Runnable(){
			public void run() {
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		);
	t1.start();
	System.out.println(t1.isAlive());
	System.out.println(t1.getId());
	
	while(true){
		System.out.println(t1.getState());
	}
	}
	
}
