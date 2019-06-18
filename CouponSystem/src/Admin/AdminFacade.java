package Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.derby.client.am.ClientTypes;
import org.apache.derby.iapi.error.PublicAPI;
import com.sun.beans.WeakCache;

import Company.*;
import Customer.*;
import Customer.CustomerDBDAO;
import Database.Database;



/////////Class AdminFacade//////////////

public class AdminFacade  {
	
	/**Data members**/
    private  CompanyDBDAO companyDAO = new CompanyDBDAO();
    private CustomerDBDAO custDAO = new CustomerDBDAO();
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
     public boolean Login (String name, String password, ClientTypes cType) throws Exception{
    	
    	if (name.equals(this.name) && password.equals(this.password))  {
    		return true;
    	}
    	return false;
      }
    
     /**CreateComany method**/
     public void CreateCompany(Company company) throws Exception {
	  Set<Company> allCompanies = new HashSet<Company>();
		allCompanies = companyDAO.getAllCompanies();
			
	  Iterator<Company> iterator = allCompanies.iterator();
	  
	  while (iterator.hasNext()) {
		  Company company2 = new Company();
		  company2 = iterator.next();
		  if  (company2 instanceof Company && company2.getCompanyName().equals(company.getCompanyName()))
				  {
				// verify if Company   exist (with compare) and if already exist
				
				JFrame frame = new JFrame("JOptionPane -Checking data");
				JOptionPane.showMessageDialog(frame, "the Company" + company.getCompanyName()+ "Already Exist");
				return;

			}

		}
		companyDAO.createCompany(company);
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		JOptionPane.showMessageDialog(frame, "Company " + company.getCompanyName() + " Created");
	}

    /**Remove Company Method**/
    public void removeCompany(Company company) throws Exception {
    	//this method will update the JoinTable Company_Coupon and remove the company coupons at first.
    	companyDAO.removeCompanyCoupons(company);
    	// remove the company
    	companyDAO.removeCompany(company);
    }
    
	public void updateCompany(Company company) throws Exception {
		Connection con = DriverManager.getConnection(Database.getDBURL());
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE Companies " + " SET companyName='" + company.getCompanyName() + "', password "
					+ company.getPassoword() + "', email " + company.getEmail() + "' WHERE ID=" + company.getId();
     	// Statement stm = null;
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw new Exception(" update Comapny failed");
		
	}
	}
      public Company getCompanybyPW (Company company) throws Exception {

	   return companyDAO.getCompanybyPW(password);

	}
	
	public Set<Company> getAllCompanies() throws Exception {
		// CompanyDBDAO comDAO=new CompanyDBDAO();
		return companyDAO.getAllCompanies();
	}

	
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
			
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		JOptionPane.showMessageDialog(frame, "Customer " + customer.getCustomerName() + "Created");
		
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

 }
     
     
	

	



	

	
	

	
	
	 
	
   

 
	  

	   
		


		