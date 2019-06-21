import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import Coupon.Coupon;
import Coupon.CouponFacade;

public class TestCoupons {

	public static void main(String[] args) throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver");

	try {
	//Coupon K1 = new Coupon(123, "fff", LocalDate.now(), LocalDate.now().plusDays(7), 1000, "food", "good food", 500, "C/pu");
	//Coupon K5 = new Coupon(753, "coupon001", LocalDate.now(), LocalDate.now().plusDays(10), 950, "food555", "best coupon002", 800, "image");
	//Coupon K17 = new Coupon(201, "Super114", LocalDate.now(), LocalDate.now().plusDays(10), 650, "foods&need", "all", 800, "image");
	//Coupon K13 = new Coupon(914, "Super2", LocalDate.now(), LocalDate.now().plusDays(10), 650, "foods&need", "all", 800, "image");
   Coupon K15= new Coupon(916, "Super3", LocalDate.now(), LocalDate.now().plusDays(10), 650, "foods&need", "all", 800, "image");

	
    java.sql.Date.valueOf(LocalDate.now());
	java.sql.Date.valueOf(LocalDate.now().plusDays(10));
	System.out.println("connection");
//	
	
	CouponFacade couponFacade  = new CouponFacade();
	System.out.println(couponFacade.getAllCoupons());
//		
 // couponFacade.insertCoupon(K1);
    // couponFacade.insertCoupon(K5);
    // couponFacade.insertCoupon(K7);
     //couponFacade.insertCoupon(K17);
  //   couponFacade.insertCoupon(K13);
    couponFacade.insertCoupon(K15);
   
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Failed to add coupons");
	}
	
	
	
	//System.out.println(CouponFacade.getAllCoupons());
	
		
		
	}

	
}
