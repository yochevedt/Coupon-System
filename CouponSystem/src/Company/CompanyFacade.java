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
		companyDAO.createCompany(company);
	}

	public void removeCompany(Company company) throws Exception {
		companyDAO.removeCompany(company);
	}

	public void updateCompany(Company company, String newCompName, String newPassword, String newEmail)
			throws Exception {
		company.setCompanyName(newCompName);
		company.setPassword(newPassword);
		companyDAO.updateCompany(company);
	}

	public Company getCompany() {
		return company;
	}

	public Set<Company> getAllCompanies() throws Exception {
		//CompanyDBDAO comDAO=new CompanyDBDAO();
		//return comDAO.getAllCompanies();
		return companyDAO.getAllCompanies();
		
	}

}
