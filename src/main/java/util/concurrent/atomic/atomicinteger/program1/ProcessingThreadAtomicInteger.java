package util.concurrent.atomic.atomicinteger.program1;

import java.util.concurrent.atomic.AtomicInteger;

public class ProcessingThreadAtomicInteger implements Runnable{
	private AtomicInteger atomicIntegerCount = new AtomicInteger();

	public void run() {
		for(int i=1; i<5; i++){
			processSomething(i);
			atomicIntegerCount.incrementAndGet();
		}
	}
	
	public AtomicInteger getAtomicIntegerCount(){
		return this.atomicIntegerCount;
	}
	
	private void processSomething(int i){
		try{
			Thread.sleep(i*1000);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}
