package Services;

import java.util.List;



import com.revature.Models.Customer;

public interface CustomerServices {
	
	public String CreateNewCustomerAccount(Customer c);
	public Customer GetCustomerByUserName(String UserName);
	public List<Customer> GetCustomerByName(String Name);
	public List<Customer> GetAllCustomers();
	
}