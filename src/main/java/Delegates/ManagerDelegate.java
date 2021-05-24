package Delegates;

import java.io.IOException;

import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import Controller.RequestDirector;
import com.revature.Daos.*;
import com.revature.Services.*;
import com.revature.Models.*;

public class ManagerDelegate {
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//importing from RimbursementServices
		ReimbursementServices RS = new ReimbursementServices();
		UserSQL US = new UserSQL();
		
		//switch case for all managerial funcitons dependent upon method.
		String action = (String) request.getAttribute("path");
		
		switch(request.getMethod()) {
			case "Get":
				switch(action) {
					case"ViewAllEmployees":
					List<Users> emp = US.getAll();
						break;
					case "ViewAllPendingRequests":
					List<Reimbursement> reimPen = RS.getAllPending();
						break;
					case"ViewResolvedRequests":
					List<Reimbursement> reimRes = RS.getAllResolved();
						break;
					default:
						break;
				}
		case "Post":
			switch(action) {
				
				case "GetEmployeeReimbursementByID":
					List<Reimbursement> reimAll = RS.getAllByAuthor(1);
					break;
				case "DeclineAccept":
					break;
				default:
					break;
			}
		}
	}
}
