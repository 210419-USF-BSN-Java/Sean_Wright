package Services;

import java.util.List;


import com.revature.Daos.DaoFactory;
import com.revature.Daos.CustomerDao;
import com.revature.Models.Customer;

public class CustomerServiceImplementation  implements CustomerServices{
	
	
	private CustomerDao cd;
	
	public CustomerServiceImplementation() {
		cd = DaoFactory.getDaoFactory().getCustomerDao();
	}
	
	@Override
	public String CreateNewCustomerAccount(Customer c) {
		return cd.add(c).GetCustomerUserName();
	}

	@Override
	public Customer GetCustomerByUserName(String UserName) {
		return cd.GetByUserName(UserName);
	}

	@Override
	public List<Customer> GetAllCustomers() {
		return cd.GetAll();
	}

	@Override
	public List<Customer> GetCustomerByName(String Name) {
		return cd.getByName(Name);
	}
}
