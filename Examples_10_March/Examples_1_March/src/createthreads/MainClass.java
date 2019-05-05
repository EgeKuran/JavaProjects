package createthreads;

public class MainClass {

	public static void main(String[] args) {
	
		CounterThread1 t1 = new CounterThread1();
		t1.setName("Thread 1");
		t1.setDaemon(true);
		t1.start();
		
		Thread t2 = new Thread(new CounterThread2("Thread 2"));
		t2.setDaemon(true);
		t2.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t1.stopThread();
		
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static class CounterThread2 implements Runnable{
		String name;
		
		public CounterThread2(String name) {
			this.name = name;
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
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	
	
	static class CounterThread1 extends Thread{
		boolean canRun = true;
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				if(canRun) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getName() + "--" + i);
				
				}else break;
			}
			
		}
		
		public void stopThread() {
			canRun = false;
		}
		
		
	}
	
	
}
