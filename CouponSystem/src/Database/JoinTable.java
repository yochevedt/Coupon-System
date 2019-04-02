
////This class is used to create the join tables, with out bringing the data///

package Database;
import java.sql.*;
import java.util.jar.JarException;




public class JoinTable {
	
	public static void main(String[] args) {
		
		try {
		      Connection con = DriverManager.getConnection
		        ("jdbc:derby://localhost:3301/test;create=true"); 
		      
		      Statement stmt = con.createStatement();
		      
		     //  String query = null;
		      
		       //stmt.executeUpdate ("CREATE TABLE CUSTOMER_COUPON (CUST_ID INT PRIMARY KEY, COUPON_ID INT)");
			     stmt.executeUpdate ("CREATE TABLE COMPANY_COUPON (COMP_ID INT PRIMARY KEY, COUPON_ID INT)");
		      
		     // System.out.println("Created JOIN  Table - CUSTOMER_COUPON"); 
			     System.out.println("Created JOIN  Table - COMPANY_COUPON");  
		      
		        System.out.println("Done");

	  } catch(SQLException e) {
	    System.out.println("SQL exception occured" + e.toString() );
	  }
			
	}
}
