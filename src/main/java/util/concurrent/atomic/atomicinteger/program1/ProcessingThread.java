package util.concurrent.atomic.atomicinteger.program1;

public class ProcessingThread implements Runnable{
	private int count;
	
	public void run(){
		for(int i=1; i<5; i++){
			processSomething(i);
			count++;
		}
	}
	
	public int getCount(){
		return this.count;
	}
	
	private void processSomething(int i){
		try{
			Thread.sleep(i*1000);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}
