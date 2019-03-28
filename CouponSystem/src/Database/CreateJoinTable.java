package Database;
import Company.*;
import Customer.*;
import Coupon.*;
import java.sql.*;
import java.util.jar.JarException;

public class CreateJoinTable {
	
	public static void main(String[] args) {

		
		try {
			
			String query;
			
			query = "SELECT CUSTOMERS.ID, COUPONS.ID "
					+  "FROM CUSTOMERS " 
					+  "LEFT JOIN  COUPONS ON CUSTOMERS.ID = COUPONS.CUSTOMER.ID "
					+  "ORDER BY CUSTOMERS.ID";
					
			System.out.println("The table succeed");
			System.out.print(query);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}}

				      
				      
			