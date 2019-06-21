
import Database.User;
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
                
      // Create new 2 companies.
                  //Template//
                  // Company C3 = new Company(033, "RedBend4", "red00red00", "harman@gmail.com");
                  Company C2 = new Company(014, "HTest2", "harhar", "harman@gmail.com");
                   
                 //   ((AdminFacade) facade).CreateCompany(C3);
		         ((AdminFacade) facade).CreateCompany(C2);
		          
     // Show all companies (After creating new companies - before update).
					companies = ((AdminFacade) facade).getAllCompanies();
					System.out.println("After creating new companies - Show all new companies\n" + line + companies.toString());
		            
				   // ((AdminFacade) facade).updateCompany(63, "RedBEND4", "red00red00", "harman@gmail.com");
					// Company C3 = new Company(033, "RedBend4", "red00red00", "harman@gmail.com");
	
		            
		
	
}
}}
	
		
		
		
		
		
		



