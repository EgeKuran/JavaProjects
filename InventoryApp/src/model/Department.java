package model;

public class Department extends BaseEntity{
	
	private String departmentname;
	
	
	
	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	
	@Override
	public String toString() {
		return departmentname;
	}
	

}
