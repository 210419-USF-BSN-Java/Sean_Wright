package Services;

import java.util.List;

import com.revature.Daos.DaoFactory;
import com.revature.Daos.EmployeeDao;
import com.revature.Models.Employee;

public class EmployeeServiceImplementation implements EmployeeServices {
	private EmployeeDao ed;
	
	public EmployeeServiceImplementation() {
		ed = DaoFactory.getDaoFactory().getEmployeeDao();
	}
	@Override
	public String CreateEmployeeAccount(Employee e) {
		return ed.add(e).getEUserName();
	}
	@Override
	public Integer UpdateEmployeeInformation(Employee e) {
		return ed.update(e);
	}
	@Override
	public Integer RemoveEmployeeAccount(Employee e) {
		return ed.delete(e);
	}
	@Override
	public Employee GetEmployeeByUserName(String UserName) {
		return ed.GetByUserName(UserName);
	}

	@Override
	public List<Employee> GetAllEmployees() {
		return ed.GetAll();
	}

	@Override
	public List<Employee> GetEmployeeByName(String Name) {
		return ed.getByName(Name);
	}

}
