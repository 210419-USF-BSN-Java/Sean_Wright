package com.revature.Models;

public class ESRReimbursementType {
	
	private Integer Reimb_Type_ID;
	private String Reimb_Type;
	
	
	public ESRReimbursementType() {
		super();
	}

	public ESRReimbursementType(Integer reimb_Type_ID, String reimb_Type) {
		super();
		Reimb_Type_ID = reimb_Type_ID;
		Reimb_Type = reimb_Type;
	}


	public Integer getReimb_Type_ID() {
		return Reimb_Type_ID;
	}


	public void setReimb_Type_ID(Integer reimb_Type_ID) {
		Reimb_Type_ID = reimb_Type_ID;
	}


	public String getReimb_Type() {
		return Reimb_Type;
	}


	public void setReimb_Type(String reimb_Type) {
		Reimb_Type = reimb_Type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Reimb_Type == null) ? 0 : Reimb_Type.hashCode());
		result = prime * result + ((Reimb_Type_ID == null) ? 0 : Reimb_Type_ID.hashCode());
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
		ESRReimbursementType other = (ESRReimbursementType) obj;
		if (Reimb_Type == null) {
			if (other.Reimb_Type != null)
				return false;
		} else if (!Reimb_Type.equals(other.Reimb_Type))
			return false;
		if (Reimb_Type_ID == null) {
			if (other.Reimb_Type_ID != null)
				return false;
		} else if (!Reimb_Type_ID.equals(other.Reimb_Type_ID))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ESRReimbursementType [Reimb_Type_ID=" + Reimb_Type_ID + ", Reimb_Type=" + Reimb_Type + "]";
	}
	
	

}
