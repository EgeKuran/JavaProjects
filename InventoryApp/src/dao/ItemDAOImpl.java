package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Item;

public class ItemDAOImpl implements ItemDAO{
	@Override
	public List<Item> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Item obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Item obj) throws Exception{

		 try (Connection conn = ConnectionManager.getConnection();){
		     String query = "UPDATE item SET  itemname = ?,department_id = ?, price = ?, quantity = ? WHERE id = ?";
		     
		     PreparedStatement pst =conn.prepareStatement(query);
		     
		     pst.setString(1, obj.getItemname());
		     pst.setInt(2, obj.getDepartmentid());
		     pst.setDouble(3,obj.getPrice());
		     pst.setInt(4, obj.getQuantity());
		     pst.setInt(5, obj.getId());
		    
		     
		     pst.executeUpdate();
		    System.out.println( "Data Updated Successfully");
		     
		     pst.close();
		     
		    } catch (Exception e) {
		     e.printStackTrace();
		    }
	}

	@Override
	public List<Item> findItemsByDepartmentId(int deptid) throws Exception{
		String query = "select * from item where department_id=?";
		List<Item> items = new ArrayList<>();
		try(
				Connection conn = ConnectionManager.getConnection();
				
				
				) {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, deptid);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setDepartmentid(rs.getInt("department_id"));
				item.setItemname(rs.getString("itemname"));
				item.setPrice(rs.getDouble("price"));
				item.setQuantity(rs.getInt("quantity"));
				items.add(item);
				
			}
	
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new Exception("Database error");
			
		}
		
		return items;
	}

	
	
	
	
}
