package CreatingThreads;

public class AccountMain {
	public static void main(String[] args) {
		
		Account ac = new Account();
		Thread t1= new Thread(()->
		{
			ac.withdraw(600);
			
		});
		
		Thread t2= new Thread(()->
		{
			ac.withdraw(600);
			
		});
		
		t1.start();
		t2.start();
	}

}
