package Company;

import java.util.Set;

public class CompanyFacade {

	private CompanyDBDAO companyDAO = new CompanyDBDAO();
	private Company company;

	public CompanyFacade(Company C) {
		this.company = C;
	}

	public CompanyFacade() {

	}

	public void insertCompany(Company company) throws Exception {
		companyDAO.insertCompany(company);
	}

	public void removeComany(Company company) throws Exception {
		companyDAO.insertCompany(company);
	}

	public void updateComapny(Company company, String newCompName, String newPassword, String newEmail)
			throws Exception {
		company.setCompanyName(newCompName);
		company.setPassword(newPassword);
		companyDAO.updateCompany(company);
	}

	public Company getCompany() {
		return company;
	}

	public Set<Company> getAllCompanies() throws Exception {
		// CompanyDBDAO comDAO=new CompanyDBDAO();
		return companyDAO.getAllCompanies();
		
	}

}
