package Coupon;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

import Company.Company;
import Company.CompanyDAO;
import Company.CompanyDBDAO;
import Enums.CouponType;




public interface CouponDAO {

	
	CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	CompanyDAO companyDAO = new CompanyDAO() {
		
		@Override
		public void updateCompany(Company company) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void removeCompany(Company company) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Company getCompany(long id) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Set<Company> getAllCompanies() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void CreateCompany(Company company) throws Exception {
			// TODO Auto-generated method stub
			
		}
	};

public void createCoupon(Coupon coupon) throws SQLException;

public void removeCoupon(Coupon coupon) throws SQLException;

public void updateCoupon(Coupon coupon) throws SQLException;

public Coupon getCoupon(long id) throws SQLException;

public Collection<Coupon> getAllCoupons() throws SQLException;

public Collection<Coupon> getCompanyCoupons(long companyId) throws SQLException;

public Collection<Coupon> getCouponByType(CouponType couponType) throws SQLException;

void removeCompanyCoupon(long couponId) throws SQLException;

void removeCustomerCoupon(long couponId) throws SQLException;

public void removeExpiredCoupon() throws SQLException;

}