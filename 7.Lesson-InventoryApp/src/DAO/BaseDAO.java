package DAO;

import java.util.List;

public interface BaseDAO<T> {
	
	public List<T> findAll() throws Exception;
	public T findById();
	public void save(T obj);
	public void update(T obj);
	

}
