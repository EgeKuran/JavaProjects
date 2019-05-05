package question1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main1b {
	public static void main(String[] args) {
		List<Product> products = ProductRepository.getProductList();
		
		Collections.sort(products, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				double a = o1.getProductPrice()*o1.getUnitsSold();
				double b = o2.getProductPrice()*o2.getUnitsSold();
				if(a>b) {return  -1;}
				if(a==b) {return 0;}
				return 1;
			}
		});
		products.forEach(t->System.out.println(t.getProductName() + ": " + (t.getProductPrice()*t.getUnitsSold())));
	}

}
