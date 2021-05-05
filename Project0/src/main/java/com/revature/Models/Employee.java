package com.revature.Models;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String Name;
	private String EUserName;
	private String Password;
	private Integer Rank;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String eUserName, String password, Integer rank) {
		super();
		Name = name;
		EUserName = eUserName;
		Password = password;
		Rank = rank;
	}
	public String getEmployeeName() {
		return Name;
	}
	public void setEmployeeName(String name) {
		Name = name;
	}
	public String getEUserName() {
		return EUserName;
	}
	public void setEUserName(String eUserName) {
		EUserName = eUserName;
	}
	public String getEPassword() {
		return Password;
	}
	public void setEPassword(String password) {
		Password = password;
	}
	public Integer getRank() {
		return Rank;
	}
	public void setRank(Integer rank) {
		Rank = rank;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EUserName == null) ? 0 : EUserName.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((Rank == null) ? 0 : Rank.hashCode());
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
		Employee other = (Employee) obj;
		if (EUserName == null) {
			if (other.EUserName != null)
				return false;
		} else if (!EUserName.equals(other.EUserName))
			return false;
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
		if (Rank == null) {
			if (other.Rank != null)
				return false;
		} else if (!Rank.equals(other.Rank))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [Name=" + Name + ", EUserName=" + EUserName + ", Password=" + Password + ", Rank=" + Rank
				+ "]";
	}
	
	

}
