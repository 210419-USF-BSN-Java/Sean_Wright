package com.revature.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Models.Employee;
import com.revature.utility.ConnectDB;

public class EmployeeSQL implements EmployeeDao{
	
	@Override
	public Employee add(Employee e){ //works
		
		String sql = "insert into staff (Emp_name, Emp_usrnme, Emp_psword, Emp_rank) values (?,?,?,?) returning Emp_name"; 
		//If errors try reverting to (?,?) method.
		Employee staff = null;
		
		try {
			Connection con = ConnectDB.getHardCodedConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,e.getEmployeeName());
			ps.setString(2,e.getEUserName());
			ps.setString(3,e.getEPassword());
			ps.setInt(4,e.getRank());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				staff = e;
				staff.setEmployeeName(rs.getString(1));
				//con.commit();
			}
			else {
				//con.rollback();
			}
		}
		catch (SQLException E) {
				E.printStackTrace();
		}
		return staff;
	}
	@Override
	public List<Employee> GetAll() { //works but need to find a way to list
		
		List<Employee> staff = new ArrayList<>();
		String sql = "select * from Staff;";

		try {
			Connection c = ConnectDB.getHardCodedConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String EmployeeName = rs.getString("Emp_name");
				String EmployeeUserName = rs.getString("Emp_usrnme");
				String EmployeePassword = rs.getString("Emp_psword");
				Integer EmployeeRank = rs.getInt("Emp_rank");
				staff.add(new Employee(EmployeeName, EmployeeUserName,EmployeePassword,EmployeeRank));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;
	}
	@Override
	public Integer update(Employee e) {// updates by employee username 
		String sql = "update Staff set Emp_name = ?, Emp_psword = ?, Emp_rank = ? where Emp_usrnme = ?";
		int a = -1;
		//if errors occur revert to three column method as illustrated in project notes.
		try(Connection con = ConnectDB.getHardCodedConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getEmployeeName());
			ps.setString(2, e.getEPassword());
			ps.setInt(3, e.getRank());
			ps.setString(4,e.getEUserName());
			
			a = ps.executeUpdate();
		} catch (SQLException E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
		return a;
	}
	@Override
	public Integer delete(Employee e) {
		String sql = "delete from Staff where Emp_usrnme = ?";
		int a = -1;
		
		try(Connection con = ConnectDB.getHardCodedConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getEUserName());
			
			a = ps.executeUpdate();
		} catch (SQLException E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Employee> getByName(String Name) {
		String sql = "SELECT * FROM Staff where Emp_name = ?";
		List<Employee> staff = new ArrayList<>();
		
		try {
			PreparedStatement ps = ConnectDB.getHardCodedConnection().prepareStatement(sql);
			ps.setString(1, Name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				staff.add(new Employee(rs.getString("Emp_name"), rs.getString("Emp_usrnme"), rs.getString("Emp_psword"), rs.getInt("Emp_rank")));
			}
		} catch (SQLException E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
		return staff;
	}
	@Override
	public Employee GetByUserName(String UserName) {
		String sql = "Select * from Staff where Emp_usrnme = ?";
		Employee staff = new Employee();
		
		try(Connection con = ConnectDB.getHardCodedConnection()) 
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,UserName);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				staff.setEmployeeName(rs.getString("Emp_name"));
				staff.setEUserName(UserName);
				staff.setEPassword(rs.getString("Emp_psword"));
				staff.setRank(rs.getInt("Emp_rank"));
			}
		}
		catch (SQLException E) {
			E.printStackTrace();
		}
		return staff;
	}
}
