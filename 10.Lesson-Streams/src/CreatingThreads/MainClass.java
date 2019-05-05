package CreatingThreads;

public class MainClass {
	
	public static void main(String[] args) 
	{

		CounterThread t1 = new CounterThread();
		
		t1.setName("Thread1");
		
		t1.start();
		
		
		Thread t2 = new Thread(new CounterThread2("Thread2"));
		t2.setDaemon(true);
		t2.start();
		t1.stopThread();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


	static class CounterThread extends Thread 
	{
		boolean canRun=true;
		@Override
		public void run() 
		{			
			for (int i = 0; i < 1000; i++) 
			{
				if(canRun)
				try 
				{
					Thread.sleep(100);
				} 
				catch (InterruptedException e) 
				{
					
					e.printStackTrace();
				}
				
				System.out.println(getName() + "--" + i);
			}
		}
		public void stopThread() 
		{
			canRun = false;
		}
	
	}
	
	
	static class CounterThread2 implements Runnable 
	{
		String name;
		
		
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
		
		public CounterThread2(String name) {
			this.name=name;
			
		}

		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name + "--" + i);
		
			}
			
		}
		
	}


}
