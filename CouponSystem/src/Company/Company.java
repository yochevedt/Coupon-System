package Company;

import java.util.logging.Logger;



public class Company {
	private long id;
	private String companyName;
	private String password;
	private String email;
	
	private static final Logger LOG = Logger.getLogger(Company.class.getName());


	public Company() {

	}

	public Company(long id, String companyName, String password, String email) {
		setId(id);
		setCompanyName(companyName);
		setPassword(password);
		setEmail(email);

	}
	
//	public Company (String companyName, String password, String email){
//		setId(id);
//		setCompanyName(companyName);
//		setPassword(password);
//		setEmail(email);
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassoword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
//	public String toString() {
//		return "Company [id=" + getId() + ", CompanyName=" + getCompanyName() + ", Password=" + getPassoword() + ", email=" + getEmail()
//				+ "]";
	public String toString() {
	return "Company [id=" + getId() + ", CompanyName=" + getCompanyName() + ",  Password=" + getPassoword() + ", email=" + getEmail()
				+ "]";
	}}


