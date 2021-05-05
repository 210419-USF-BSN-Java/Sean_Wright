package com.revature.Controllers;

import java.util.Scanner;


import com.revature.Daos.CustomerSQL;
import com.revature.Daos.EmployeeSQL;
import com.revature.Daos.InventorySQL;
import com.revature.Daos.OfferSQL;
import com.revature.Models.*;
import Services.EmployeeServiceImplementation;

import Services.*;

public class EmployeeManagementStory {
	
		Scanner sc = new Scanner(System.in);
		EmployeeSQL E = new EmployeeSQL();
		String UserName = new String();
		String Password = new String();
		String Name = new String();
		EmployeeServiceImplementation ESI = new EmployeeServiceImplementation();
		InventoryServiceEmplementation ISI = new InventoryServiceEmplementation();
		
	public int EmployeeLogin(int option) {
	
		
		System.out.println("Welcome Valued Employee!!");
		System.out.println("Please enter your Username.");
		System.out.println("Username: ");
	    UserName = sc.nextLine();
		System.out.println("Please enter your Password.");
		System.out.println("Password: ");
		Password = sc.nextLine();
		EmployeeServiceImplementation ESI = new EmployeeServiceImplementation();
		String TestUserName = ESI.GetEmployeeByUserName(UserName).getEUserName();
		String TestPassword = ESI.GetEmployeeByUserName(UserName).getEPassword();
		option = 1;
		
		return option;
	}
	public int EmploymentPortal() {
		
		System.out.println("Welcome to the employment Portal.");
		System.out.println("1.) Alter Inventory");
		System.out.println("2.) Hire or Fire an employee.");
		int option;
		option = sc.nextInt();
			
		if(option == 1) {
			
			System.out.println("Select Higher or fire.");
			System.out.println("1.) Hire");
			System.out.println("2.) Fire");
			option = sc.nextInt();
			sc.nextLine();
			
			if(option ==2) {
				
				System.out.println("Please enter the username of the employee you would like to fire?");
				String fire = sc.nextLine();
				ESI.RemoveEmployeeAccount(ESI.GetEmployeeByUserName(fire));
			}
			if(option == 1) {
				
				//New Employee Information. 
				System.out.println("Please enter the new employee's name.");
				String NameNewEmp = sc.nextLine();
				System.out.println("Please enter the new employee's User Name.");
				String UserNameNewEmp = sc.nextLine();
				System.out.println("Please enter the new employee's Rank.");
				Integer NewRank = sc.nextInt();
				sc.nextLine();
				System.out.println("Please have the new employee enter their new password.");
				String NewPassword = sc.nextLine();
				
				//code for 
				Employee NewEmployee = new Employee(NameNewEmp,UserNameNewEmp,NewPassword,NewRank);
				ESI.CreateEmployeeAccount(NewEmployee);
				sc.close();
			}
		}
		if(option == 2) {
					
			System.out.println("Please enter the employees username you would like to alter?");
			String alter = sc.nextLine();
			System.out.println("Please enter the updated information into the following fields as follows:");
			System.out.println("Name:");
			String NameOne = sc.nextLine();
			System.out.println("Password:");
			String PasswordOne = sc.nextLine();
			System.out.println("Rank:");
			Integer RankOne = sc.nextInt();
			sc.nextLine();
					
			Employee alteredEmployee = new Employee(NameOne,alter,PasswordOne,RankOne);
					
			System.out.println(ESI.UpdateEmployeeInformation(alteredEmployee));
			
			System.out.println("The Altered employee information is as follows:");
			System.out.print(ESI.GetEmployeeByName(NameOne));
			
			
		}
		return option;
	}
	public int EmployeeInventoryPortal(int option) {
		
		Scanner sc = new Scanner(System.in);	
		System.out.println("Welcome to the employee Inventory Portal.");
		System.out.println("1.) Remove Inventory ");
		System.out.println("2.) Add to inventory ");
		System.out.println("3.) Accept or Reject Offers");
		option = sc.nextInt();
		sc.nextLine();
		
		if(option == 1) {
			System.out.println("Please enter the name of the product you would like to remove from Inventory.");
			String product = sc.nextLine();
			ISI.RemoveInventory(ISI.getInventoryByProductName(product));
		}
		if(option == 2) {
			System.out.println("Please enter the name of the product you would like to add to inventory.");
			String ProductName = sc.nextLine();
			System.out.println("Please enter a reasonable Asking Price associated with this item.");
			Double AskingPrice = sc.nextDouble();
			sc.nextLine();
			String CurrentOwner = null;
			Boolean OfferAccepted = false;
			Boolean OfferMade = false;
			ISI.InsertNewInventory( new Inventory(ProductName, AskingPrice, OfferMade,OfferAccepted,CurrentOwner));
		}
		if(option == 3) {
			
			OfferSQL NewOffer = new OfferSQL();
			System.out.println("Listed below are the remaining offers that have not been accepted.");
			NewOffer.GetByOfferAccepted(false).forEach(t -> System.out.println(t));
			System.out.println("To select an offer, plese enter the serial number of an offer from above. ");
			Double SerialNumber = sc.nextDouble();
			sc.nextLine();
			System.out.println("Would you like to (1) Accept or (2) Reject this offer?");
			System.out.println("Note: Rejecting an offer will permanantly delete that offer.");
			option = sc.nextInt();
			
			if(option == 1) {
				NewOffer.GetBySerialNumber(SerialNumber).setAccepted(true);
				String ProductSold = NewOffer.GetBySerialNumber(SerialNumber).getProductName();
				Offers o = new Offers(null, 45.67, ProductSold, 908.87, false); //Values for placeholders to be deleted.
				NewOffer.RemoveUnacceptedOffers(o);
				if((ISI.RemoveInventory(ISI.getInventoryByProductName(ProductSold))) == 1) {
					System.out.println("Offer Accepted.");
				}
				
			}
			if(option == 2) {
				
				System.out.println(NewOffer.delete(NewOffer.GetBySerialNumber(SerialNumber)));
				
			}
		}
		return 3;
	}
}

