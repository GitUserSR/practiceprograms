package util.concurrent.callable;

import java.util.concurrent.*;

public class TestTimeout {
	private static long staticNum = 1000;
	private long nonstatic = 2000;
    public static void main(String[] args) throws Exception {
    	
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<String> future = executor.submit(new Task());

        try {
            System.out.println("Started..");
            System.out.println(future.get(3, TimeUnit.SECONDS));
            System.out.println("Finished!");
        } catch (TimeoutException e) {
            System.out.println("Terminated!");
            e.printStackTrace();
        }

        executor.shutdownNow();
    }
}

class Task implements Callable<String> {
	
    public String call() throws Exception {
        Thread.sleep(1800000); // Just to demo a long running task of 4 seconds.
        return "Ready!";
    }
}