package service;

import java.util.List;

import DAO.DepartmentDAO;
import DAO.DepartmentDAOImpl;
import model.Department;
import model.Item;

public class BussService {
	
	public static void main(String[] args) {
		try {
			List<Department> depts = new BussService().getAllDepartments();
			depts.forEach(t->System.out.println(t));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Department> getAllDepartments() throws Exception
	{
		
		DepartmentDAO deptDAO =  new DepartmentDAOImpl();

		return deptDAO.findAll();}

	public List<Item> getItemsByDeptId(Department selectedItem) {
		// TODO Auto-generated method stub
		return null;
	}

}
