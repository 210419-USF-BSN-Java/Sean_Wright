package com.revature.Daos;

import java.util.List;

public interface CompanyDao<T>{
	
	//Define CR
	public T GetByUserName(String UserName); 
	
	//An employee needs to be able to select an individual customer.
	public T add(T t); 
	
	//An employee needs to be able to add a product to inventory and a customer needs to add an offer. 
	public List<T> GetAll();
	
	//Employees higher up need to be able to view all employee and customer lists	
	public Integer update(T t);
	
	//Delete 
	public Integer delete(T t);
	
}