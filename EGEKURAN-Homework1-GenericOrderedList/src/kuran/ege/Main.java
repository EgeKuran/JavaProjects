package kuran.ege;

public class Main {
	public static void main(String[] args) {
		
		
		String a = new String();
		String b = new String();
		String c = new String();
		
		
		MyList<String> myList = new  MyList<String>();
		
		myList.add(a);
		myList.add(b);
		myList.add(c);
		
		String result = myList.get(2);
		
		myList.remove(2);
	
		System.out.println(myList.count());
		
	}

}