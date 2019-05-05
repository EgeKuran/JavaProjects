package createthreads;

public class ThreadExample2 {

	public static void main(String[] args) {

		Thread t3 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println(i);
			}
		});
		
		t3.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("--------");
		t3.start();
		
		
	

	}

}
