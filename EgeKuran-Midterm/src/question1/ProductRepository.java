package question1;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

	private static List<Product> products;

	private ProductRepository() {}
	
	
	public static List<Product> getProductList() {
		if (products == null) {
			products = new ArrayList<>();
			products.add(new Product("Mouse", 12.34, false, 0.18, "Computers", 120));
			products.add(new Product("Laptop", 1220, true, 0.18, "Computers", 130));
			products.add(new Product("Laptop Bag", 310, true, 0.18, "Computers", 95));
			products.add(new Product("Washing Machine", 2200, true, 0.18, "Utilities", 43));
			products.add(new Product("TV 12 Inch", 850, true, 0.18, "TV", 34));
			products.add(new Product("TV 20 Inch", 1350, false, 0.18, "TV", 45));
			products.add(new Product("TV 30 Inch", 1750, true, 0.18, "TV", 56));
			products.add(new Product("TV 42 Inch", 2250, true, 0.18, "TV", 66));
			products.add(new Product("Iphone 5", 1700, false, 0.18, "Smart Phones", 54));
			products.add(new Product("Iphone 6", 2500, true, 0.18, "Smart Phones", 90));
			products.add(new Product("Iphone 7", 3300, true, 0.18, "Smart Phones", 90));
			products.add(new Product("Samsung Tablet", 1385, true, 0.18, "Smart Phones", 90));
			products.add(new Product("Hair Dryer", 85, true, 0.18, "Utilities", 35));
			products.add(new Product("Apples 1kg", 3, true, 0.01, "Grocery", 33));
			products.add(new Product("Cherries 1kg", 7, true, 0.01, "Grocery", 56));
			products.add(new Product("Melon 1kg", 4.75, true, 0.01, "Grocery", 76));
			products.add(new Product("Toast Bread", 2, true, 0.01, "Bakery", 123));
			products.add(new Product("Cake", 5, true, 0.01, "Bakery", 345));

		}

		return products;

	}

}
