package setExample;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainClass {
	public static void main(String[] args) {
		
		Set<String> nameSet = new HashSet<>();
		
		nameSet.add("Mehmet");
		nameSet.add("Ahmet");
		nameSet.add("Ege");
		nameSet.add("Ali");
		nameSet.add("Veli");
		nameSet.add("Aykut");
		nameSet.add("Merve");
		nameSet.add("Mehmet");
		nameSet.add("Ahmet");
		nameSet.add("Ege");
		nameSet.add("Ali");
		nameSet.add("Veli");
		nameSet.add("Aykut");
		nameSet.add("Merve");
	
		
		for (String name : nameSet) {
			System.out.println(name);
			
		}
		System.out.println("----------------");
		Iterator<String> namesIterator =nameSet.iterator();
		
		while (namesIterator.hasNext()) {
			String names = namesIterator.next();
			System.out.println(names);
			
			
		}
		
		
	}

}
