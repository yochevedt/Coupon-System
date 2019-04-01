package Database;
import Coupon.*;
import Customer.*;
import Company.*;
import java.sql.*;


public class JoiningTable {

	public static void main(String[] args) {
		
		try {
			Connection con = DriverManager.getConnection
					("jdbc:derby://localhost:3301/test;create=true"); 
			
			Statement stmt = con.createStatement();
			
			String sql;
			
			
//			sql =  "INSERT INTO CUSTOMER_COUPON " + 
//					" SELECT COUPONS.ID, COUNT(CUSTOMERS.ID) "
//					+  "FROM CUSTOMERS " 
//					//+  "INNER JOIN CUSTOMERS ON COUPONS.ID=CUSTOMERS.ID "
//					+  "INNER JOIN COUPONS ON CUSTOMERS.ID=CUSTOMER_COUPON.CUST_ID"
//					+  "GROUP BY CUSTOMERS.ID ";
					
			sql =  "INSERT INTO CUSTOMERS_COUPON (COUPON_ID, CUST_ID)" + 
			        "VALUES ((SELECT ID FROM CUSTOMERS), (SELECT ID FROM COUPONS))  ";
					
			       
			
			
			System.out.println("The insert date succeed"); }
			//System.out.print(query);
		
		catch (Exception e) {
			System.out.print("Exception, the insert data action failed !!!");
			// TODO: handle exception
		}
		}
		}
		
	
	


