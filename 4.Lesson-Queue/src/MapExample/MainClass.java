package MapExample;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainClass {
	public static void main(String[] args) {
		HashMap<String, String> personData = new HashMap<>();
		
		personData.put("Key1", "Value1");
		personData.put("Key2", "Value2");
		personData.put("Key3", "Value3");
		personData.put("Key4", "Value4");
		
//		System.out.println(personData.get("Key1"));
		
		Set<String> set1 = personData.keySet();
		
		for (String key: set1) {
			System.out.println(key + ":" + personData.get(key));
		}
		
		Map<Long, Object > dbDta = new HashMap<>();
		dbDta.put(0L, new Object());
		dbDta.put(1L, new Object());
		dbDta.put(2L, new Object());
		dbDta.put(3L, new Object());
		
		Set<Long> set2 = dbDta.keySet();
		
		for (Long key : set2) {
			System.out.println(key + ":" + dbDta.get(key));
			
		}
		//Boxing,from primitive to reference
		//Integer i1 = 34;
		
		
		//Unboxing from reference to primitive
		// Integer i1 = new Integer(2);
		// int x = i1;
	}

}
