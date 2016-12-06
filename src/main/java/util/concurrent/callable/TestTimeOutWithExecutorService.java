package util.concurrent.callable;

import java.util.concurrent.*;

public class TestTimeOutWithExecutorService {
	
	private BlockingQueue<String> eventInfos = new LinkedBlockingQueue<String>(20000);
	
	TestTimeOutWithExecutorService(){
		init();
	}
	
	public static void main(String[] args) {
		TestTimeOutWithExecutorService testTimeOutWithExecutorService = new TestTimeOutWithExecutorService();
		testTimeOutWithExecutorService.offerEventInfo();
	}	
	
	public void offerEventInfo(){
		for(int i=0; i<10000; i++){
			eventInfos.offer(Integer.toString(1));
		}
	}
	
	public void init(){
		ExecutorService executor = new ThreadPoolExecutor(3,5,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
		CompletionService<Boolean> completionService = new ExecutorCompletionService<Boolean>(executor); 
		
		ExecutorService executionTimeMonitorService = new ThreadPoolExecutor(1,5,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
		executionTimeMonitorService.submit(new MonitorExecutionTime(completionService));
		
		LogEvent logEvent = new LogEvent();
		completionService.submit(logEvent);
	}
	
	 class MonitorExecutionTime implements Callable<String>{
		 CompletionService<Boolean> completionService;
		 MonitorExecutionTime(CompletionService<Boolean> completionService){
			 this.completionService = completionService;
		 }
		 public String call(){
			 Future<Boolean> future;
			 while(true){
				 try{
					 if((future = completionService.take())!=null){
						 future.get(1, TimeUnit.NANOSECONDS);
					 }
				 }catch(Exception e){
					 e.printStackTrace();
				 }
			 }
		 }
	 } 

	 class LogEvent implements Callable<Boolean>{
		public Boolean call(){
			while(true){
				if(null != eventInfos && eventInfos.size() >0 ){
					System.out.println(eventInfos.poll());
					try{
						Thread.sleep(1L);
					}catch(Exception e){
						 e.printStackTrace();
					}
				}
			}
		}
	}
}
