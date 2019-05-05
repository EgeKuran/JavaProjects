package question1;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Main1a {
	public static void main(String[] args) {
		List<Product> products = ProductRepository.getProductList();
		Collections.sort(products,new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				
				return o1.getProductName().compareTo(o2.getProductName());
			}
		});
		products.forEach(t->System.out.println(t.getProductName()));
	}

}
