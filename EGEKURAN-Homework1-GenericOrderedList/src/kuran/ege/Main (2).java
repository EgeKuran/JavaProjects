package kuran.ege;



public class Main {
	public static void main(String[] args) {
		
		
		String a = new String();
		String b = new String();
		String c = new String();
		
		a = "a";
		b = "b";
		c = "c";
		MyList<String> myList = new  MyList<String>();
		
		myList.add(a);
		myList.add(b);
		myList.add(c);
		myList.add(a);
		myList.add(b);
		myList.add(c);
		myList.add(a);
		myList.add(b);
		myList.add(c);
		myList.add(c);
		System.out.println(myList.count());
		
		for (int i = 0; i < myList.count(); i++) {
			System.out.print(myList.get(i) + "-");
		}
		System.out.println("-------");
		myList.remove(2);
		for (int i = 0; i < myList.count(); i++) {
			System.out.print(myList.get(i) + "-");
		}
	
		
	}

}
