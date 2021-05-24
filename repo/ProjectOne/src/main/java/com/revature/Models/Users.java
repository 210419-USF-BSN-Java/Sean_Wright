package com.revature.Models;

public class Users {
	
	private Integer ERS_User_ID;
	private String ERS_UserName;
	private String ERS_Password;
	private String User_First_Name;
	private String User_Last_Name;
	private String User_Email;
	private Integer ERS_User_Role_ID;
	//private String User_Role;
	
	
	public Users() {
		super();
	}
	
	public Users(Integer eRS_User_ID, String eRS_UserName, String eRS_Password, String user_First_Name,
			String user_Last_Name, String user_Email, Integer eRS_User_Role_ID) {
		super();
		ERS_User_ID = eRS_User_ID;
		ERS_UserName = eRS_UserName;
		ERS_Password = eRS_Password;
		User_First_Name = user_First_Name;
		User_Last_Name = user_Last_Name;
		User_Email = user_Email;
		ERS_User_Role_ID = eRS_User_Role_ID;
		//this.User_Role = User_Role;
	}

	
	//public void setUser_Role(String User_Role) {
	//	this.User_Role = User_Role;
	//}
	//
	//public String getUser_Role() {
	//	return User_Role;
	//}
	
	public Integer getERS_User_ID() {
		return ERS_User_ID;
	}

	public void setERS_User_ID(Integer eRS_User_ID) {
		ERS_User_ID = eRS_User_ID;
	}

	public String getERS_UserName() {
		return ERS_UserName;
	}

	public void setERS_UserName(String eRS_UserName) {
		ERS_UserName = eRS_UserName;
	}

	public String getERS_Password() {
		return ERS_Password;
	}

	public void setERS_Password(String eRS_Password) {
		ERS_Password = eRS_Password;
	}

	public String getUser_First_Name() {
		return User_First_Name;
	}

	public void setUser_First_Name(String user_First_Name) {
		User_First_Name = user_First_Name;
	}

	public String getUser_Last_Name() {
		return User_Last_Name;
	}

	public void setUser_Last_Name(String user_Last_Name) {
		User_Last_Name = user_Last_Name;
	}

	public String getUser_Email() {
		return User_Email;
	}

	public void setUser_Email(String user_Email) {
		User_Email = user_Email;
	}

	public Integer getERS_User_Role_ID() {
		return ERS_User_Role_ID;
	}

	public void setERS_User_Role_ID(Integer eRS_User_Role_ID) {
		ERS_User_Role_ID = eRS_User_Role_ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ERS_Password == null) ? 0 : ERS_Password.hashCode());
		result = prime * result + ((ERS_UserName == null) ? 0 : ERS_UserName.hashCode());
		result = prime * result + ((ERS_User_ID == null) ? 0 : ERS_User_ID.hashCode());
		result = prime * result + ((ERS_User_Role_ID == null) ? 0 : ERS_User_Role_ID.hashCode());
		result = prime * result + ((User_Email == null) ? 0 : User_Email.hashCode());
		result = prime * result + ((User_First_Name == null) ? 0 : User_First_Name.hashCode());
		result = prime * result + ((User_Last_Name == null) ? 0 : User_Last_Name.hashCode());
		//result = prime * result + ((User_Role == null) ? 0 : User_Role.hashCode());
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
		Users other = (Users) obj;
		if (ERS_Password == null) {
			if (other.ERS_Password != null)
				return false;
		} else if (!ERS_Password.equals(other.ERS_Password))
			return false;
		if (ERS_UserName == null) {
			if (other.ERS_UserName != null)
				return false;
		} else if (!ERS_UserName.equals(other.ERS_UserName))
			return false;
		if (ERS_User_ID == null) {
			if (other.ERS_User_ID != null)
				return false;
		} else if (!ERS_User_ID.equals(other.ERS_User_ID))
			return false;
		if (ERS_User_Role_ID == null) {
			if (other.ERS_User_Role_ID != null)
				return false;
		} else if (!ERS_User_Role_ID.equals(other.ERS_User_Role_ID))
			return false;
		if (User_Email == null) {
			if (other.User_Email != null)
				return false;
		} else if (!User_Email.equals(other.User_Email))
			return false;
		if (User_First_Name == null) {
			if (other.User_First_Name != null)
				return false;
		} else if (!User_First_Name.equals(other.User_First_Name))
			return false;
		if (User_Last_Name == null) {
			if (other.User_Last_Name != null)
				return false;
		} else if (!User_Last_Name.equals(other.User_Last_Name))
			return false;
		//if (User_Role == null) {
		//	if (other.User_Role != null)
		//		return false;
		//} else if (!User_Role.equals(other.User_Role))
		//	return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [ERS_User_ID=" + ERS_User_ID + ", ERS_UserName=" + ERS_UserName + ", ERS_Password=" + ERS_Password
				+ ", User_First_Name=" + User_First_Name + ", User_Last_Name=" + User_Last_Name + ", User_Email="
				+ User_Email + ", ERS_User_Role_ID=" + ERS_User_Role_ID + ", User_Role=" + "]";
	}	
}
