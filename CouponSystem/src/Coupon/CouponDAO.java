package Coupon;

import java.util.Set;

public interface CouponDAO {
	
	CouponDBDAO couponDBDAO = new CouponDBDAO();
	
	void insertCoupon(Coupon coupon) throws Exception;

    void removeCoupon (Coupon coupon) throws Exception;

    static void updateCoupon(Coupon coupon) throws Exception {
			
		}

		Coupon getCoupon(long id) throws Exception;

		Set<Coupon> getAllCoupons() throws Exception;

}
