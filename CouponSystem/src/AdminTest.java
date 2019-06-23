
import Database.User;
import Login.Login;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import Database.*;
import Coupon.*;
import Customer.*;
import Admin.*;
import Admin.AdminFacade;
import Company.Company;

/**Test for AdminFacade**/

public class AdminTest {

	public static void main(String[] args) throws Exception {
	
	
		/**Driver to connect to db**/
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		
		Set<Company> companies = new HashSet<Company>();
		Set<Customer> customers = new HashSet<Customer>();
		Set<Coupon> coupons = new HashSet<Coupon>();
		AdminFacade facade = new AdminFacade();
		
		
		String line = "---------------------------------------------------------------\n";
		
		//Login as Admin
		facade.Login("admin", "1234");
		   
		      if (facade instanceof AdminFacade) {
                    System.out.println("========  Login(admin, 1234, AdminFacade) ========\n");
        
      /******************************************************************/              
      /** Create new 2 companies*/
                  //Template//
                  // Company C3 = new Company(033, "RedBend4", "red00red00", "harman@gmail.com");
                //  Company C2 = new Company(014, "HTest2", "harhar", "harman@gmail.com");
                   
                 //   ((AdminFacade) facade).CreateCompany(C3);
		       //  ((AdminFacade) facade).CreateCompany(C2);
	
   /****Show All companies method (working) *******************/
                    
     // Show all companies (After creating new companies - before update).
	//*companies = ((AdminFacade) facade).getAllCompanies();
	//*System.out.println("After creating new companies - Show all new companies\n" + line + companies.toString());
		            
	/********************************************************************/			
		/**Update Company Test -- (not working yet)**/
	//((AdminFacade) facade).updateCompany(63, "RedBEND4", "red00red00", "harman@gmail.com");
		
	/********************************************************************/
	 
	// Show One updated company id=5
	/**Display company details according to id (method is working)**/
	
	//Company company1 = ((AdminFacade) facade).getCompany(63);
	//System.out.println("Display company details - according to company id : " + company1.toString());
		      
	/********************************************************************/
	
	/********Remove Company method*  (not working yet this method ) ********************/
	//Company company1 = ((AdminFacade) facade).getCompany(63);
	//Company company = ((AdminFacade) facade).removeCompany(company);
	
	/**********************************************************************************/
	//
	//
	/**********************************************************************************/
	               /**Coupons Tests for Admin **/
	
	/***Show coupons method *****/
//	coupons = ((AdminFacade) facade).getAllCoupons();
	//System.out.println("Method getAllCoupons is displaying data : " + facade.getAllCoupons());
	
	/*******************************************************************************/
	
	/****Create new Coupons ***//////This Method is Working !!/////////////**//
	
//	Coupon K01= new Coupon(700, "Super1", LocalDate.now(), LocalDate.now().plusDays(10), 650, "foods&need", "all", 800, "image");
//	Coupon K02= new Coupon(701, "Super2", LocalDate.now(), LocalDate.now().plusDays(10), 650, "foods&need", "all", 800, "image");
    Coupon K03= new Coupon(709, "Super311", LocalDate.now(), LocalDate.now().plusDays(10), 650, "foods&need", "all", 800, "image");
//
    java.sql.Date.valueOf(LocalDate.now());
	java.sql.Date.valueOf(LocalDate.now().plusDays(10));
	System.out.println("connection");
//	
//	((AdminFacade) facade).insertCoupon(K01);
//	((AdminFacade) facade).insertCoupon(K02);
   //((AdminFacade) facade).insertCoupon(K03);
	//System.out.println("New Coupons were added to the System " + K01 + K02 + K03 );
	System.out.println("New Coupons were added to the System " + K03 );
//	
	/**Display all coupons after Creating new Coupons**/
	//coupons = ((AdminFacade) facade).getAllCoupons();
	//System.out.println("Method getAllCoupons is displaying data : " + facade.getAllCoupons());
	
	
	//   }	
		      
	/************************************************************************************/	  
		      
      /******Update Coupons ******/
	//Coupon coupon = ((AdminFacade) facade).getCoupon((long) 700);	 
	//System.out.println("This method is getCoupon by ID will display Coupon Details : " + coupon);
	
}
}}
	
		
		
		
		
		
		



