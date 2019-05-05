package threadsynch;

public class Account {

	private double balance = 1000.0;
	
	
	public synchronized  void withdrawMoney(double amount) {
		
		
		if(balance>=amount) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			balance -= amount;
			System.out.println("Money withdraw, balance:" +
						balance);
		}else{
			System.out.println("Not enough balance");
		}
		
		
	}
	
	
	
	
}
