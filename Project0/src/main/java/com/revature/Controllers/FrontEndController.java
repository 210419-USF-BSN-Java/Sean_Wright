package com.revature.Controllers;

import Services.*;

import com.revature.Daos.*;
import com.revature.Models.*;
import com.revature.Models.Customer;
import java.util.List;
import java.util.Scanner;

public class FrontEndController {
	
	public static void main(String[] args) {
		
		int option;
		CustomerStory CS = new CustomerStory();
		EmployeeManagementStory EMS = new EmployeeManagementStory();
		Scanner sb = new Scanner(System.in);
		System.out.println("Welcome to the Sketchy Used Car Auction!!");
		System.out.println("Please log in as a Customer or Employee.");
		System.out.println("1.) Customer Login");
		System.out.println("2.) Employee Login");
		
		do {
			option = sb.nextInt();
			if( option < 1 || option > 2) {
				System.out.println("Please enter a vaid value");
			}
		}
		while(option < 1 || option > 2);
		if(option == 1) {
			String i = CS.CustomerLogin(option);
			int y = CS.CustomerBuisness(i);
			
		}
		if(option == 2) {
			int j =EMS.EmployeeLogin(option);
			
			if(j == 1) {
				int f = EMS.EmployeeInventoryPortal(option);
			}
			if(j == 2) {
				int f = EMS.EmploymentPortal();
			}
		}
	}
}