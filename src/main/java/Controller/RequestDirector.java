package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Delegates.EmployeeDelegate;
import Delegates.ManagerDelegate;
import Delegates.ReimbursementDeligate;


public class RequestDirector {
	
	UserControlls UC = new UserControlls();
	EmployeeDelegate ED = new EmployeeDelegate();
	ManagerDelegate MD = new ManagerDelegate();
	
	public void  ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		StringBuilder URIbuilder = new StringBuilder(request.getRequestURI());
		URIbuilder.replace(0,  request.getContextPath().length() + 1, "");
		
		//String path = request.getRequestURI().substring(requst.getContextPath().length());
		
		if(URIbuilder.indexOf("/") != -1) {
			request.setAttribute("path", URIbuilder.substring(URIbuilder.indexOf("/") + 1));
			
			//request.getRequestURI().substring(URIbuilder.indexOf("/") + 1);
			URIbuilder.replace(URIbuilder.indexOf("/"), URIbuilder.length(), "");
			//System.out.println("This stuff Right here.");
			//System.out.print(URIbuilder.toString());
			//System.out.print(path);
			
		}
		String URI = URIbuilder.toString();
		
		switch(URI) {
		case "Login":
			//System.out.println("were here.");
			UC.process(request, response);
			break;
			
		case "Manager":
			//System.out.println("Manager");
			MD.process(request, response);
			break;
			
		case "Employee":
			//System.out.println("Employee");
			ED.process(request, response);
			break;
			
		default:
			response.sendError(404, "Page Not Found");
			break;
		}
	
	}
	
}
