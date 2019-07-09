package JavaBeans;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.sql.Connection;
import Company.Company;
import Coupon.Coupon;
import Database.Database;

/**This class will create a Collection that will be created with an object
 * that makes the join table from Company and Coupons tables.
 * 
 * @author yochevedt
 *
 */
  public class CompanyCoupons {
	private static long CompId;
	private static long CouponId;
	//CompanyCoupons Compcoup = new CompanyCoupons();
	 CompanyCoupons Compcoup = new CompanyCoupons(CompId, CouponId);
	
	/**CTRs**/
	
	/************/
	/**Full constructor**/
	public CompanyCoupons(long CompId, long CouponId){
		setCompId(CompId);
		setCouponId(CouponId);
	}
		
	
	/*****************/
	/**Methods**/
		
	public long getId(Company company) {
		return CompId;
	}

	public static void setCompId(long compId) {
		CompId = compId; 
	}

	public long getId(Coupon coupon) {
		return CouponId;
	}

	public static void setCouponId(long couponId) {
		CouponId = couponId;
	}
	
	//**This method will create a list for Compcoup//
	public Set<CompanyCoupons> getAllCompanies() throws Exception {
         return Compcoup.getAllCompanyCoupons();
	}
	
	public synchronized  Set<CompanyCoupons> getAllCompanyCoupons() throws Exception {
		Connection con = DriverManager.getConnection(Database.getDBURL());
		Set<CompanyCoupons> set = new HashSet<>();
		String sql = "SELECT COMP_ID FROM COMPANY_COUPON";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)){
			while (rs.next()){
				long compId = rs.getLong(1);
				long couponId = rs.getLong(1);
				
				set.add(new CompanyCoupons (compId, couponId));
			}
			}catch (SQLException e) { 
				System.out.println(e);
				throw new Exception("cannot get CompanyCoupons  data");
			}finally {
				con.close();
			}
		return set;
	
	
	}}

