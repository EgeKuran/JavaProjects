package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example {
	public static void main(String[] args) {
		ExecutorService es =Executors.newCachedThreadPool();
		
		es.submit(()->
		{
			for (int i = 0; i < 1000; i++) {
				try {
					Thread.sleep(1000);
					System.out.println("t1 " +i);
				} catch (InterruptedException e) {
					
					break;
				}
			}
		});
		
		es.submit(()->
		{
			for (int i = 0; i < 1000; i++) {
				try {
					Thread.sleep(1000);
					System.out.println("t2 " +i);
				} catch (InterruptedException e) {
					
					
					break;
				}
			}
		});
		//no other threads allowed
		es.shutdown();
		
		try {
			//wait for 1 second
			es.awaitTermination(1000, TimeUnit.MILLISECONDS);
			System.out.println("After await.....");
			es.shutdownNow();
			
		System.out.println("shutdown");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
