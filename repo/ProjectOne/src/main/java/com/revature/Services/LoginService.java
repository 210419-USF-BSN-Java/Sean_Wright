package com.revature.Services;

import java.util.List;

import com.revature.Daos.UserRolesSQL;
import com.revature.Daos.UserSQL;
import com.revature.Models.ERS_User_Roles;
import com.revature.Models.Users;


public class LoginService {
	
	UserSQL US = new UserSQL();
	UserRolesSQL EUR = new UserRolesSQL();
	
	public String Validation(String UserName, String Password) {
		
		List<Users> U = US.getAll();
		String L = new String();
		
		for(Users n : U) {
			
			
			if(n.getERS_UserName().equals(UserName) && n.getERS_Password().equals(Password)) {
				
				L = "Success";
			}
		}
		return L;
	}
	public String PositionValidation(String UserName, String Password) {
		
		List<Users> N = US.getAll();
		List<ERS_User_Roles> J = EUR.getAll();
		String Position = new String();
		
		for(Users n : N) {
			if(n.getERS_UserName().equals(UserName) && n.getERS_Password().equals(Password)) {
				
				for(ERS_User_Roles i : J) {
					if(i.getUser_Role_ID() == n.getERS_User_Role_ID()) {
						Position = i.getUser_Role();
					}
				}
			}
		}
		return Position;
	}
}
