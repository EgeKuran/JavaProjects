package q1;

import java.util.ArrayList;
import java.util.List;

public class ProductInfo {


	private String productName;
	private double productPrice;
	private boolean available;
	private double vat;
	
	private ProductInfo(String productName, double productPrice, boolean available, double vat) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.available = available;
		this.vat = vat;
	}
	
	public String getProductName() {
		return productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public static List<ProductInfo> getProducts() {
		
		List<ProductInfo> products = new ArrayList<>();
		products.add(new ProductInfo("Mouse", 12.34,false,0.18));
		products.add(new ProductInfo("Laptop", 1220,true,0.18));
		products.add(new ProductInfo("Laptop Bag", 310,true,0.18));
		products.add(new ProductInfo("Washing Machine", 2200,true,0.18));
		products.add(new ProductInfo("TV 12 Inch", 850,true,0.18));
		products.add(new ProductInfo("TV 20 Inch", 1350,false,0.18));
		products.add(new ProductInfo("TV 30 Inch", 1750,true,0.18));
		products.add(new ProductInfo("TV 42 Inch", 2250,true,0.18));
		products.add(new ProductInfo("Iphone 5", 1700,false,0.18));
		products.add(new ProductInfo("Iphone 6", 2500,true,0.18));
		products.add(new ProductInfo("Iphone 7", 3300,true,0.18));
		products.add(new ProductInfo("Samsung Tablet", 1385,true,0.18));
		products.add(new ProductInfo("Hair Dryer", 85,true,0.18));
		products.add(new ProductInfo("Apples 1kg", 3,true,0.01));
		products.add(new ProductInfo("Cherries 1kg", 7,true,0.01));
		products.add(new ProductInfo("Melon 1kg", 4.75,true,0.01));
		products.add(new ProductInfo("Toast Bread", 2,true,0.01));
		products.add(new ProductInfo("Cake", 5,true,0.01));
		
		return products;
		
	}
	
	public double getVat() {
		return vat;
	}
	
}
