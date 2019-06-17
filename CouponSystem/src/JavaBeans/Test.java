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

			   String CREATE_COUPON = "INSERT INTO COMPANY_COUPON (COMP_ID, COUPON_ID) VALUES (?,?)";

			   try (PreparedStatement pstmt = con.prepareStatement(CREATE_COUPON)) {
				   pstmt.setLong(1, companyID);
				   pstmt.setLong(2, couponID);
				   pstmt.executeUpdate();
			 
			 } catch (SQLException e) {
			  throw new Exception("Linking company to the coupon is failed. ", e);
			  } finally {
			      con.close();
			    }
		// TODO Auto-generated method stub

	}

}
