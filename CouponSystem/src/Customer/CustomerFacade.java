package Customer;

import java.util.Set;

public class CustomerFacade {
	
	private CustomerDBDAO companyDAO = new CustomerDBDAO();
	private Customer customer;

	public CustomerFacade(Customer A) {
		this.customer = A;
	}

	public CustomerFacade() {

	}

	public void insertCustomer(Customer customer) throws Exception {
		companyDAO.insertCustomer(customer);
	}

	public void removeCustomer(Customer customer) throws Exception {
		companyDAO.insertCustomer(customer);
	}

	public void updateCustomer(Customer customer, String newCustName, String newCustPassword)
			throws Exception {
		customer.setCustomerName(newCustName);
		customer.setPassword(newCustPassword);
		//CustomerDAO.updateCustomer (customer);
	}

	public Customer getCustomer() {
		return customer;
	}

	public Set<Customer> getAllCustomers() throws Exception {
		// CompanyDBDAO comDAO=new CompanyDBDAO();
		return companyDAO.getAllCustomers();
	}

}

