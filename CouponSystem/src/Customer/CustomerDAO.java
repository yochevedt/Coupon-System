package Customer;

import java.util.Set;



public interface CustomerDAO {
	
	CustomerDBDAO custDAO = new CustomerDBDAO();
	
	void insertCustomer(Customer customer) throws Exception;

	void removeCustomer(Customer customer) throws Exception;
	
	void removeCustomerbyId(Customer customer) throws Exception;

	Customer getCustomer(long id) throws Exception;

	Set<Customer> getAllCustomers() throws Exception;

	void updateCustomer(Customer customer) throws Exception;

}

