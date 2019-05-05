package DAO;

import java.util.List;

import model.Item;

public interface ItemDAO extends BaseDAO<Item> {

	public List<Item> findItemByDepartmentId(int deptid);
}
