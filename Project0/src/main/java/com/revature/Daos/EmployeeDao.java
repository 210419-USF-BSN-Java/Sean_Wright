package com.revature.Daos;

import java.util.List;

import com.revature.Models.Employee;

public interface EmployeeDao extends CompanyDao<Employee>{
	
	List<Employee> getByName(String Name);
	
}
