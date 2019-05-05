package dao;

import java.util.List;

public interface BaseDAO<T> {

	
	public List<T> findAll() throws Exception;
	public T findById(int id) throws Exception;
	public void save(T obj) throws Exception;
	public void update(T obj) throws Exception;
	
	
}
