
///this class is not used yet //


package Database;
import Coupon.*; 
import Coupon.Coupon;
import Customer.*;
import sun.security.action.GetBooleanAction;
import Company.*;
import java.sql.*;

import org.apache.derby.impl.tools.sysinfo.Main;
import org.apache.derby.tools.sysinfo;




public class CreateListTable {
	
	int COUPON_ID;
	int CUST_ID;
	
	public static void main (String[] args){
		return ;
	}
	

	public  void getId (Coupon coupon) throws Exception{
		
		Connection con;
		con = DriverManager.getConnection(Database.getDBURL());
		
		String sql = "INSERT INTO CUSTOMER_COUPON (COUPON_ID, CUST_ID) VALUES (?,?)";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)){
			
			 pstmt.setLong    (1, coupon.getId());
			 System.out.print(Class.class.getModifiers());
			 
			 pstmt.executeUpdate();
			 System.out.print("get id was inserted successfully"  + coupon.getId());
		
		}
		finally {
			con.close();
		}
		}
}

