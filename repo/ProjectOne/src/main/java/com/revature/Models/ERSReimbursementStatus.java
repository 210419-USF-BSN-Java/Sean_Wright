package com.revature.Models;

public class ERSReimbursementStatus {
	
	public Integer Reimb_Status_ID;
	public Integer Reimb_Status;
	
	
	public ERSReimbursementStatus(Integer reimb_Status_ID, Integer reimb_Status) {
		super();
		Reimb_Status_ID = reimb_Status_ID;
		Reimb_Status = reimb_Status;
	}
	
	
	public ERSReimbursementStatus() {
		super();
	}

	
	public Integer getReimb_Status_ID() {
		return Reimb_Status_ID;
	}


	public void setReimb_Status_ID(Integer reimb_Status_ID) {
		Reimb_Status_ID = reimb_Status_ID;
	}


	public Integer getReimb_Status() {
		return Reimb_Status;
	}


	public void setReimb_Status(Integer reimb_Status) {
		Reimb_Status = reimb_Status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Reimb_Status == null) ? 0 : Reimb_Status.hashCode());
		result = prime * result + ((Reimb_Status_ID == null) ? 0 : Reimb_Status_ID.hashCode());
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
		ERSReimbursementStatus other = (ERSReimbursementStatus) obj;
		if (Reimb_Status == null) {
			if (other.Reimb_Status != null)
				return false;
		} else if (!Reimb_Status.equals(other.Reimb_Status))
			return false;
		if (Reimb_Status_ID == null) {
			if (other.Reimb_Status_ID != null)
				return false;
		} else if (!Reimb_Status_ID.equals(other.Reimb_Status_ID))
			return false;
		return true;
	}
	
	

}
