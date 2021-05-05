package com.revature.Models;

import java.io.Serializable;


public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String Name = new String();
	private String Password = new String();
	private String UserName = new String();
	
	public Customer() {
		super();
	}
	public Customer(String name, String password, String userName) {
		super();
		Name = name;
		Password = password;
		UserName = userName;
	}
	//Establish public getters and setters to obtain customer ID, UserName, ect.
	public void SetCustomerName(String Name){
		this.Name = Name;
	}
	public String GetCustomerName(){
		return Name;
	}
	public void SetCustomerPassword(String Password){
		this.Password = Password;
	}
	public String GetCustomerUserName(){
		
		return UserName;
	}
	public void SetCustomerUserName(String UserName){
		this.UserName = UserName;
	}
	public String GetCustomerPassword() {
		
		return Password;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((UserName == null) ? 0 : UserName.hashCode());
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
		Customer other = (Customer) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (UserName == null) {
			if (other.UserName != null)
				return false;
		} else if (!UserName.equals(other.UserName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [Name=" + Name + ", Password=" + Password + ", UserName=" + UserName + "]";
	}
}


