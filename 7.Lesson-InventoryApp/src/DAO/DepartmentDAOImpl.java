package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Department;

public class DepartmentDAOImpl implements DepartmentDAO{

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
	
	@Override
	public List<Department> findAll() throws Exception{
		
		String query = "select * from department";
		List<Department> depts = new ArrayList<>();
	try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement pmt = conn.prepareStatement(query);
			ResultSet rs = pmt.executeQuery();
			) {
		while(rs.next()) {
			Department dpt = new Department();
			dpt.setId(rs.getInt("id"));
			dpt.setDepartmentName(rs.getString("departmentname"));
			depts.add(dpt);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return depts;
	
	}

	@Override
	public Department findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Department obj) {
		String query = "insert into department(departmentname) values(?)";
	
try(Connection conn = ConnectionManager.getConnection();
		PreparedStatement pmt = conn.prepareStatement(query);
		
		) {
	pmt.setString(1, obj.getDepartmentName());
	pmt.executeQuery();
	}
	
 catch (SQLException e) {
	e.printStackTrace();
	
}
	}

	

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

}
