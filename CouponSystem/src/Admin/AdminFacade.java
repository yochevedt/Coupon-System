package Admin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.derby.client.am.ClientTypes;
import org.apache.derby.iapi.error.PublicAPI;
import com.sun.beans.WeakCache;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import Company.*;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Customer.*;
import Customer.CustomerDBDAO;
import Database.Database;



/////////Class AdminFacade//////////////

public class AdminFacade  {
	
	/**Data members**/
    private  CompanyDBDAO companyDAO = new CompanyDBDAO();
    private CustomerDBDAO custDAO = new CustomerDBDAO();
    private CouponDBDAO couponDAO = new CouponDBDAO();
    private String name = "admin";
    private String password = "1234";
    
   
    /**CTRS (constructors)**/
    
    public AdminFacade (){
    	
    }
  
    
    /**Methods**/
    
    public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
    
     /**Login Method**/
    // public boolean Login (String name, String password, ClientTypes cType) throws Exception{
    	 public boolean Login (String name, String password) throws Exception{	
    	if (name.equals(this.name) && password.equals(this.password))  {
    		System.out.println("Welcome to the Coupon System");
    		return true;
    	}
    	System.out.println("Your login failed please try again");
    	return false;
 
      }
    
     /**CreateComany method**/
     public void CreateCompany(Company company) throws Exception {
	  
       companyDAO.CreateCompany(company);
    	     	 
	}

    
     /**Remove Company Method**/
    
     public void removeCompany(Company company) throws Exception {
 		Connection con = DriverManager.getConnection(Database.getDBURL());
 		String pre1 = "DELETE FROM Companies WHERE id=?";

 		try (PreparedStatement pstm1 = con.prepareStatement(pre1);) {
 			con.setAutoCommit(false);
 			pstm1.setLong(1, company.getId());
 			pstm1.executeUpdate();
 			con.commit();
 		} catch (SQLException e) {
 			try {
 				con.rollback();
 			} catch (SQLException e1) {
 				throw new Exception("Database error");
 			}
 			throw new Exception("failed to remove company");
 		} finally {
 			con.close();
 		}
  	}
     
    	
  //  }
    
	/**Update Company method**/
     
//     public void updateCompany(Company company) throws Exception{
//    	 
//    	 companyDAO.updateCompany(company);
//     }
     
     public void updateCompany(int id, String companyName, String password, String email) throws Exception {
 		Company company = null;
		// TODO Auto-generated method stub
 		companyDAO.updateCompany(company);
 	}

     
    /* public void updateCompany(Company company) throws Exception {
		Connection con = DriverManager.getConnection(Database.getDBURL());
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE Companies " + " SET companyName='" + company.getCompanyName() + "', password "
					+ company.getPassoword() + "', email " + company.getEmail() + "' WHERE ID=" + company.getId();
     	// Statement stm = null;
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw new Exception(" update Comapny failed");
		
	}
	}  */
     
     /**Get company method in AdminFacade
     * @throws Exception **/
     public Company getCompany(long id) throws Exception {
 		// TODO Auto-generated method stub
    	 return companyDAO.getCompany(id);
 		
 	}
     
     public Company getCompanybyPW (Company company) throws Exception {
       return companyDAO.getCompanybyPW(password);

	}
	
	  
    public Set<Company> getAllCompanies() throws Exception {
		// CompanyDBDAO comDAO=new CompanyDBDAO();
		return companyDAO.getAllCompanies();
	}

     /************Customer Methods to be applied by Admin****************/
	
        public void CreateCustomer(Customer customer) throws Exception {
            Set<Customer> allCustomers = new HashSet<Customer>();
			allCustomers = custDAO.getAllCustomers();
			Iterator<Customer> itrIterator = allCustomers.iterator();

			while (itrIterator.hasNext()) {
				Customer customer2 = new Customer();
				customer2 = itrIterator.next();
				if (customer2 instanceof Customer && customer2.getCustomerName().equals(customer.getCustomerName())) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog example");
					JOptionPane.showMessageDialog(frame, "Customer " + customer.getCustomerName() + " Already Exist");
			return;
			}
		}
	
			custDAO.createCustomer(customer);
		
	     }

        
     public void removeCustomer(Customer customer) throws Exception {

 		// Update Customer coupons in CUSTOMER_COUPON Table
 		custDAO.removeCustomerCoupons(customer);
 		// Remove Customer from CUSTOMER Table
 		custDAO.removeCustomer(customer);

 	}

 	public void updateCustomer(Customer customer) throws Exception {
 		
 		custDAO.updateCustomer(customer);
 	   }

 	
 	public Customer getCustomer(long id) throws Exception {

 		return custDAO.getCustomer(id);
 		}

 	public Set<Customer> getAllCustomers() throws Exception {

 		return custDAO.getAllCustomers();
 	}

 	/****************Coupons Methods ********************************/
 	/***Method Get all coupons **/
 	 
 		 
 		public Set<Coupon> getAllCoupons() throws Exception {
 			return couponDAO.getAllCoupons();
 			
 		}	
 		
 		
 	
 	public void insertCoupon(Coupon coupon) throws Exception {
		//String getDBURL = null;
		Connection con = DriverManager.getConnection(Database.getDBURL());
		String sql = "INSERT INTO COUPONS (ID,TITLE,START_DATE,END_DATE,AMOUNT,TYPE,MESSAGE,PRICE,IMAGE)  VALUES(?,?,?,?,?,?,?,?,?)";
		
		long timestamp = System.currentTimeMillis();
		Date date = new Date(timestamp);
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		LocalDate date2 = date.toLocalDate();
		LocalDate exparationDate= date2.plusDays(10);
		String myLocalDate = date2.toString();
		String expiredDate = exparationDate.toString();
		 
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			
		    pstmt.setLong    (1, coupon.getId());
			pstmt.setString  (2, coupon.getTitle());
	//	pstmt.setObject(3, coupon.getStartDate());
			pstmt.setString  (3, coupon.getStartDate(myLocalDate));
	//pstmt.setDate(4, coupon.getEndDate());
			pstmt.setString  (4, coupon.getEndDate(expiredDate));
			pstmt.setInt     (5, coupon.getAmount());
			pstmt.setString  (6, coupon.getType());
			pstmt.setString  (7, coupon.getMessage());
            pstmt.setDouble  (8, coupon.getPrice());
            pstmt.setString  (9, coupon.getImage());
		
			pstmt.executeUpdate();
			System.out.println("Coupon  created successfully" + coupon.toString());
		} catch (SQLException exception) {
			System.err.println(exception);
			throw new Exception("Coupon creation failed");

		} finally {
			con.close();
		}
				
	}
	 public   void RemoveCoupon (Coupon coupon) {
		 try {
			couponDAO.removeCoupon(coupon.getId());
			System.out.println("The coupon was removed: " + coupon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to remove coupon by Admin");
			e.printStackTrace();
		}
	 }
/////////////
	 /**************************************************************************************************************/
	              /*************Customers tests for Admin Facade **********************/
	 
	 /*************/
	 /**Create Customer method for AdminFacade**/
	 
	 
	 
	 /*************/
	 /**GetAll-Customers method (Customer list displayed) by Admin ***/
	 
	 
	 
	 
	 /***********/
	 /**Display specific Customer details **/

	
	 /************/
	 /*****Remove Customer and display getAllCustomer after remove Customer *******/
 	
 }
     
     
	

	



	

	
	

	
	
	 
	
   

 
	  

	   
		


		