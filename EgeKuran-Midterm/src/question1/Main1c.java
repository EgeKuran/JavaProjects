package question1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Main1c {
	public static void main(String[] args) {
		List<Product> products = ProductRepository.getProductList();
		
		TreeMap<String, Integer> tm = new TreeMap<>();
		
		for (Product product : products) {
			if(tm.containsKey(product.getDepartment())) 
			{
				tm.put(product.getDepartment(), tm.get(product.getDepartment())+1);
			}
			else {
			tm.put(product.getDepartment(), 1);
			}
		}
		
		Set<String> keySet = tm.keySet();
		for (String key : keySet) {
			System.out.println("Key: " + key + "\tValue: " + tm.get(key) + "\n" );
		}
		
	} 

}
