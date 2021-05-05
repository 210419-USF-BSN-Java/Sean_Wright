package com.revature.Daos;

import java.util.List;

import com.revature.Models.Customer;

public interface CustomerDao extends CompanyDao<Customer>{
	
	public List<Customer> getByName(String Name);
}
