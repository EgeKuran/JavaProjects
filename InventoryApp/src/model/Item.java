package model;

public class Item extends BaseEntity{

	private String itemname;
	private int departmentid;
	private double price;
	private int quantity;
	
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	public String getItemname() {
		return itemname;
	}

	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return itemname;
	}
	
}
