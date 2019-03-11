package Coupon;

import java.time.LocalDate;
import java.util.Set;


import Coupon.Coupon;
import Coupon.CouponDBDAO;


public class CouponFacade {
	
	private CouponDBDAO couponDAO = new CouponDBDAO();
	private Coupon coupon;

	public CouponFacade(Coupon K) {
		this.coupon = K;
	}

	public CouponFacade() {

	}
 
	public void insertCoupon(Coupon coupon) throws Exception {
		couponDAO.insertCoupon(coupon);
		
		System.out.println("the inserted coupons are" + getAllCoupons());
	}

	public void removeCoupon(Coupon coupon) throws Exception {
		couponDAO.insertCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon, String newTitle, LocalDate newStartDate, LocalDate newEndDate, 
			Integer newAmount, String newType, String newMessage, Double newPrice, String newImage)
			throws Exception {
		coupon.setTitle(newTitle);
		coupon.setStartDate(newStartDate);
		coupon.setEndDate(newEndDate);
		coupon.setAmount(newAmount);
		coupon.setType(newType);
		coupon.setMessage(newMessage);
		coupon.setPrice(newPrice);
		coupon.setImage(newImage);
		
		System.out.println("Updated Coupons" +newTitle + newStartDate + newEndDate + newAmount + newType + 
				newMessage + newPrice + newImage);
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public Set<Coupon> getAllCoupons() throws Exception {
		// CompanyDBDAO comDAO=new CompanyDBDAO();
		return couponDAO.getAllCoupons();
		
	}

}

