package service;

import java.util.List;

import dao.DepartmentDAO;
import dao.DepartmentDAOImpl;
import dao.ItemDAO;
import dao.ItemDAOImpl;
import model.Department;
import model.Item;

public class BussService {

	public static void main(String[] args) {
		try {
			List<Department> depts = new BussService().getAllDepartments();
		
			depts.forEach(t-> System.out.println(t));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void saveDepartment(Department dept) throws Exception{
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		try {
			deptDAO.save(dept);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<Department> getAllDepartments() throws Exception{
		
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		
		return deptDAO.findAll();
		
		
	}
	
	
	public List<Item> getItemsByDeptId(int deptid) throws Exception{
		ItemDAO itemDAO = new ItemDAOImpl();
		return itemDAO.findItemsByDepartmentId(deptid);
	
	}
	
	
	public void updateItem(Item item) throws Exception
	{
		ItemDAO itemDAO = new  ItemDAOImpl();
		
		try {
			itemDAO.update(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	} 
}
