package Delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate extends HttpServlet {
	
	private static ViewDelegate VD = new ViewDelegate();
	
	
	private static final long serialVersionUID = 1L;
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("At the view Delegate");
		
		if (path.startsWith("/Users/Login")) {
			request.getRequestDispatcher("ProjectOne/Login.html").forward(request, response);
			return;
			
		}else if (path.startsWith("/Employee")) {
			request.getRequestDispatcher("ProjectOne/Employee.html").forward(request, response);
			return;
			
		}else if (path.startsWith("/Manager")) {
			
			request.getRequestDispatcher("ProjectOne/Management.html").forward(request, response);
			return;
		}
	}
}
