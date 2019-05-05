package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Examples {

	public static void main(String[] args) {
		
		
		ExecutorService srv=
				Executors.newCachedThreadPool();
		
		
		srv.submit(()->{
			
			for (int i = 0; i < 1000; i++) {
				try {
					Thread.sleep(100);
					System.out.println(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					break;
				}
	
			}
			
			
		});
		
		srv.submit(()->{
			
			for (int i = 0; i < 1000; i++) {
				try {
					Thread.sleep(100);
					System.out.println("t2:" + i);
				} catch (InterruptedException e) {
					break;
				}
				
				
				
			}

		});
		
		//no new threads allowed
		srv.shutdown();
		
		
		try {
			//wait for two seconds
			srv.awaitTermination(5000, TimeUnit.MILLISECONDS);
			System.out.println("After await...");
			srv.shutdownNow();
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
}
