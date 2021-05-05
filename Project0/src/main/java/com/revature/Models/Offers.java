package com.revature.Models;

public class Offers {
	
	private String CustID;
	private Double Amount;
	private String ProductName;
	private Double SerialNumber;
	private Boolean Accepted;
	
	public Offers() {
		super();
	}
	
	public Offers(String CustID,Double Amount, String ProductName, Double SerialNumber,Boolean Accepted) {
		super();
		this.CustID = CustID;
		this.Amount = Amount;
		this.ProductName = ProductName;
		this.SerialNumber = SerialNumber;
		this.Accepted = Accepted;
		
	}

	public String getCustID() {
		return CustID;
	}
	public void setCustID(String custID) {
		CustID = custID;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double Amount) {
		this.Amount = Amount;
	}
	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}
	public String getProductName() {
		return ProductName;
	}
	public Double getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(Double serialNumber) {
		SerialNumber = serialNumber;
	}

	public Boolean getAccepted() {
		return Accepted;
	}

	public void setAccepted(Boolean accepted) {
		Accepted = accepted;
	}

	@Override
	public String toString() {
		return " [Customer  " + CustID + ", Amount  " + Amount + ", Product Name  " + ProductName + ", Offer Accepted  " + Accepted + " Serial Number  " + SerialNumber + "[";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Amount == null) ? 0 : Amount.hashCode());
		result = prime * result + ((CustID == null) ? 0 : CustID.hashCode());
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
		Offers other = (Offers) obj;
		if (Amount == null) {
			if (other.Amount != null)
				return false;
		} else if (!Amount.equals(other.Amount))
			return false;
		if (CustID == null) {
			if (other.CustID != null)
				return false;
		} else if (!CustID.equals(other.CustID))
			return false;
		return true;
	}
	
	
	
	
	
}
