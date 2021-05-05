package com.revature.Daos;

//insert exception class here for iO exception if code doesnt run.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Models.Customer;
import com.revature.utility.ConnectDB;




public class CustomerSQL implements CustomerDao{

	
	@Override
	public Customer add(Customer c) {
		
		String sql = "insert into Clients (Cust_usrnme, Cust_psword, Cust_name) values (?,?,?) returning Cust_usrnme"; 
		//If errors try reverting to (?,?) method.
		Customer client = null;
		
		try {
			Connection con = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,c.GetCustomerName());
			ps.setString(2,c.GetCustomerPassword());
			ps.setString(3,c.GetCustomerUserName());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				client = c;
				client.SetCustomerName(rs.getString(1));
				//con.commit();
			}
			else {
				//con.rollback();
			}
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
		return client;
	}
	@Override
	public List<Customer> GetAll() {
		
		List<Customer> clients = new ArrayList<>();
		String sql = "select * from Clients;";

		try {
			Connection c = ConnectDB.getHardCodedConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String customerUserName = rs.getString("Cust_usrnme");
				String customerPassword = rs.getString("Cust_psword");
				String customerName = rs.getString("Cust_name");
				clients.add(new Customer(customerUserName, customerPassword,customerName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}
	@Override
	public Integer update(Customer c) {
		String sql = "update Clients set Cust_usrnme = ?, Cust_psword = ?, Cust_name = ? where Cust_usrnme = ?";
		int a = -1;
		//if errors occur revert to two column method as illustrated above.
		try(Connection con = ConnectDB.getHardCodedConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.GetCustomerUserName());
			ps.setString(2, c.GetCustomerPassword());
			ps.setString(3, c.GetCustomerName());
			
			a = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public Integer delete(Customer c) {
		String sql = "delete from Clients where Cust_usrnme = ?";
		int a = -1;
		
		try(Connection con = ConnectDB.getHardCodedConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.GetCustomerUserName());
			
			a = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Customer> getByName(String Name) {
		String sql = "SELECT * FROM Clients where Cust_name = ?";
		List<Customer> clients = new ArrayList<>();
		
		try {
			PreparedStatement ps = ConnectDB.getHardCodedConnection().prepareStatement(sql);
			ps.setString(1, Name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				clients.add(new Customer(rs.getString("Cust_usrnme"), rs.getString("Cust_psword"), rs.getString("Cust_name")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}
	@Override
	public Customer GetByUserName(String UserName) {
		String sql = "Select * from Clients where Cust_usrnme = ?";
		Customer client = new Customer();
		
		try 
		{
			Connection con = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,UserName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				client.SetCustomerUserName(UserName);
				client.SetCustomerPassword(rs.getString("Cust_psword"));
				client.SetCustomerName(rs.getString("Cust_name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
}
