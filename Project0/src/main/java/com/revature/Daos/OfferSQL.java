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

public class OfferSQL  implements OffersDao{
	
	@Override
	public Offers add(Offers o){
		
		String sql = "insert into offers (Cust_ID, Amnt, prd_NM, Serial_num, Accepted) values (?,?,?,?,?) returning Cust_ID"; 
		//If errors try reverting to (?,?) method.
		Offers off = null;
		
		try {
			Connection con = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,o.getCustID());
			ps.setDouble(2,o.getAmount());
			ps.setString(3,o.getProductName());
			ps.setDouble(4,o.getSerialNumber());
			ps.setBoolean(5,o.getAccepted());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				off = o;
				off.setCustID(rs.getString(1));
				//con.commit();
			}
			else {
				//con.rollback();
			}
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
		return off;
	}
	@Override
	public List<Offers> GetAll() {
		
		List<Offers> off = new ArrayList<>();
		String sql = "select * from offers;";

		try {
			Connection c = ConnectDB.getHardCodedConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String CustID = rs.getString("Cust_ID");
				Double ProductBid = rs.getDouble("Amnt");
				String ProductName = rs.getString("prd_NM");
				Double SerialNumber = rs.getDouble("Serial_num");
				Boolean Accepted = rs.getBoolean("Accepted");
				off.add(new Offers(CustID,ProductBid,ProductName,SerialNumber,Accepted));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return off;
	}
	@Override
	public Integer update(Offers o) {
		String sql = "update offers set Cust_ID = ?, Amnt = ?, prd_NM = ?, Serial_num = ?, Accepted = ? where Serial_num = ?";
		int a = -1;
		//if errors occur revert to three column method as illustrated in project notes.
		try(Connection con = ConnectDB.getHardCodedConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,o.getCustID());
			ps.setDouble(2,o.getAmount());
			ps.setString(3,o.getProductName());
			ps.setDouble(4,o.getSerialNumber());
			ps.setBoolean(5,o.getAccepted());
			ps.setDouble(6,o.getSerialNumber());
			
			a = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public Integer delete(Offers o) {
		String sql = "delete from offers where Serial_num = ?";
		int a = -1;
		
		try(Connection con = ConnectDB.getHardCodedConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, o.getSerialNumber());
			
			a = ps.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public Offers GetByUserName(String CustomerID) {// This method is for pending offers.
		String sql = "Select * from offers where Cust_ID = ?";
		Offers off = new Offers();
		
		try 
		{
			Connection con = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,CustomerID);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				off.setCustID(rs.getString("Cust_ID"));
				off.setAmount(rs.getDouble("Amnt"));
				off.setProductName(rs.getString("prd_NM"));
				off.setSerialNumber(rs.getDouble("Serial_num"));
				off.setAccepted(rs.getBoolean("Accepted"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return off;
	}
	@Override
	public List<Offers> GetByOfferAccepted(Boolean isAccepted) {
		String sql = "Select * from offers where Accepted = ?";
		List<Offers> off = new ArrayList<Offers>();

		try {
			//Connection c = ConnectDB.getHardCodedConnection();
			//Statement s = c.createStatement();
			//ResultSet rs = s.executeQuery(sql);
			Connection c = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setBoolean(1, isAccepted);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				String CustID = rs.getString("Cust_ID");
				Double ProductBid = rs.getDouble("Amnt");
				String ProductName = rs.getString("prd_NM");
				Double SerialNumber = rs.getDouble("Serial_num");
				Boolean Accepted = rs.getBoolean("Accepted");
				off.add(new Offers(CustID,ProductBid,ProductName,SerialNumber,Accepted));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return off;
		
	}
	@Override
	public List<Offers> GetByCustomer(String UserName) {
		String sql = "Select * from offers where Cust_ID = ?";
		List<Offers> off = new ArrayList<>();
		
		try {
			Connection c = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, UserName);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String CustID = rs.getString("Cust_ID");
				Double ProductBid = rs.getDouble("Amnt");
				String ProductName = rs.getString("prd_NM");
				Double SerialNumber = rs.getDouble("Serial_num");
				Boolean Accepted = rs.getBoolean("Accepted");
				off.add(new Offers(CustID,ProductBid,ProductName,SerialNumber,Accepted));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return off;
	}
	@Override
	public Offers GetBySerialNumber(Double SerialNumber) {
		String sql = "Select * from offers where Serial_num = ?";
		Offers off = new Offers();
		
		try 
		{
			Connection con = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1,SerialNumber);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				off.setCustID(rs.getString("Cust_ID"));
				off.setAmount(rs.getDouble("Amnt"));
				off.setProductName(rs.getString("prd_NM"));
				off.setSerialNumber(rs.getDouble("Serial_num"));
				off.setAccepted(rs.getBoolean("Accepted"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return off;
	}
	@Override
	public Integer RemoveUnacceptedOffers(Offers o) {// Deletes an entry under two conditions.
		String sql = "delete from offers where prd_NM = ? And Accepted = ?";
		int a = -1;
		
		try(Connection con = ConnectDB.getHardCodedConnection())
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, o.getProductName());
			ps.setBoolean(2, o.getAccepted());
			a = ps.executeUpdate();
		} 
		catch (SQLException e){
			e.printStackTrace();
		}
		return a;
	}
}
