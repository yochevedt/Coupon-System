package JavaBeans;
import Customer.*;
import Database.Database;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Coupon.*;

   public class purchaseCustomerCoupon {
     
	   Connection con;
	   long idPK = 0;
	
	/**Method**/
       public void purchaseCoupon(Coupon coupon, Customer customer) throws Exception {

    	 con = DriverManager.getConnection(Database.getDBURL()); 
    	 long idPK = 0;
    	 
	    String sql1 = "SELECT * FROM COUPON";
        String sql2 = " INSERT INTO CUSTOMER_COUPON(CUST_ID,COUPON_ID) VALUES(?,?)";

	    // Set the results from the database
       PreparedStatement pstmt = null;
       java.sql.Statement stmt = null;

	try {

		// Insert the new coupon to join table CUSTOMER_COUPON
           stmt = con.createStatement();
           ResultSet resultSet = stmt.executeQuery(sql1);

		while (resultSet.next()) {
                   //this if will verify if the data in the resultSet that executed the query Select *
			         //is displayed in the (2) column in the Customer_Coupon table
			if (coupon.getTitle().equals(resultSet.getString(2))) {

				// System.out.println(resultSet.getLong(1));
				idPK = resultSet.getLong(1);
				System.out.println(idPK);

			}

		pstmt = con.prepareStatement(sql2);
		pstmt.setLong(1, 1);
		pstmt.setLong(2, idPK);
		pstmt.executeUpdate();
		// System.out.println("idpk" + idPK);
		}}
	     catch (SQLException e) {

		// Handle errors for JDBC

		throw new Exception("Purchased Coupon failed");

	} finally {

		// finally block used to close resources

	}

	    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
    	JOptionPane.showMessageDialog(frame, "Inserted coupon " + coupon.getTitle() + " successfully");
       }
}