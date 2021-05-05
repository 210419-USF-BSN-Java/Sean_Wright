package Services;

import java.util.List;

import com.revature.Models.Inventory;

public interface InventoryServices {
	
	public String InsertNewInventory(Inventory i);
	public Inventory getInventoryByProductName(String Name);
	public Integer RemoveInventory(Inventory i);
	public Integer UpdateInventory(Inventory i);
	public List<Inventory> GetByProductBid(Double ProductPrice);
	public List<Inventory> GetByAccepted(Boolean Accepted);
	public List<Inventory> GetAllInventory();
}
