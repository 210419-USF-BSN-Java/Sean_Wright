package com.revature.Daos;

import java.util.List;

public interface GenericDao<T> {

	public T add(T t);
	public Integer delete(T t);
	public Integer update(T t);
	public T getByID(Integer i); // get by a type id. ie. Users, reimbursements ect. 
	public List<T> getAll();
	
}
