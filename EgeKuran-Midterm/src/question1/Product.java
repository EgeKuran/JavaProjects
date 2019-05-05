package question1;

import java.util.Comparator;

public class Product implements Comparator<Product>{
	private String productName;
	private double productPrice;
	private int unitsSold;
	private boolean available;
	private double vat;
	private String department;

	public Product(String productName, double productPrice, boolean available, double vat, String department, int unitsSold) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.available = available;
		this.vat = vat;
		this.department = department;
		this.unitsSold = unitsSold;
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

	public double getVat() {
		return vat;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}
	
	public int getUnitsSold() {
		return unitsSold;
	}

	

	@Override
	public int compare(Product arg0, Product arg1) {
		// TODO Auto-generated method stub
		return arg0.getProductName().compareTo(arg1.getProductName());
	}

	
	
}