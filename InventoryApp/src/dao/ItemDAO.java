package dao;

import java.util.List;

import model.Item;

public interface ItemDAO extends BaseDAO<Item>{

	public List<Item> findItemsByDepartmentId(int deptid) throws Exception;

	public void update(Item item) throws Exception;
	
}
