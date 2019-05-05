package main;

public class Box<T,E> {
	
	private T myType;
	private E mySecondType;
	
	public String getInfo() 
	{
		return myType.getClass().getName();
	}
	
	
	public T getMyType() {
		return myType;
	}
	
	public void setMyType(T myType) {
		this.myType = myType;
	}


	public E getMySecondType() {
		return mySecondType;
	}


	public void setMySecondType(E mySecondType) {
		this.mySecondType = mySecondType;
	}

}
