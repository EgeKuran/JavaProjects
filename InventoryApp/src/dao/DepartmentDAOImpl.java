package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Department;
import model.Item;

public class DepartmentDAOImpl implements DepartmentDAO{

	
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
	
	
	@Override
	public List<Department> findAll() throws Exception{
		
		String query = "select * from department";
		List<Department> depts = new ArrayList<>();
		try(
				Connection conn = ConnectionManager.getConnection();
				PreparedStatement psmt = conn.prepareStatement(query);
				ResultSet rs = psmt.executeQuery();
				
				) {
			
			while(rs.next()) {
				
				Department dept = new Department();
				dept.setId(rs.getInt("id"));
				dept.setDepartmentname(rs.getString("departmentname"));
				depts.add(dept);

			}
	
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new Exception("Database error");
			
		}
		
		return depts;
	}

	

	@Override
	public void save(Department obj) throws Exception{
		
		
		String query = "insert into department(departmentname) values(?)";
		
		try(
				Connection conn = ConnectionManager.getConnection();
				PreparedStatement psmt = conn.prepareStatement(query);
				
				) {
			
			
			psmt.setString(1, obj.getDepartmentname());
			psmt.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new Exception("Size exceeded");
			
		}
		
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Department findById(int id) throws Exception {
		String query = "select departmentname from department where id=?";
		Department dep = new Department();
		try(
				Connection conn = ConnectionManager.getConnection();
				
				
				) {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				dep.setDepartmentname(rs.getString("departmentname"));
				
			}
	
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new Exception("Database error");
			
		}
		
		return dep;
	}

	public Department findByName(String name) throws Exception {
		String query = "select id from department where departmentname=?";
		Department dep = new Department();
		try(
				Connection conn = ConnectionManager.getConnection();
				
				
				) {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, name);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				dep.setId(rs.getInt("id"));
				
			}
	
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new Exception("Database error");
			
		}
		
		return dep;
	}


}
