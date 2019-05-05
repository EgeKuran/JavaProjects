package example1;

import java.util.List;
import java.util.function.Consumer;

public class MainClass {
	public static void main(String[] args) {
		List<Product> products = ProductRepository.getProductList();
		
		Converter<Product,String> converter = p->p.getProductName();
		
		System.out.println(converter.convert(products.get(0)));
		products.forEach(t ->System.out.println(t.getProductName()));
	}

}
