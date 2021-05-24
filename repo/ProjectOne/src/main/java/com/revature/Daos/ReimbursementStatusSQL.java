package com.revature.Daos;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.Models.ERSReimbursementStatus;
import com.revature.Utility.ConnectionAWS;

public class ReimbursementStatusSQL implements GenericDao<ERSReimbursementStatus>{
	
	String SQL_Add = "Insert into ERS_Reimbursement_stauts (Reimb_Status, Reimb_status_ID) values (?,?) returning Reimb_Status_ID";
	String SQL_Delete = "Delete * from ERS_Reimbursement_status where Reimb_Status = ? ";
	String SQL_Update = "Update ERS_Reimbursement_Status set Reimb_status = ? Where Reimb_Status_ID = ?";
	String SQL_Get_By_ID = "select * from ERS_Reimburusement_Status where Reimb_Status_ID = ?";
	
	@Override
	public ERSReimbursementStatus add(ERSReimbursementStatus RS) {
		ERSReimbursementStatus reim = null;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Add);
			ps.setInt(1,RS.getReimb_Status());
			ps.setInt(2, RS.getReimb_Status_ID());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				reim = RS;
				reim.setReimb_Status_ID(rs.getInt(1));
			}
		}catch(IOException | SQLException ex) {
			ex.printStackTrace();
		}
		return reim;
	}
	@Override
	public Integer delete(ERSReimbursementStatus RS) {
		int a = -1;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Delete);
			ps.setInt(1, RS.getReimb_Status_ID());
			a = ps.executeUpdate();
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return a;
	}
	@Override
	public Integer update(ERSReimbursementStatus RS) {
		int a = -1;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Update);
			ps.setInt(1,RS.getReimb_Status());
			ps.setInt(2,RS.getReimb_Status_ID());
			
			a = ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public ERSReimbursementStatus getByID(Integer S) {
		ERSReimbursementStatus RS = new ERSReimbursementStatus();
		
		try (Connection con = ConnectionAWS.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(SQL_Get_By_ID);
			ps.setInt(1, S);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				RS.setReimb_Status_ID(S);
				RS.setReimb_Status(S);
				
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return RS;
	}
	@Override
	public List<ERSReimbursementStatus> getAll() {
		List<ERSReimbursementStatus> RS  = new ArrayList<>();
		String sql = "select * from ERS_Reimbursement_Status;";

		try {
			Connection c = ConnectionAWS.getConnectionFromFile();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Integer ID = rs.getInt("Reimb_Status_ID");
				Integer Type = rs.getInt("Reimb_Status");
				
				RS.add(new ERSReimbursementStatus(ID, Type));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return RS;
	}
	
	
}
