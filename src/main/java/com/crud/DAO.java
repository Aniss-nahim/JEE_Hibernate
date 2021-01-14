package com.crud;


import java.util.List;
import com.bean.Voiture;


public interface DAO<T> {
	
	public void insert(T t);
	public void update(T t);
	public void delete(Long id);
	public List<T> all();

}
