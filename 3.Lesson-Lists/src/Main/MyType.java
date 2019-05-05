package Main;

public class MyType <T> {
	
	private T item;
	
	public MyType() {
		// TODO Auto-generated constructor stub
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	private void getInfo() {
		System.out.println(item.toString()); 
		
	}

}
