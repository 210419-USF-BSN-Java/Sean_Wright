package com.revature.Models;

public class ERS_User_Roles {
	
	private String User_Role;
	private Integer User_Role_ID;
	
	public ERS_User_Roles() {
		super();
	}
	
	public ERS_User_Roles(String user_Role, Integer user_Role_ID) {
		super();
		User_Role = user_Role;
		User_Role_ID = user_Role_ID;
	}
	
	

	public String getUser_Role() {
		return User_Role;
	}

	public void setUser_Role(String user_Role) {
		User_Role = user_Role;
	}

	public Integer getUser_Role_ID() {
		return User_Role_ID;
	}

	public void setUser_Role_ID(Integer user_Role_ID) {
		User_Role_ID = user_Role_ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((User_Role == null) ? 0 : User_Role.hashCode());
		result = prime * result + ((User_Role_ID == null) ? 0 : User_Role_ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERS_User_Roles other = (ERS_User_Roles) obj;
		if (User_Role == null) {
			if (other.User_Role != null)
				return false;
		} else if (!User_Role.equals(other.User_Role))
			return false;
		if (User_Role_ID == null) {
			if (other.User_Role_ID != null)
				return false;
		} else if (!User_Role_ID.equals(other.User_Role_ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ERS_User_Roles [User_Role=" + User_Role + ", User_Role_ID=" + User_Role_ID + "]";
	}
	
	

}
