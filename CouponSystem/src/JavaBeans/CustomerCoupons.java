package JavaBeans;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.derby.iapi.error.PublicAPI;

import com.sun.org.apache.xpath.internal.operations.And;

import java.sql.Connection;
import Company.Company;
import Coupon.Coupon;
import Customer.Customer;
import Database.Database;

/**This class will create a Collection that will be created with an object
 * that makes the join table from Customer  and Coupons tables.
 * 
 * @author yochevedt
 *
 */

public class CustomerCoupons {
	
	private static long CouponId;
	private static long CustId;
	
	

	/**CTRs**/
	/************/
	/**Full constructor**/
	
	
	public CustomerCoupons(long CouponId, long CustId){
		SetCouponId(CouponId);
		SetCouponId(CustId);
	}
	
	public CustomerCoupons (){
	}
	
	 private void SetCouponId(long couponId2) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static long getCouponId() {
		return CouponId;
	}

	public static void setCouponId(long couponId) {
		CouponId = couponId;
	}

	public static long getCustId() {
		return CustId;
	}

	public static void setCustId(long custId) {
		CustId = custId;
	}
	
	
	CustomerCoupons customerCoupons = new CustomerCoupons(CouponId, CustId);
	
	//**This method will create a list for CustomerCoupons//
	
	

	public synchronized  Set<CustomerCoupons> getAllCustomerCoupons() throws Exception {
		Connection con = DriverManager.getConnection(Database.getDBURL());
		Set<CustomerCoupons> set = new HashSet<>();
		String sql = "SELECT CUST_ID FROM CUSTOMER_COUPON";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)){
			while (rs.next()){
				long custId = rs.getLong(1);
				long couponId = rs.getLong(1);
				//THIS CODE WAS ADDED BY ME THE ORIGINAL CODE IS IN COMPANY-COUPONS
				boolean addAll = set.addAll((Collection<? extends CustomerCoupons>) new CustomerCoupons (custId, couponId));
				
				
			}
			}catch (SQLException e) { 
				System.out.println(e);
				throw new Exception("cannot get Customer-Coupons  data");
			}finally {
				con.close();
			}
		return set;
		
	}
	
	/** 
	 *                           this method was added by me to insert the coupons since, seems that the insert is missing
	 * @param customerCoupons
	 * @return 
	 * @throws Exception
	 */
		public CustomerCoupons InsertCustomerCoupons(CustomerCoupons customerCoupons) throws Exception {
			//String getDBURL = null;
			Set <CustomerCoupons> allCustomerCoupons = new HashSet<>();
			  allCustomerCoupons = getAllCustomerCoupons();
			  Iterator<CustomerCoupons> iterator = allCustomerCoupons.iterator();
			  
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:3301/test;crete=true");
			
			PreparedStatement pstms = null;
			System.out.println("Starting to update Customer Coupons table");
			
			String sql = "INSERT INTO CUSTOMER_COUPON (CUST_ID, COUPON_ID)  VALUES(?,?,?)";
			
			try {
				while (iterator.next() != null){
					pstms.setLong(1, CustId);
					pstms.setLong(2, CouponId);
					
					pstms.executeQuery();
					System.out.println("Data added successfully!!");
				}}
				catch (SQLException e) {
					System.out.println("failed to add data to data base...");
				}
				finally {
					con.close();
				}
			return customerCoupons;
	
	}}

