package model;

public class Item extends BaseEntity{
	
	private String itemName;
	private int departmentName;
	private double price;
	private int quantitiy;
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(int departmentName) {
		this.departmentName = departmentName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantitiy() {
		return quantitiy;
	}
	public void setQuantitiy(int quantitiy) {
		this.quantitiy = quantitiy;
	}
	

}
