package com.revature.Daos;

public class DaoFactory {

		private static DaoFactory df;
		
		private DaoFactory() {}
		
		public static DaoFactory getDaoFactory() {
			
			if(df == null) {
				df = new DaoFactory();
			}
			
			return df;
		}
		// Factory behavior
		public EmployeeDao getEmployeeDao() {
			return new EmployeeSQL();
		}
		public CustomerDao getCustomerDao() {
			return new CustomerSQL();
		}
		public InventoryDao getInventoryDao() {
			return new InventorySQL();
		}
		public OffersDao getOfferDao() {
			return new OfferSQL();
		}
}
