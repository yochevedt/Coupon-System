package Company;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import Database.Database;
import sun.security.action.GetBooleanAction;

public class CompanyTest {

	public static void main(String[] args) throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = DriverManager.getConnection(Database.getDBURL());
		Database.createTables(con);

//		Company C1 = new Company(123, "RedBend", "red00red00", "email");
//		Company C2 = new Company(124, "Apple", "apple00010", "email");
//		Company C3 = new Company(125, "KiriatSefer", "KW00001222", "email");
	Company C9 = new Company(292, "test222", "tests11", "email@ff.com");
		//Company C16 = new Company(92, "NewCompany11", "4rrr54333331", "NewCampaingCompany");
		
		
		//CompanyFacade companyFacade=(CompanyFacade)client;
		CompanyFacade companyFacade = new CompanyFacade();
		

//		companyFacade.insertCompany(C1);
//		companyFacade.insertCompany(C2);
//		companyFacade.insertCompany(C3);
         companyFacade.insertCompany(C9);
		//companyFacade.insertCompany(C16);

		System.out.println(companyFacade.getAllCompanies());

	}

}
