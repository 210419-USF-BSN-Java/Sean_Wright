package com.revature.Services;

import java.util.List;

import java.util.ArrayList;
import com.revature.Models.Users;
import com.revature.Models.ERS_User_Roles;
import com.revature.Daos.*;


public class UserServices {
	UserRolesSQL UL = new UserRolesSQL();
	UserSQL UE = new UserSQL();
	
	public List<Users> viewAllEmployees(){
		
		 List<ERS_User_Roles> us = UL.getAll();
		 List<Users> ue = UE.getAll();
		 List<Users> ut = new ArrayList<>();
		 
		return null;
			
				 
			 }
			 
			 
			 
		
	}
	
