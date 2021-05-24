package com.revature.Daos;

import com.revature.Models.Reimbursement;
import java.util.List;

public interface ReimbersementDao extends GenericDao<Reimbursement> {
	
	public List<Reimbursement> getAuthorRequestPending(Integer Author_ID);
	public List<Reimbursement> getAuthorRequestResolved(Integer Author_ID);
	public List<Reimbursement> getAllPending(Integer Resolver_ID);
	public List<Reimbursement> getAllResolved(Integer Resolver_ID);
	public List<Reimbursement> getAllByAuthor(Integer Author_ID);

}
