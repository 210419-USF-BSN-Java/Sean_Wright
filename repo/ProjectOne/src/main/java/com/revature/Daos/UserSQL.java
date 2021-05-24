package com.revature.Daos;

import com.revature.Utility.ConnectionAWS;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Models.Users;

public class UserSQL implements GenericDao<Users>{
	
	//Establish SQL statements for uses 
	String SQL_Add_ERS_Users = "Insert into ERS_Users values (ers_username, ers_password, ers_first_name, user_last_name, user_email, user_role_id) values (?,?,?,?,?,?) returning ers_users_id ";
	String SQL_Delete_ERS_Users = "delete from ERS_Users where ers_users_id = ?";
	String SQL_Update_ERS_Users = "Update ERS_Users set ers_username = ?, ers_password = ?, ers_first_name = ?, user_last_name = ?, user_email = ?, user_role_id = ? where ers_users_id = ?";
	String SQL_Get_By_ID = "select * from ERS_Users where ers_Users_ID = ?";
	String SQL_Get_By_User_Role_ID = "Select * from ERS_Users where User_Role_ID = ?";
	
	@Override
	public Users add(Users u) {
		Users NU = null;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Add_ERS_Users);
			ps.setString(1,u.getERS_UserName());
			ps.setString(2, u.getERS_Password());
			ps.setString(3,u.getUser_First_Name());
			ps.setString(4, u.getUser_Last_Name());
			ps.setString(5, u.getUser_Email());
			ps.setInt(6, u.getERS_User_Role_ID());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				NU = u;
				NU.setERS_User_ID(rs.getInt(1));
			}
		}catch(IOException | SQLException ex) {
			ex.printStackTrace();
		}
		return NU;
	}
	@Override
	public Integer delete(Users u) {
		int a = -1;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Delete_ERS_Users);
			ps.setInt(1, u.getERS_User_ID());
			
			a = ps.executeUpdate();
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return a;
	}

	@Override
	public Integer update(Users u) {
		int a = -1;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Update_ERS_Users);
			ps.setString(1, u.getERS_UserName());
			ps.setString(2, u.getERS_Password());
			ps.setString(3, u.getUser_First_Name());
			ps.setString(4, u.getUser_Last_Name());
			ps.setString(5, u.getUser_Email());
			ps.setInt(6, u.getERS_User_Role_ID());
			ps.setInt(7, u.getERS_User_ID());
			a = ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Users getByID(Integer ID) {
		Users User = new Users();
		
		try (Connection con = ConnectionAWS.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(SQL_Get_By_ID);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				User.setERS_User_ID(ID);
				User.setERS_Password(rs.getString("ers_password"));
				User.setERS_UserName(rs.getString("ers_username"));
				User.setUser_First_Name(rs.getString("user_first_name"));
				User.setUser_Last_Name(rs.getString("user_last_name"));
				User.setUser_Email(rs.getString("user_email"));
				User.setERS_User_Role_ID(rs.getInt("User_role_id"));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return User;
	}
	@Override
	public List<Users> getAll() {
		
		//keep this one!!  String Values = "(Reimb_AMOUNT, Reimb_SUBMITTED, Reimb_Resolved, Reimb_Description, Reimb_AUTHOR, Reimb_RESOLVER, Reimb_Status_ID,Reimb_Type_ID)";
				List<Users> User  = new ArrayList<>();
				String sql = "select * from ers_Users;";

				try {
					Connection c = ConnectionAWS.getConnectionFromFile();
					Statement s = c.createStatement();
					ResultSet rs = s.executeQuery(sql);
					
					while(rs.next()) {
						Integer ID = rs.getInt("ERS_Users_ID");
						String Username = rs.getString("ers_username");
						String Password = rs.getString("ers_password");
						String FirstName = rs.getString("ers_first_name");
						String LastName = rs.getString("user_last_name");
						String Email = rs.getString("user_email");
						Integer Role_ID = rs.getInt("User_role_id");
						User.add(new Users(ID, Username, Password, FirstName,  LastName, Email, Role_ID));
					}
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
		return User;
	}
	public Users getByUser_Role_ID(Integer ID) {
		Users User = new Users();
		
		try (Connection con = ConnectionAWS.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(SQL_Get_By_ID);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				User.setERS_User_ID(rs.getInt("ERS_Users_ID"));
				User.setERS_Password(rs.getString("ers_password"));
				User.setERS_UserName(rs.getString("ers_username"));
				User.setUser_First_Name(rs.getString("user_first_name"));
				User.setUser_Last_Name(rs.getString("user_last_name"));
				User.setUser_Email(rs.getString("user_email"));
				User.setERS_User_Role_ID(rs.getInt(ID));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return User;
	}
}
