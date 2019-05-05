package example1;

public class MainClass {
	public static void main(String[] args) {
		MyCountThread t1 = new MainClass().new MyCountThread();
		
		t1.start();
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Main Thread: " + i);
		}
		
		
	}

	class MyCountThread extends Thread
	{
		public MyCountThread() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println("Count Thread" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
}
