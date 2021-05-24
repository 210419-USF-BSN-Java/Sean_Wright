package com.revature.Services;


import java.util.ArrayList;
import java.util.List;

import com.revature.Daos.ReimbursementSQL;
import com.revature.Daos.ReimbursementStatusSQL;
import com.revature.Models.ERSReimbursementStatus;
import com.revature.Models.Reimbursement;

public class ReimbursementServices {
	
	ReimbursementStatusSQL RSS = new ReimbursementStatusSQL();
	ReimbursementSQL RS = new ReimbursementSQL();
	
	
	//Employee Function
	public List<Reimbursement> getAuthorRequestPending(Integer Author_ID) {
		
		List<Reimbursement> ReimbursementPending = new ArrayList<>();
				
				for(ERSReimbursementStatus R : RSS.getAll()) {
					
					if(R.Reimb_Status == 0) {
						Integer ID = R.Reimb_Status_ID;
						
						for (Reimbursement RE : RS.getAll()) {
							
							if(RE.getRMB_Status_ID() == ID && RE.getAuthor_ID() == Author_ID) {
								ReimbursementPending.add(RE);
							}
						}
					}
				}
		
		return ReimbursementPending;
	}
	
	//Employee Function 
	public List<Reimbursement> getAuthorRequestResolved(Integer Author_ID) { 
		
		List<Reimbursement> ReimbursementResolved = new ArrayList<>();
		
		for(ERSReimbursementStatus R : RSS.getAll()) {
			
			if(R.Reimb_Status > 0) {
				Integer ID = R.Reimb_Status_ID;
				
				for (Reimbursement RE : RS.getAll()) {
					
					if(RE.getRMB_Status_ID() == ID && RE.getAuthor_ID() == Author_ID) {
						ReimbursementResolved.add(RE);
					}
				}
			}
		}		
		return ReimbursementResolved;
	}
	
	//Employee Function
	public Reimbursement makeRequest(Reimbursement R) {
		return RS.add(R);
	}
	
	//Manager Function
	public List<Reimbursement> getAllPending() { // Passed
		
		List<Reimbursement> ReimbursementPending = new ArrayList<>();
		
		for(ERSReimbursementStatus R : RSS.getAll()) {
			
			if(R.Reimb_Status == 0) {
				Integer ID = R.Reimb_Status_ID;
				
				for (Reimbursement RE : RS.getAll()) {
					
					if(RE.getRMB_Status_ID() == ID) {
						ReimbursementPending.add(RE);
					}
				}
			}
		}		
		return ReimbursementPending;
	}
	
	public List<Reimbursement> getAllResolved() {
		
		List<Reimbursement> ReimbursementResolved = new ArrayList<>();
		
		for(ERSReimbursementStatus R : RSS.getAll()) {
			
			if(R.Reimb_Status > 0) {
				Integer ID = R.Reimb_Status_ID;
				
				for (Reimbursement RE : RS.getAll()) {
					
					if(RE.getRMB_Status_ID() == ID) {
						ReimbursementResolved.add(RE);
					}
				}
			}
		}		
		return ReimbursementResolved;
	}
	public List<Reimbursement> getAllByAuthor(Integer Author_ID) {  //Passed
		
		List<Reimbursement> ReimbursementByAuthor = new ArrayList<>();
		
		for(Reimbursement R : RS.getAll()) {
			
			if(R.getAuthor_ID() == Author_ID) {
					ReimbursementByAuthor.add(R);
					}
				}
			return ReimbursementByAuthor;
	}
}
