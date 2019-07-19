package Admin;
import Coupon.Coupon;
import Coupon.CouponDAO;
import Coupon.*;
import java.sql.SQLException;



public class DailyCleaningTask  {

	private boolean active = true;
	private CouponDBDAO couponDBDAO = new CouponDBDAO();

	public DailyCleaningTask() {
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void run() throws SQLException {
		while (active) {
			try {
				couponDBDAO.removeExpiredCoupon();
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				System.out.println("Error encountered while attempting to run daily task");
			}
		}

	}

}