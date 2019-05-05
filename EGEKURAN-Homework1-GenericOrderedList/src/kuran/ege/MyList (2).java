package kuran.ege;

public class MyList<T > {
	private T[] element;
	private static final int defaultCapacity =10;
	private int size;
	
	public   MyList() {
		this(defaultCapacity);
		
		
				

}

	public MyList(int capacity) {
		element = (T[]) new Object[capacity];
	}

	public int count() {
		return size;
	}

	public boolean add(T e)
	   {
	        if (size == element.length)
	       checkCapacity(size + 1);
	   element[size++] = e;
	      return true;
	    }
	public void checkCapacity(int minCapacity)
	   {
	     int current = element.length;
	     	if (minCapacity > current)
	       {
	          T[] newElement = (T[]) new Object[Math.max(current * 2, minCapacity)];
	         System.arraycopy(element, 0, newElement, 0, size);
	          element = newElement;
	       }
	   }
	public T remove(int index)
	{
	     checkBounds(index);
	      T r = element[index];
	    
	    if (index != --size)
	      System.arraycopy(element, index + 1, element, index, size - index);
	    
	      element[size] = null;
	     return r;
	   }
	
	public T get(int index)
	   {
	   checkBounds(index);
	    return element[index];
	   }
	 private void checkBounds(int index)
	 {	    if (index > size)
	       throw new IndexOutOfBoundsException("Index: " + index + ", Size: "+ size);
	 		if (index >= size)
		    throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
		                                         + size);
	  }
	 
	 
}