package com.revature.Daos;

	
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import com.revature.Models.ERS_User_Roles;
	import com.revature.Utility.ConnectionAWS;

	public class UserRolesSQL implements GenericDao<ERS_User_Roles>{
		
		String SQL_Add = "Insert into ERS_User_roles (ERS_User_Role_ID, User_Role) values (Default,?) returning Reimb_Status_ID";
		String SQL_Delete = "Delete * from ERS_Reimbursement_status where User_Role_ID = ? ";
		String SQL_Update = "Update ERS_User_Roles set User_Role = ? Where ERS_User_Role_ID = ?";
		String SQL_Get_By_ID = "select * from ERS_User_Roles where ERS_User_Role_ID = ?";
		
		@Override
		public ERS_User_Roles add(ERS_User_Roles ERS) {
			ERS_User_Roles reim = null;
			try(Connection con = ConnectionAWS.getConnectionFromFile()){
				PreparedStatement ps = con.prepareStatement(SQL_Add);
				ps.setString(1,ERS.getUser_Role());
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					reim = ERS;
					reim.setUser_Role_ID(rs.getInt(1));
				}
			}catch(IOException | SQLException ex) {
				ex.printStackTrace();
			}
			return reim;
		}
		public Integer delete(ERS_User_Roles ERS) {
			int a = -1;
			try(Connection con = ConnectionAWS.getConnectionFromFile()){
				PreparedStatement ps = con.prepareStatement(SQL_Delete);
				ps.setInt(1, ERS.getUser_Role_ID());
				a = ps.executeUpdate();
			} catch (SQLException | IOException ex) {
				ex.printStackTrace();
			}
			return a;
		}
		@Override
		public Integer update(ERS_User_Roles ERS) {
			int a = -1;
			try(Connection con = ConnectionAWS.getConnectionFromFile()){
				PreparedStatement ps = con.prepareStatement(SQL_Update);
				ps.setString(1,ERS.getUser_Role());
				ps.setInt(2,ERS.getUser_Role_ID());
				
				a = ps.executeUpdate();
				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return a;
		}
		@Override
		public ERS_User_Roles getByID(Integer UR) {
			ERS_User_Roles ERS = new ERS_User_Roles();
			
			try (Connection con = ConnectionAWS.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(SQL_Get_By_ID);
				ps.setInt(1, UR);
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					ERS.setUser_Role_ID(rs.getInt("ERS_User_Role_ID"));
					ERS.setUser_Role(rs.getString("User_Role"));
					
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return ERS;
		}
		@Override
		public List<ERS_User_Roles> getAll() {
			List<ERS_User_Roles> RS  = new ArrayList<>();
			String sql = "select * from ERS_User_Roles;";

			try {
				Connection c = ConnectionAWS.getConnectionFromFile();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while(rs.next()) {
					Integer ID = rs.getInt("ERS_User_Role_ID");
					String Type = rs.getString("User_Role");
					
					RS.add(new ERS_User_Roles(Type, ID));
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return RS;
		}
		

}
