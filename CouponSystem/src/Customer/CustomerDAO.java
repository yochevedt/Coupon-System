package Customer;

import java.util.Set;



public interface CustomerDAO {
	
	CustomerDBDAO custDAO = new CustomerDBDAO();
	
	void insertCustomer(Customer customer) throws Exception;

	void removeCustomer(Customer customer) throws Exception;

	static void updateCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		
	}

	Customer getCustomer(long id) throws Exception;

	Set<Customer> getAllCustomers() throws Exception;

}

