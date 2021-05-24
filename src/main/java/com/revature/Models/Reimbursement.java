package com.revature.Models;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reimbursement {

	private Integer RMB_ID;
	private Double RMB_AMNT;
	private LocalDateTime Submitted;
	private LocalDateTime Resolved;
	private String Description;
	//private Byte Recieipt;
	private Integer Author_ID;
	private Integer Resolver_ID;
	private Integer RMB_Status_ID;
	private Integer RMB_Type_ID;
	
	
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(Integer rMB_ID, Double rMB_AMNT,LocalDateTime Submtd,LocalDateTime resolved, String description,
			Integer author_ID, Integer resolver_ID, Integer rMB_Status_ID, Integer rMB_Type_ID) {
		
		super();
		
		RMB_ID = rMB_ID;
		RMB_AMNT = rMB_AMNT;
		Submitted = Submtd;
		Resolved = resolved;
		Description = description;
		Author_ID = author_ID;
		Resolver_ID = resolver_ID;
		RMB_Status_ID = rMB_Status_ID;
		RMB_Type_ID = rMB_Type_ID;
	}

	//Getters and Setters.	
	
	
	
	public LocalDateTime getSubmitted() {
		return Submitted;
	}

	public void setSubmitted(LocalDateTime object) {
		Submitted = object;
	}

	public Integer getRMB_ID() {
		return RMB_ID;
	}
	public void setRMB_ID(Integer rMB_ID) {
		RMB_ID = rMB_ID;
	}
	public Double getRMB_AMNT() {
		return RMB_AMNT;
	}
	public void setRMB_AMNT(Double rMB_AMNT) {
		RMB_AMNT = rMB_AMNT;
	}
	public LocalDateTime getResolved() {
		return Resolved;
	}
	public void setResolved(LocalDateTime resolved) {
		Resolved = resolved;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getAuthor_ID() {
		return Author_ID;
	}
	public void setAuthor_ID(Integer author_ID) {
		Author_ID = author_ID;
	}
	public Integer getResolver_ID() {
		return Resolver_ID;
	}
	public void setResolver_ID(Integer resolver_ID) {
		Resolver_ID = resolver_ID;
	}
	public Integer getRMB_Status_ID() {
		return RMB_Status_ID;
	}
	public void setRMB_Status_ID(Integer rMB_Status_ID) {
		RMB_Status_ID = rMB_Status_ID;
	}
	public Integer getRMB_Type_ID() {
		return RMB_Type_ID;
	}
	public void setRMB_Type_ID(Integer rMB_Type_ID) {
		RMB_Type_ID = rMB_Type_ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Author_ID == null) ? 0 : Author_ID.hashCode());
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ((RMB_AMNT == null) ? 0 : RMB_AMNT.hashCode());
		result = prime * result + ((RMB_ID == null) ? 0 : RMB_ID.hashCode());
		result = prime * result + ((RMB_Status_ID == null) ? 0 : RMB_Status_ID.hashCode());
		result = prime * result + ((RMB_Type_ID == null) ? 0 : RMB_Type_ID.hashCode());
		result = prime * result + ((Resolved == null) ? 0 : Resolved.hashCode());
		result = prime * result + ((Resolver_ID == null) ? 0 : Resolver_ID.hashCode());
		result = prime * result + ((Submitted == null) ? 0 : Submitted.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Author_ID == null) {
			if (other.Author_ID != null)
				return false;
		} else if (!Author_ID.equals(other.Author_ID))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (RMB_AMNT == null) {
			if (other.RMB_AMNT != null)
				return false;
		} else if (!RMB_AMNT.equals(other.RMB_AMNT))
			return false;
		if (RMB_ID == null) {
			if (other.RMB_ID != null)
				return false;
		} else if (!RMB_ID.equals(other.RMB_ID))
			return false;
		if (RMB_Status_ID == null) {
			if (other.RMB_Status_ID != null)
				return false;
		} else if (!RMB_Status_ID.equals(other.RMB_Status_ID))
			return false;
		if (RMB_Type_ID == null) {
			if (other.RMB_Type_ID != null)
				return false;
		} else if (!RMB_Type_ID.equals(other.RMB_Type_ID))
			return false;
		if (Resolved == null) {
			if (other.Resolved != null)
				return false;
		} else if (!Resolved.equals(other.Resolved))
			return false;
		if (Resolver_ID == null) {
			if (other.Resolver_ID != null)
				return false;
		} else if (!Resolver_ID.equals(other.Resolver_ID))
			return false;
		if (Submitted == null) {
			if (other.Submitted != null)
				return false;
		} else if (!Submitted.equals(other.Submitted))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [RMB_ID=" + RMB_ID + ", RMB_AMNT=" + RMB_AMNT + ", Submitted=" + Submitted + ", Resolved="
				+ Resolved + ", Description=" + Description + ", Author_ID=" + Author_ID + ", Resolver_ID="
				+ Resolver_ID + ", RMB_Status_ID=" + RMB_Status_ID + ", RMB_Type_ID=" + RMB_Type_ID + "]";
	}
}
