package Main;

import java.util.List;

import DAO.DepartmentDAOImpl;
import model.Department;

public class TestClass {
	public static void main(String[] args) {
		List<Department> depts;
		try {
			depts = new DepartmentDAOImpl().findAll();
			for (Department department : depts) {
				
				System.out.println(department);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
