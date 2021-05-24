package com.revature.Daos;

import java.io.IOException;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.revature.Models.Reimbursement;
import com.revature.Utility.ConnectionAWS;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ReimbursementSQL implements ReimbersementDao{
	
	//SQL Statements
	String Values = "(Reimb_AMOUNT, Reimb_SUBMITTED, Reimb_RESOLVED, Reimb_Description,Reimb_AUTHOR,Reimb_RESOLVER, Reimb_Status_ID,Reimb_Type_ID)";
	String SQL_Delete = "Delete from ERS_Reimbursement where Reimb_ID = ?";
	String Update = "Update ERS_Reimbursement set Reimb_AMOUNT = ?, Reimb_SUBMITTED = ?, Reimb_RESOLVED = ?, Reimb_Description = ?, Reimb_RECEIPT = ?,Reimb_AUTHOR = ?,Reimb_RESOLVER = ?, Reimb_Status_ID = ?,Reimb_Type_ID = ? where Reimb_ID = ?)";
	String Get_By_ID = "Select * From ERS_Reimbursement where Reimb_ID = ?";
	
	
	@Override
	public Reimbursement add(Reimbursement R) {
		String SQL_Add = "Insert into ERS_REIMBURSEMENT (Reimb_ID, Reimb_AMOUNT, Reimb_SUBMITTED, Reimb_RESOLVED, Reimb_Description,Reimb_AUTHOR,Reimb_RESOLVER, Reimb_Status_ID,Reimb_Type_ID) Values (?,?,?,?,?,?,?,?,?) returning Reimb_ID ";
		Reimbursement reim = null;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Add);
			if(R.getRMB_ID() == 0) {
				
			}
			ps.setDouble(1, R.getRMB_ID());
			ps.setDouble(2,R.getRMB_AMNT());
			ps.setObject(3, LocalDateTime.class);
			ps.setObject(4, null);
			ps.setString(5,R.getDescription());
			ps.setInt(6, R.getAuthor_ID());
			ps.setInt(7, (Integer) null);
			ps.setInt(8, R.getRMB_Status_ID());
			ps.setInt(9, R.getRMB_Type_ID());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				reim = R;
				reim.setRMB_ID(rs.getInt(1));
			}
		}catch(IOException | SQLException ex) {
			ex.printStackTrace();
		}
		return reim;
	}

	@Override
	public Integer delete(Reimbursement R) {
		int a = -1;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(SQL_Delete);
			ps.setInt(1, R.getRMB_ID());
			
			a = ps.executeUpdate();
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
		}
		return a;
	}

	@Override
	public Integer update(Reimbursement R) {
		int a = -1;
		try(Connection con = ConnectionAWS.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(Update);
			ps.setDouble(1,R.getRMB_AMNT());
			ps.setObject(2,LocalDateTime.class);
			ps.setObject(3,LocalDateTime.class);
			ps.setString(3,R.getDescription());
			ps.setInt(4, R.getAuthor_ID());
			ps.setInt(5, R.getResolver_ID());
			ps.setInt(6, R.getRMB_Status_ID());
			ps.setInt(7, R.getRMB_Type_ID());
			ps.setInt(9, R.getRMB_ID());
			a = ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Reimbursement getByID(Integer Reimb_ID) {
		Reimbursement Reimb = new Reimbursement();
		
		try (Connection con = ConnectionAWS.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(Values);
			ps.setInt(1, Reimb_ID);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Reimb.setRMB_ID(rs.getInt(1));
				Reimb.setRMB_AMNT(rs.getDouble(2));
				Reimb.setSubmitted(rs.getObject(3, LocalDateTime.class));
				Reimb.setResolved(rs.getObject(4, LocalDateTime.class));
				Reimb.setDescription(rs.getString("Reimb_Description"));
				Reimb.setAuthor_ID(rs.getInt("Reimb_Author"));
				Reimb.setResolver_ID(rs.getInt("Reimb_RESOLVER"));
				Reimb.setRMB_Status_ID(rs.getInt("Reimb_Status_ID"));
				Reimb.setRMB_Type_ID(rs.getInt("Reimb_Type_ID"));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return Reimb;
	}

	@Override
	public List<Reimbursement> getAuthorRequestPending(Integer Author_ID) {
		
		return null;
	}

	@Override
	public List<Reimbursement> getAuthorRequestResolved(Integer Author_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllPending(Integer Resolver_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllResolved(Integer Resolver_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllByAuthor(Integer Author_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAll() {
		//keep this one!!  String Values = "(Reimb_AMOUNT, Reimb_SUBMITTED, Reimb_Resolved, Reimb_Description, Reimb_AUTHOR, Reimb_RESOLVER, Reimb_Status_ID,Reimb_Type_ID)";
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "select * from ers_reimbursement;";

		try {
			Connection c = ConnectionAWS.getConnectionFromFile();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Integer reimbId = rs.getInt("reimb_ID");
				Double reimbAmnt = rs.getDouble("Reimb_Amount");
				Object reimbSubm = rs.getObject(3, LocalDateTime.class);
				Object reimbRes = rs.getObject(4, LocalDateTime.class);
				String reimbDesc = rs.getString("Reimb_Description");
				Integer reimbAuth = rs.getInt("Reimb_Author");
				Integer reimbResol = rs.getInt("Reimb_Resolver");
				Integer reimbSID = rs.getInt("Reimb_status_ID");
				Integer reimbTID = rs.getInt("Reimb_Type_ID");
				LocalDateTime now = LocalDateTime.now();
				reimbursements.add(new Reimbursement(reimbId, reimbAmnt, now,null,reimbDesc,reimbAuth,reimbResol,reimbSID,reimbTID));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	

}
