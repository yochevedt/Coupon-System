
import Database.User;
import Login.Login;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.sun.org.apache.xpath.internal.operations.Equals;

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
		facade.login("admin", "1234");
		   
		      if (facade instanceof AdminFacade) {
                    System.out.println("========  Login(admin, 1234, AdminFacade) ========\n");
        
      /******************************************************************/              
      /** Create new 2 companies*/
                  //Template//
                  // Company C3 = new Company(033, "RedBend4", "red00red00", "harman@gmail.com");
              //  Company C2 = new Company(88, "HTest77", "harhar", "harman@gmail.com");
                   
           //    ((AdminFacade) facade).CreateCompany(C2);
		       //  ((AdminFacade) facade).CreateCompany(C2);
	
   /****Show All companies method (working) *******************/
                    
     // Show all companies (After creating new companies - before update).
	  companies = ((AdminFacade) facade).getAllCompanies();
	//  System.out.println("After creating new companies - Show all new companies\n" + line + companies.toString());
	//  System.out.println("List of companies is : " + facade.getAllCompanies());	            
	/********************************************************************/			
		/**Update Company Test -- (not working yet)**/
	//((AdminFacade) facade).updateCompany(63, "RedBEND4", "red00red00", "harman@gmail.com");
		
	/********************************************************************/
	 
	// Show One updated company id=5
	/**Display company details according to id (method is working)**/
	 // Company company1 = ((AdminFacade) facade).getCompany(88);
	// ((AdminFacade) facade).getCompany(88);
	
//	System.out.println("Display company details - according to company id : " + company1.toString());
		      
	/********************************************************************/
	
	/********Remove Company method*  (not working yet this method ) ********************/
	//Company company1 = ((AdminFacade) facade).getCompany(88);
	//System.out.println(company1);
	//Company company = ((AdminFacade) facade).removeCompany(company1);
	//System.out.println("the company" + company1 + "was removed successfully");
	
	
	/**********************************************************************************/
	//
	//
	/**********************************************************************************/
	               /**Coupons Tests for Admin **/
	
	/***Show coupons method *****/
     // coupons = ((AdminFacade) facade).getAllCoupons();
  	// System.out.println("Method getAllCoupons is displaying data : " + facade.getAllCoupons());
	
	/*******************************************************************************/
	
	/****Create new Coupons ***//////This Method is Working !!/////////////**//
	
     //Coupon K01= new Coupon(1000, "Super1000", LocalDate.now(), LocalDate.now().plusDays(10), 650, "foods&need", "all", 800, "image");
//	  Coupon K02= new Coupon(701, "Super2", LocalDate.now(), LocalDate.now().plusDays(10), 650, "foods&need", "all", 800, "image");
  //  Coupon K03= new Coupon(714, "Super12340", LocalDate.now(), LocalDate.now().plusDays(10), 650, "foods&need", "all", 800, "image");
//
      java.sql.Date.valueOf(LocalDate.now());
      java.sql.Date.valueOf(LocalDate.now().plusDays(10));
	  System.out.println("connection");
	
	//((AdminFacade) facade).insertCoupon(K01);
//	((AdminFacade) facade).insertCoupon(K02);
    //((AdminFacade) facade).insertCoupon(K03);
	//System.out.println("New Coupons were added to the System " + K01 + K02 + K03 );
	//System.out.println("New Coupons were added to the System " + K01 );
//	
	/**Display all coupons after Creating new Coupons**/
	coupons = ((AdminFacade) facade).getAllCoupons();
	System.out.println("All coupons : " + facade.getAllCoupons());
	
	
	/**getAllCoupons method is not working - there is a problem when getting the data from the db **/
	
	 // coupons =  ((AdminFacade) facade).getAllCoupons();
	  //System.out.println("Method getAllCoupons is displaying data : " + facade.getAllCoupons());
	
	
	//   }	
		      
	/************************************************************************************/	  
		      
      /******Update Coupons ******Not working yet need to fix the getAllCoupons*/
	//Coupon coupon = ((AdminFacade) facade).getCoupon(700);	
	//System.out.println("The coupon with id is : " + coupon.getId());
	//System.out.println("This method is getCoupon by ID will display Coupon Details : " + coupon);
	
	//Coupon K03 = null;
	/*************************/
	/****Remove coupons method **/
	//Need to be added this method//
	
	//((AdminFacade) facade).RemoveCoupon(K03);
	
}
		      
		      /**************************************************************************************************************/
              /*************Customers tests for Admin Facade **********************/
 
 /*************/
 /**Create Customer method for AdminFacade**/
		      
		      /**this method is working**/
		      
	         // Customer A1 = new Customer(10, "Yaakov Levyyy", "YTPassword1");
//		      Customer A2 = new Customer(6, "Abrahom Russek", "YTPassword2");
//		      Customer A3 = new Customer(7, "Liba Corazon", "YTPassword3");
//		      Customer A4 = new Customer(8, "Biby Cohen", "YTPassword4");
// 
  //   ((AdminFacade) facade).CreateCustomer(A1);
//	((AdminFacade) facade).CreateCustomer(A2);
//	((AdminFacade) facade).CreateCustomer(A3);
//	((AdminFacade) facade).CreateCustomer(A4);
 
 
 /*************/
 /**GetAll-Customers method (Customer list displayed) by Admin *this method is working ***/
 
 /**Display all the Customer list**
  * getAllCustomer method
  */
 
      //((AdminFacade) facade).getAllCustomers();
      //System.out.println("list customers succeed" + facade.getAllCustomers());
	//((AdminFacade) facade).PrintCustumerlist();
	//System.out.println("Method get.AllCustomers is working /n "
		//	+ "the list customer is : " + facade.getAllCustomers());
	
 /***********/
 /**Display specific Customer details **/  /**this method is working**/
    //((AdminFacade) facade).getCustomer(10);
   //  System.out.println("Details custermer  with id : " + facade.getCustomer(10));

 /***********/
     /**Update specific customer ***///this method is not working - failing in sql command
       
//  Customer customer = ((AdminFacade)facade).getCustomer(10);
//  ((AdminFacade)facade).updateCustomer(customer);
//  System.out.println("updated customer is : " + customer);
//  
//  System.out.println("Method get.AllCustomers is working /n "
//    	+ "the list customer is : " + facade.getAllCustomers());
//     
//     

 /************/
 /*****Remove Customer and display getAllCustomer after remove Customer *******/
		      //this method is running, but the customer is not removed from the db
	 
	//((AdminFacade) facade).removeCustomer(id, CustomerName, Password);
    Customer customer = ((AdminFacade)facade).getCustomer(7);
    ((AdminFacade)facade).removeCustomer(customer);
   // ((AdminFacade) facade).removeCustomer(7, "", "");
     System.out.println("Method remove customer was triggered  " );
    
	 
}}
	
		
		
		
		
		
		



