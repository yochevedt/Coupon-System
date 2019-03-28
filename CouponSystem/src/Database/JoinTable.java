package Database;
import java.sql.*;
import java.util.jar.JarException;




public class JoinTable {
	
	public static void main(String[] args) {
		
		try {
		      Connection con = DriverManager.getConnection
		        ("jdbc:derby://localhost:3301/test;create=true"); 
		      
		      Statement stmt = con.createStatement();
		      
		       String query = null;
		      
	           query = ("CREATE TABLE CUSTOMER_COUPON " + "(PRIMARY KEY ( CUSTOMERS_ID, COUPONS_ID ), CUST_ID LONG, COUPON_ID LONG)");
			 
		      System.out.println("Created JOIN  Table - CUSTOMER_COUPON");     
		      
		        System.out.println("Done");

	  } catch(SQLException e) {
	    System.out.println("SQL exception occured" + e.toString() );
	  }
		
		try {
			Class.forName("DriverManager.ClassName");
		} catch (java.lang.ClassNotFoundException e) {
		System.out.println("ClassNotFoundException: ");
		System.out.println(e.getMessage());
		}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:3301/test;create=true");
		    Statement stmt = con.createStatement();
		    
		   
			String query = null;
			ResultSet rs = stmt.executeQuery(query);
		      System.out.println("Customer, Coupon:");
		      while (rs.next()) {
		        String supName = rs.getString(1);
		        String cofName = rs.getString(2);
		        System.out.println("    " + supName + ", " + cofName);
		      }

		      stmt.close();
		      con.close();
		
		} catch(SQLException ex) {
		      System.err.print("SQLException: ");
		      System.err.println(ex.getMessage());
		    }  
			
		}
}
