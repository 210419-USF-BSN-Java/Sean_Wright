package com.revature.Daos;

import java.util.List;


import com.revature.Models.Offers;



public interface OffersDao extends CompanyDao<Offers>{
	
	public List<Offers> GetByOfferAccepted(Boolean isAccepted);
	public List<Offers> GetByCustomer(String UserName);
	public Offers GetBySerialNumber(Double SerialNumber);
	public Integer RemoveUnacceptedOffers(Offers o);
}
