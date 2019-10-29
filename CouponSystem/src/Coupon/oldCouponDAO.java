package Coupon;

import java.util.Set;

public interface oldCouponDAO {
	
	
	
	CouponDBDAO couponDAO = new CouponDBDAO();

	CouponFacade couponFacade  = new CouponFacade();

	void insertCoupon(Coupon coupon) throws Exception;

    void removeCoupon (Coupon coupon) throws Exception;
    
   

    static void updateCoupon(Coupon coupon) throws Exception {
			
		}

		 Coupon getCoupon(long id) throws Exception;

		Set<Coupon> getAllCoupons() throws Exception;

		void removeExpiredCoupon();

}
