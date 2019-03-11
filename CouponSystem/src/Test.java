import java.time.LocalDate;

import Company.Company;
import Company.CompanyFacade;
import Coupon.Coupon;
import Coupon.CouponFacade;
import Customer.Customer;
import Customer.CustomerFacade;

public class Test {

	public static void main(String[] args) throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		Company C1 = new Company(1, "RedBend", "red00red00", "redbend@gmail.com");
		Company C2 = new Company(2, "Apple", "apple00010", "apple@gmail.com");
		Company C3 = new Company(3, "KiriatSefer", "KW00001222", "kiriat.sefer@gmail.com");
		Company C4 = new Company(4, "test", "tests11", "ddd@gmail.com");
	    Company C7 = new Company(7, "BestJava", "jj1sam", "javaaM@gmail.com");
	    Company C8 = new Company(8, "Harman", "harhar", "harman@gmail.com");
		
		
	//	CompanyFacade companyFacade=(CompanyFacade)client;
		CompanyFacade companyFacade = new CompanyFacade();

	//companyFacade.insertCompany(C1);
	//companyFacade.insertCompany(C2);
	//companyFacade.insertCompany(C3);
	companyFacade.insertCompany(C8);

		//System.out.println(companyFacade.getAllCompanies());

//		Customer A1 = new Customer(1, "Yocheved Tochner", "YTPassword");
//		Customer A2 = new Customer(2, "Yaakov Tochner", "YTPassword");
//		Customer A3 = new Customer(3, "Avrahom Tochner", "YTPassword");
//		Customer A4 = new Customer(4, "Esther Tochner", "YTPassword");
//		
//		CustomerFacade customerFacade = new CustomerFacade();
//		
//		customerFacade.insertCustomer(A1);
//		customerFacade.insertCustomer(A2);
//		customerFacade.insertCustomer(A3);
//		customerFacade.insertCustomer(A4);
//		
//		System.out.println(customerFacade.getAllCustomers());
	}
}
