package JavaBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database.Database;

public class Test {

		
		public void linkCompanyCoupon(long companyID, long couponID) throws Exception {

			   Connection con = DriverManager.getConnection(Database.getDBURL()); 
			   con = DriverManager.getConnection(Database.getDBURL()); 
			   System.out.println("connection failed");
			   String CREATE_COUPON = "INSERT INTO COMPANY_COUPON (COMP_ID, COUPON_ID) VALUES (?,?)";
               System.out.println("test1");
			   try (PreparedStatement pstmt = con.prepareStatement(CREATE_COUPON)) {
				   pstmt.setLong(1, companyID);
				   pstmt.setLong(2, couponID);
				   pstmt.executeUpdate();
			 System.out.println("yes");
			
			   } catch (SQLException e) {
			  throw new Exception("Linking company to the coupon is failed. ", e);
			  } finally {
			      con.close();
			      System.out.print("close connection");
			    }
		// TODO Auto-generated method stub

	}

}
