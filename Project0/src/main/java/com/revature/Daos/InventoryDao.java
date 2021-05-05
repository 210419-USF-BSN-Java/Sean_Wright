package com.revature.Daos;

import java.util.List;

import com.revature.Models.Inventory;



public interface InventoryDao extends CompanyDao<Inventory> {
	
	public List<Inventory> GetByProductPrice(Double productPrice);
	public List<Inventory> GetByAccepted(Boolean Accepted);	
	
}
