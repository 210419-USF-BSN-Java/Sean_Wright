package Services;
import com.revature.Models.Offers;

public interface OfferServices {
	
	public String MakeNewOffer(Offers o);
	public String RejectOffer(Offers o);
	public String AcceptOffer(Offers o);
	

}
