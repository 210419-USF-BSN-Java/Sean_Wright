package com.revature.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Models.Inventory;
import com.revature.Models.Offers;
import com.revature.utility.ConnectDB;

public class InventorySQL implements InventoryDao{
	
	@Override
	public Inventory add(Inventory i){
		
		String sql = "insert into Inventory (Prd_Name, Prd_Bid, Offer_made, Offer_accept, Own_usrnme) values (?,?,?,?,?) returning Prd_Name"; 
		//If errors try reverting to (?,?) method.
		Inventory capital = null;
		
		try {
			Connection con = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,i.getProductName());
			ps.setDouble(2,i.getProductPrice());
			ps.setBoolean(3,i.getOfferMade());
			ps.setBoolean(4,i.getOfferAccepted());
			ps.setString(5,i.getOwner_id());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				capital = i;
				capital.setProductName(rs.getString(1));
				//con.commit();
			}
			else {
				//con.rollback();
			}
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
		return capital;
	}
	@Override
	public List<Inventory> GetAll() {
		
		List<Inventory> capital = new ArrayList<>();
		String sql = "select * from Inventory;";

		try {
			Connection c = ConnectDB.getHardCodedConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String ProductName = rs.getString("Prd_Name");
				Double ProductBid = rs.getDouble("Prd_Bid");
				Boolean OfferMade = rs.getBoolean("Offer_made");
				Boolean OfferAccepted = rs.getBoolean("Offer_accept");
				String OwnerUserName = rs.getString("Own_usrnme");
				capital.add(new Inventory(ProductName,ProductBid ,OfferMade,OfferAccepted,OwnerUserName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return capital;
	}
	@Override
	public Integer update(Inventory i) {
		String sql = "update Inventory set Prd_Name = ?, Prd_Bid = ?, Offer_made = ?, Offer_accept = ?, Own_usrnme = ? where Prd_Name = ?";
		int a = -1;
		//if errors occur revert to three column method as illustrated in project notes.
		try(Connection con = ConnectDB.getHardCodedConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, i.getProductName());
			ps.setDouble(2, i.getProductPrice());
			ps.setBoolean(3, i.getOfferMade());
			ps.setBoolean(4, i.getOfferAccepted());
			ps.setString(5, i.getOwner_id());
			
			a = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public Integer delete(Inventory i) {
		String sql = "delete from Inventory where Prd_Name = ?";
		int a = -1;
		
		try(Connection con = ConnectDB.getHardCodedConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, i.getProductName());
			
			a = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public Inventory GetByUserName(String ProductName) {// This method is for product name.
		String sql = "Select * from inventory where Prd_Name = ?";
		Inventory capital = new Inventory();
		
		try 
		{
			Connection con = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,ProductName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				capital.setProductName(rs.getString("Prd_Name"));
				capital.setProductPrice(rs.getDouble("Prd_Bid"));
				capital.setOfferMade(rs.getBoolean("Offer_made"));
				capital.setOfferAccepted(rs.getBoolean("Offer_accept"));
				capital.setOwner_id(rs.getString("Own_usrnme"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return capital;
	}
	@Override
	public List<Inventory> GetByProductPrice(Double productPrice) {
		String sql = "Select * from Inventory where Prd_Bid = ?";
		List<Inventory> capital = new ArrayList<>();
		
		try
		{
			Connection con = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1,productPrice);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//capital.setProductName(rs.getString("Prd_Name"));
				//capital.setProductPrice(rs.getDouble("Prd_Bid"));
				//capital.setOfferMade(rs.getBoolean("Offer_made"));
				//capital.setOfferAccepted(rs.getBoolean("Offer_accept"));
				//capital.setOwner_id(rs.getString("Own_usrnme"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Inventory> GetByAccepted(Boolean Accepted) {
		String sql = "Select * from inventory where Offer_accept = ?";
		List<Inventory> capital = new ArrayList<>();
		
		try {
			Connection c = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setBoolean(1, false);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String ProductName = rs.getString("Prd_Name");
				Double ProductBid = rs.getDouble("Prd_Bid");
				Boolean OfferMade = rs.getBoolean("Offer_made");
				Boolean OfferAccepted = rs.getBoolean("Offer_accept");
				String Owner = rs.getString("Own_usrnme");
				capital.add(new Inventory(ProductName,ProductBid,OfferMade,OfferAccepted,Owner));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return capital;
	}
}
