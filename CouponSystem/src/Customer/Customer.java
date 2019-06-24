package Customer;

import java.util.Set;

public class Customer {
	private long id;
	private String customerName;
	private String password;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	
	public Customer (long id, String customerName, String password){
	setId(id);
	setCustomerName(customerName);
	setPassword(password);
	}


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	


	@Override
	public String toString() {
		return "Customer [getCustomerName()=" + getCustomerName() + ", getPassword()=" + getPassword() + ", getId()="
				+ getId() + "]";
	}



	

	
	
	
}
