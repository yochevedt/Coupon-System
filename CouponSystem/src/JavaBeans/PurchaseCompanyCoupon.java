package JavaBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Coupon.Coupon;
import Customer.Customer;
import Database.Database;

public class PurchaseCompanyCoupon {
	
	   Connection con;
	   long idPKC = 0;
	
	/**Method**/
       public void purchaseCoupon(Coupon coupon, Customer customer) throws Exception {

    	 con = DriverManager.getConnection(Database.getDBURL()); 
    	 long idPKC = 0;
    	 
	    String sql1 = "SELECT * FROM COUPON";
        String sql2 = " INSERT INTO COMPANY_COUPON(COMP_ID,COUPON_ID) VALUES(?,?)";

	    // Set the results from the database
       PreparedStatement pstmt = null;
       java.sql.Statement stmt = null;

	try {

		// Insert the new coupon to join table COMPANY_COUPON
           stmt = con.createStatement();
           ResultSet resultSet = stmt.executeQuery(sql1);

		while (resultSet.next()) {
                   //this if will verify if the data in the resultSet that executed the query Select *
			         //is displayed in the (2) column in the Customer_Coupon table
			if (coupon.getTitle().equals(resultSet.getString(2))) {

				// System.out.println(resultSet.getLong(1));
				idPKC = resultSet.getLong(1);
				System.out.println(idPKC);

			}

		pstmt = con.prepareStatement(sql2);
		pstmt.setLong(1, 1);
		pstmt.setLong(2, idPKC);
		pstmt.executeUpdate();
		
		}}
	     catch (SQLException e) {

		// Handle errors for JDBC

		throw new Exception("Purchased Coupon failed");

	} finally {

		// finally block used to close resources

	}

	    System.out.println("Insert Coupon successfully");
       }

}
