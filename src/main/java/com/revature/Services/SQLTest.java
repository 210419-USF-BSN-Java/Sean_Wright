package com.revature.Services;
import com.revature.Daos.*;


import java.sql.Timestamp;
import java.util.List;
import com.revature.Models.Reimbursement;
import java.util.Date;

import com.revature.Services.*;


public class SQLTest {

	public static void main(String[] args) {
		
		
		Timestamp ts = new Timestamp(12);  //////Test Passed !!(ReimbursementSQL.add()
		Double reimb_id;
		//ReimbursementSQL nsql = new ReimbursementSQL();
		//Reimbursement stuff = nsql.add(new Reimbursement(1355, 14.26,ts,ts, "For the food i bought",2, 1, 12680, 679547));
		//System.out.print(stuff);
		//for(Reimbursement n: stuff) {
			
			//if(n.getRMB_ID() == 2) {
				//System.out.print(n);
			//}
		
		ReimbursementServices RS = new ReimbursementServices();
		System.out.println("STuff");
		
		//RS.getAuthorRequestPending(89,086)
		//List<Reimbursement> reim = RS.getAllPending(); /////Test Passed !!
		//System.out.print(reim);
		
		//List<Reimbursement> rs = RS.getAllByAuthor(1); //////Test Passed !!!
		//System.out.print(rs);
		
		//ReimbursementServices Ry = new ReimbursementServices();
		
		LoginService LS = new LoginService();
		
		String Position = LS.PositionValidation("Emp1", "dog123");
		
		System.out.println(Position);
		
		String login = LS.Validation("Man1", "cat346");
		System.out.println(login);
		//List<Reimbursement> reimb = RS.getAuthorRequestPending(2);
		//System.out.print(reimb);
		
		
			}
}

		

