package Controller;


import com.revature.Services.LoginService;


import Delegates.ViewDelegate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserControlls {
	
	
	private static ViewDelegate VD = new ViewDelegate();
	private LoginService LS = new LoginService();
	
	UserControlls() {
	}

	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		String MethodUsed = request.getMethod();
		
		//String path = request.getServletPath();
		//System.out.println("here yet?");
		
		switch(MethodUsed) {
			case "POST":
			
			ObjectMapper om = new ObjectMapper();
			PrintWriter PW = response.getWriter();
			String UserName = request.getParameter("UserName");
			String Password = request.getParameter("Password");
			String Login = LS.Validation(UserName, Password);
			String Position = LS.PositionValidation(UserName, Password);
			
			//System.out.print(Login);
			//System.out.println("Reached Authentication.");
			
			if(Login!= null && Position != null) {
				
				response.setStatus(201);
	
				if(Login.equals("Success") && Position.equals("Employee")) {
					
					//PW.println("<h4>You have Successfully Logged In<h4>");
					response.sendRedirect("static/Employee.html");
					response.setStatus(201);
				}
				else if(Login.equals("Success") && Position.equals("Manager")){
					System.out.println("Reach Manger");
					response.sendRedirect("static/Management.html");
					response.setStatus(201);
				}
				else {
					PW.println("<html>");
					PW.println("<h4>The information you provided was incorrect or an error occured<h4>");
					PW.println("</html>");
				}
			}
			case "GET":
				//VD.process(request, response);
				break;	
				
			default:
				response.sendError(401, "No Database entry exists for the User");
				break;
		}}
	}