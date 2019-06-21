package Company;

import java.util.Set;

public interface CompanyDAO {
	
	CompanyDBDAO companyDAO = new CompanyDBDAO();

	//void insertCompany(Company company) throws Exception;

	void removeCompany(Company company) throws Exception;

	void updateCompany(Company company) throws Exception;

	Company getCompany(long id) throws Exception;

	Set<Company> getAllCompanies() throws Exception;

	void CreateCompany(Company company) throws Exception;
	

}
