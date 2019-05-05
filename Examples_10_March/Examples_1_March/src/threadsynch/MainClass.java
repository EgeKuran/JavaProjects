package threadsynch;

import java.util.Vector;

public class MainClass {

	public static void main(String[] args) {

		Account acc = new Account();
		
		Thread t1 = new Thread(()->{
			
			acc.withdrawMoney(600);
			
		});
		
		Thread t2 = new Thread(()->{
			
			acc.withdrawMoney(600);
			
		});
		
		
		t1.start();
		t2.start();
	}
	
	
	
	
	
}
