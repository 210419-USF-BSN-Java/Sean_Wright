package com.revature.Controllers;
import com.revature.Daos.CustomerSQL;
import com.revature.Daos.EmployeeSQL;
import com.revature.Daos.InventorySQL;
import com.revature.Daos.OfferSQL;
import Services.*;
import com.revature.Models.*;
import java.util.Scanner;
import java.util.Random;

public class CustomerStory {
	

	CustomerSQL C = new CustomerSQL();
	
	String UserName = new String();
	String Password = new String();
	String Name = new String();
	String LoginU = new String();
	Scanner sc = new Scanner(System.in);
	CustomerServiceImplementation CSI = new CustomerServiceImplementation();
	InventoryServiceEmplementation ISE = new InventoryServiceEmplementation();
	InventorySQL id = new InventorySQL();
	
	
	public String CustomerLogin(int option) {
	
		System.out.println("Welcome Valued Customer!! Please select from the options below.");
		System.out.println("1.) Log into an existing Customer Account.");
		System.out.println("2.) Create a new Customer Account.");
	
		option = sc.nextInt();
		sc.nextLine();
	
		if(option == 1) {
			System.out.println("Welcome Back!!");
			System.out.println("Please enter your Username");
			System.out.println("Username: ");
			UserName = sc.nextLine();
			LoginU = UserName;
			System.out.println("Password: ");
			Password = sc.nextLine();
			
			CSI.GetCustomerByUserName(UserName);
			//set up Junit test for testing weather the username returned is null. 
		}
	
		if(option == 2) {
			System.out.println("Welcome New Customer!!");
			System.out.println("Please enter your unique User Name.");
			UserName = sc.nextLine();
			LoginU = UserName;
			System.out.println("Please enter your Password.");
			Password = sc.nextLine();
			
			System.out.println("Please enter your name");
			Name = sc.nextLine();
			
			Customer NewCustomer = new Customer(Name,Password,UserName);
			CSI.CreateNewCustomerAccount(NewCustomer);
			
		}
		return LoginU;
	}
	public int CustomerBuisness(String LoginU) {
		
		int input;
		
		System.out.println("What buisness would you like to conduct today?");
		System.out.println("1.) Make an offer on a product.");
		System.out.println("2.) View my offers.");
		System.out.println("3.) View my owned items.");
		System.out.println("4.) View Available Items.");
		input = sc.nextInt();
		sc.nextLine();
		
		if(input == 1) {
			
			InventoryServiceEmplementation ISE = new InventoryServiceEmplementation();
			System.out.println("These are the available products to make offers upon.");
			
			
			//List the  inventory with false accepted booleans.
			Boolean accepted = false;
			OfferSQL O = new OfferSQL();
			ISE.GetByAccepted(accepted).forEach(t -> System.out.println(t));
			
			System.out.println("From the list above, please enter the Product Name of your offer choice.");
			String offer = sc.nextLine();
			System.out.println("Please enter an ammount for the offer.");
			Double Amount = sc.nextDouble();
			sc.nextLine();
			System.out.print(Amount);
			Random rand = new Random(); //instance of random class
		    int int_random = 1 + rand.nextInt(100000);
			Double SerialNumber = Double.valueOf(int_random);
			
			Offers NewOffer = new Offers(LoginU,Amount,offer,SerialNumber,accepted);
			System.out.println(O.add(NewOffer));
			
		}
		if(input == 2) {
			OfferSQL T = new OfferSQL();
			System.out.println("Listed below are your current pending offers.");
			System.out.println(T.GetByCustomer(LoginU));
		}
		
		return 1;
	}
}
