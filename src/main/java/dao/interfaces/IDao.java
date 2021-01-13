package dao.interfaces;

import java.util.List;

public interface IDao<T> {
	
	public void insert(T t);
	public void update(T t);
	public void delete(Long id);
	public List<T> all();
}
