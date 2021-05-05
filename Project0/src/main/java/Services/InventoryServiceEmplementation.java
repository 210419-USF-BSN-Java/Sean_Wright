package Services;

import java.util.List;

import com.revature.Daos.DaoFactory;
import com.revature.Daos.InventoryDao;
import com.revature.Models.Inventory;

public class InventoryServiceEmplementation  implements InventoryServices{
	private InventoryDao ind;
	
	public InventoryServiceEmplementation() {
		
		ind = DaoFactory.getDaoFactory().getInventoryDao();
	}
	@Override
	public String InsertNewInventory(Inventory i) {
		return ind.add(i).getProductName();
	}
	@Override
	public Inventory getInventoryByProductName(String ProductName) {
		return ind.GetByUserName(ProductName); // This method obtains the product by product name.  
	}
	@Override
	public List<Inventory> GetAllInventory() {
		return ind.GetAll();
	}
	@Override
	public List<Inventory> GetByProductBid(Double ProductPrice) {
		return ind.GetByProductPrice(ProductPrice);
	}
	@Override
	public Integer RemoveInventory(Inventory i) {
		return ind.delete(i);
	}
	@Override
	public Integer UpdateInventory(Inventory i) {
		return ind.update(i);
	}
	@Override
	public List<Inventory> GetByAccepted(Boolean Accepted) {
		
		return ind.GetByAccepted(Accepted);
	}
}
