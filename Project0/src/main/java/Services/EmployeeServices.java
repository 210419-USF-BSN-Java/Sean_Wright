package Services;

import java.util.List;

import com.revature.Models.Employee;

public interface EmployeeServices {
	
	public String CreateEmployeeAccount(Employee e);
	public Integer RemoveEmployeeAccount(Employee e);
	public Integer UpdateEmployeeInformation(Employee e);
	public Employee GetEmployeeByUserName(String UserName);
	public List<Employee> GetEmployeeByName(String Name);
	public List<Employee> GetAllEmployees();
	
}

