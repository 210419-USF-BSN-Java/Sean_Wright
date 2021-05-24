package Controller;
	
	import java.io.IOException;
	import java.time.LocalDateTime;
	import java.util.List;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
	import java.sql.Timestamp;
	import javax.servlet.ServletException;
	import javax.servlet.http.Cookie;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;
	import java.util.Random;

	import com.revature.Daos.*;
	import com.revature.Models.Reimbursement;
	import com.revature.Models.Users;
	import com.revature.Services.*;
	
	public class EmployeeViewDelegate{
		private ObjectMapper om = new ObjectMapper();
		
		private ReimbursementServices RS;
		private UserSQL UL;
		
		//Predefine functions for parsing numbers 
		public Integer ParseInteger(String Input) {
			Integer num;
			try {
				num = Integer.parseInt(Input);
			}catch(NumberFormatException e){
				num = 0;
			}
			return num;
		}
		
		public Double ParseDouble(String input) {
			Double num;
			try {
				num = Double.parseDouble(input);
			}catch(NumberFormatException e){
				num = 0.0;
			}
			return num;
		}

			public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				//DAOs and Services
				//defined from the private variables above
				UserSQL U = new UserSQL();
				
				//PrintWriter pw = response.getWriter();
				
				String path = (String) request.getAttribute("path");
				long Time;
				
				om.registerModule(new JavaTimeModule());
				
				//Get the user id from the session
				HttpSession session = request.getSession();
				Integer Author_ID = ParseInteger((String)(session.getAttribute("id")));
				
				System.out.println(request.getMethod());
				switch(request.getMethod()) {
				case "GET":
					
					switch(path) {
					case "ViewInformation":
						
						Users employeeview = U.getByID(Author_ID);
						response.getWriter().write(om.writeValueAsString(employeeview));
					
						break;
					case "ViewPending":	
						List<Reimbursement> pendingRequests = RS.getAuthorRequestResolved(Author_ID);
						response.getWriter().write(om.writeValueAsString(pendingRequests));
						break;
						
					case "ViewResolvedRequests":
						List<Reimbursement> resolvedRequsts = RS.getAuthorRequestResolved(Author_ID);
						response.getWriter().write(om.writeValueAsString(resolvedRequsts));
						
						break;
					default:
						break;
					}
					break;
				case "POST":
					
					switch(path) { 
					case "AddReimbursement":
						Random rand = new Random();
						int upperbound = 30000;
						Integer intRandom1 = rand.nextInt(upperbound);
						Integer intRandom2 = rand.nextInt(upperbound);
						Integer intRandom3 = rand.nextInt(upperbound);
						Integer intRandom4 = rand.nextInt(upperbound);
						//Retrieve the data from within the request if user submits request.
						
						String ReimbursementCause = request.getParameter("type");
						Integer reimbType = ParseInteger(ReimbursementCause);
						String Compensation = request.getParameter("amount");
						Double AmountReimbursed = ParseDouble(Compensation);
						String Description = request.getParameter("desc"); //if any
						LocalDateTime RequestedTime = LocalDateTime.now(); //Usee 
						Integer Resolver = 0;
						Reimbursement reimb = new Reimbursement(intRandom1, AmountReimbursed, RequestedTime,null,Description, intRandom2, Resolver, intRandom3, intRandom4);
						
						if(reimb != null) {
							//ReimbursementSQL.add(reimb);
						}
						
						response.sendRedirect("/static/employee.html");
						
						break;
					case "updateInformation":
						Users user = UL.getByID(Author_ID);
						String fName = request.getParameter("firstName");
						String lName = request.getParameter("lastName");
						String password = request.getParameter("password");
						String emailString = request.getParameter("email");
						
						System.out.println(fName + lName);
						System.out.println("In method");
						response.sendRedirect("/static/Employee.html");
						break; 
					}
				case "PUT":
					switch(path) {
					case "Logoff":
						session.invalidate();
						break;
					
					
					
					}
			}
				
		}
	
	

}
