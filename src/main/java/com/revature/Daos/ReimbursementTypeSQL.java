package com.revature.Daos;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Models.ESRReimbursementType;
import com.revature.Utility.ConnectionAWS;

public class ReimbursementTypeSQL implements GenericDao<ESRReimbursementType>{

	String SQL_Add = "Insert into ERS_Reimbursement_Type (Reimb_Type, Reimb_Type_ID) values (?,?) returning Reimb_Type_ID";
	String SQL_Get_By_ID = "select * from ERS_Reimburusement_Type where Reimb_Status_ID = ?";
	String SQL_Delete = "Delete * from ERS_Reimbursement_Type where Reimb_Type = ? ";
	String SQL_Update = "Update ERS_Users set Reimb_Type = ? where Reimb_Type_id = ?";
	
	@Override
	public ESRReimbursementType add(ESRReimbursementType RT) {
		ESRReimbursementType reim = null;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Add);
			ps.setString(1,RT.getReimb_Type());
			ps.setInt(2, RT.getReimb_Type_ID());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				reim = RT;
				reim.setReimb_Type_ID(rs.getInt(1));
			}
		}catch(IOException | SQLException ex) {
			ex.printStackTrace();
		}
		return reim;
	}

	@Override
	public Integer delete(ESRReimbursementType RT) {
		int a = -1;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Delete);
			ps.setInt(1, RT.getReimb_Type_ID());
			a = ps.executeUpdate();
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return a;
	}

	@Override
	public Integer update(ESRReimbursementType RT) {
		
		int a = -1;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Update);
			ps.setString(1,RT.getReimb_Type());
			ps.setInt(2,RT.getReimb_Type_ID());
			
			a = ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public ESRReimbursementType getByID(Integer ID) {
		ESRReimbursementType RS = new ESRReimbursementType();
		
		try (Connection con = ConnectionAWS.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(SQL_Get_By_ID);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				RS.setReimb_Type_ID(rs.getInt("Reimb_Type_ID"));
				RS.setReimb_Type(rs.getString("Reimb_Type"));
				
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return RS;
	}

	@Override
	public List<ESRReimbursementType> getAll() {
		List<ESRReimbursementType> RT  = new ArrayList<>();
		String sql = "select * from ers_Users;";

		try {
			Connection c = ConnectionAWS.getConnectionFromFile();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Integer ID = rs.getInt("Reimb_Type_ID");
				String Type = rs.getString("Reimb_Type");
				
				RT.add(new ESRReimbursementType(ID, Type));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return RT;
	}
}
