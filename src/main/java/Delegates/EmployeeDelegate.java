package Delegates;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.Services.*;


public class EmployeeDelegate {
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter pw = response.getWriter(); 
		System.out.println("Reached employee Del.");
	}
	
	
	
	

}
