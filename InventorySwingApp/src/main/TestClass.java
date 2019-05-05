package main;

import java.util.List;

import dao.DepartmentDAOImpl;
import model.Department;

public class TestClass {

public static void main(String[] args) {
		
		try {
			List<Department> depts =
					new DepartmentDAOImpl().findAll();
			
			for (Department department : depts) {
				System.out.println(department.getDepartmentname());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
