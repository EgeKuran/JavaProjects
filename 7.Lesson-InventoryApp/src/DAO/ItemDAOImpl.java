package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Department;
import model.Item;

public class ItemDAOImpl implements ItemDAO{

	@Override
	public List<Item> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Item obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Item obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> findItemByDepartmentId(int deptid) {

		String query = "select * from item where department_id=?";
		List<Item> items = new ArrayList<>();
	try(Connection conn = ConnectionManager.getConnection();
			
			) {PreparedStatement pmt = conn.prepareStatement(query);
			pmt.setInt(1, deptid);
			ResultSet rs = pmt.executeQuery();
		while(rs.next()) {
			Item item = new Item();
			item.setId(rs.getInt("id"));
			item.setDepartmentName(rs.getInt("departmentName"));
			item.setItemName(rs.getString("itemName"));
			item.setPrice(rs.getDouble("price"));
			item.setQuantitiy(rs.getInt("quantity"));
			items.add(item);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return items;
	}

}
