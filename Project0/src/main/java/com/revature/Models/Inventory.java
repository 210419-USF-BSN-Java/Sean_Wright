package com.revature.Models;

public class Inventory {
	
	private String productName;
	private Double productPrice;
	private Boolean OfferMade;
	private Boolean OfferAccepted;
	private String Owner_id;
	
	public Inventory() {
		super();
	}
	
	public Inventory(String productName, Double productPrice, Boolean offerMade, Boolean offerAccepted,String Owner_id) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		OfferMade = offerMade;
		OfferAccepted = offerAccepted;
	}
	//Getters and Setters;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Boolean getOfferMade() {
		return OfferMade;
	}
	public void setOfferMade(Boolean offerMade) {
		OfferMade = offerMade;
	}
	public Boolean getOfferAccepted() {
		return OfferAccepted;
	}
	public void setOfferAccepted(Boolean offerAccepted) {
		OfferAccepted = offerAccepted;
	}
	public String getOwner_id() {
		return Owner_id;
	}
	public void setOwner_id(String owner_id) {
		Owner_id = owner_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OfferAccepted == null) ? 0 : OfferAccepted.hashCode());
		result = prime * result + ((OfferMade == null) ? 0 : OfferMade.hashCode());
		result = prime * result + ((Owner_id == null) ? 0 : Owner_id.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
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
		Inventory other = (Inventory) obj;
		if (OfferAccepted == null) {
			if (other.OfferAccepted != null)
				return false;
		} else if (!OfferAccepted.equals(other.OfferAccepted))
			return false;
		if (OfferMade == null) {
			if (other.OfferMade != null)
				return false;
		} else if (!OfferMade.equals(other.OfferMade))
			return false;
		if (Owner_id == null) {
			if (other.Owner_id != null)
				return false;
		} else if (!Owner_id.equals(other.Owner_id))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice == null) {
			if (other.productPrice != null)
				return false;
		} else if (!productPrice.equals(other.productPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [productName=" + productName + ", productPrice=" + productPrice + ", OfferMade=" + OfferMade
				+ ", OfferAccepted=" + OfferAccepted + ", Owner_id=" + Owner_id + "]";
	}
}
