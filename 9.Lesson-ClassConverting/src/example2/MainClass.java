package example2;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import example1.Product;
import example1.ProductRepository;

public class MainClass {
	public static void main(String[] args) {
	
		List<Product> products = ProductRepository.getProductList();
		
		//return boolean , parameter T
		
		Predicate<Product> prodPred = t ->t.getProductName().contains("Mouse");
		
		System.out.println(prodPred.test(products.get(0)));
		products.forEach(t->System.out.println( prodPred.test(t)));
		
		Supplier<Product> prodSup = ()->  new Product("Test", 100, true, 0.18, "TV", 12);

		System.out.println(prodSup.get().getProductName());
		
		Function<Product, String> converterFunc = p ->p.getProductName();
		
		System.out.println(converterFunc.apply(products.get(0)));
	
		
	
	
	}

}
