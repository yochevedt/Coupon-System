package Company;


import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Database.Database;

public  class CompanyDBDAO implements CompanyDAO {
	Connection con;
	
	
		public void CreateCompany(Company company) throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());                    //(?,?,?,?);//
		String sql = "INSERT INTO Companies (id,companyName,password,email)  VALUES(?,?,?,?)";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setLong (1, company.getId());
			pstmt.setString(2,company.getCompanyName());
			pstmt.setString(3,company.getPassoword());
			pstmt.setString(4,company.getEmail());
			
			
			pstmt.executeUpdate();
			System.out.println("Company created" + company.toString());
		} catch (SQLException exception) {
			System.err.println(exception);
			throw new Exception("Company creation failed");
		} finally {
			con.close();
		}
	}

	@Override
	public void removeCompany(Company company) throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
		String pre1 = "DELETE FROM Companies WHERE id=?";

		try (PreparedStatement pstm1 = con.prepareStatement(pre1);) {
			con.setAutoCommit(false);
			pstm1.setLong(1, company.getId());
			pstm1.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new Exception("Database error");
			}
			throw new Exception("failed to remove company");
		} finally {
			con.close();
		}

	}

	/**Update company method**/
	
	@Override
	public void updateCompany(Company company) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:derby://localhost:3301/test;crete=true");
	
		try {
			String sql = "update Companies set COMPANYNAME= ?,PASSWORD = ?, EMAIL= ? where ID = ?";
			PreparedStatement stm1 = con.prepareStatement(sql);
			System.out.println("Database exception " + sql );
			stm1.setString(1, company.getCompanyName());
			stm1.setString(2, company.getPassoword());
			stm1.setString(3, company.getPassoword());
			stm1.setLong(4, company.getId());
			stm1.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("update company failed " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new Exception("connection close failed " + e.getMessage());
			}
		}
	
		
		
//		try (Statement stmt = con.createStatement()) {
//			String sql =
//		"UPDATE Companies " 
//		+ "SET companyName =  '?,  company.getCompanyName()'" 
//		+ "password =  '?,   company.getPassoword()'"
//		+ "email =  '?,  company.getEmail()'"
//		+ "WHERE ID =  '? company.getId()'";
//			
//			//stmt = null;
//			stmt.executeQuery(sql);
//		      PreparedStatement stmt1 = (PreparedStatement) stmt;
//		    	stmt1 = con.prepareStatement(sql);
//		    	//((PreparedStatement) stmt).setLong (1,company.getId());
//		    	((PreparedStatement) stmt1).setLong (1,company.getId());
//		        ((PreparedStatement) stmt1).setString(2,company.getCompanyName());
//				((PreparedStatement) stmt1).setString(3,company.getPassoword());
//				((PreparedStatement) stmt1).setString(4,company.getEmail());
//	
	}

	
	/******************************************************************************
	 * get company by id
	 ******************************************************************************/
	
	@Override
	public Company getCompany(long id) throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
		//Company company = new Company();
		Company company = null;
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM COMPANIES WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
            company.setId(rs.getLong(1));
			company.setCompanyName(rs.getString(2));
			company.setPassword(rs.getString(3));
			company.setEmail(rs.getString(4));

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause()+" "+e.getStackTrace());
			throw new Exception("Unable to get data");
		} finally {
			con.close();
		}
		return company;
	}
	
	@Override
	public synchronized Set<Company> getAllCompanies() throws Exception {
	//	con = DriverManager.getConnection(Database.getDBURL());
		Connection con = DriverManager.getConnection("jdbc:derby://localhost:3301/test;crete=true");
		Set<Company> set = new HashSet<>();
		String sql = "SELECT * FROM Companies";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				long id = rs.getLong(1);
				String companyName = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);

				set.add(new Company(id, companyName, password, email));
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get Company data");
		} finally {
			con.close();
		}

		return set;
	}

       public void createCompany(Company company) throws Exception {
		//TODO
		//connect to db.
		//Create an object that will call the method to "insert company"
		
		con = DriverManager.getConnection(Database.getDBURL());  
		
		companyDAO.CreateCompany(company);
		System.out.println("AdminUser: Company created successfully");
		    
}
	   public void removeCompanyCoupons(Company company) {
		////////////////////////////////////not finish//////////////
		//TODO:
		//first connect to db.
		//Create a method that will check the list in Company_Coupons table
		//the join table will be  displayed  as a list
		//bring the list of the Compnay_Coupons table and 
		//need to create a while loop, that checks if Company  id  exist or not in Company table
		//if not exist remove all the coupons that has Company id in the same row.
		//if exist do nothing.
		
//		   
//		   con = DriverManager.getConnection(Database.getDBURL());
//		Set<Company> allCompanies = new HashSet<>();
//         allCompanies = companyDAO.getAllCompanies();
//		 Iterator<Company> iterator = allCompanies.iterator();
//			
//			while (iterator.hasNext()) {
//				Company company3 = new Company();
//				company3 = iterator.next();
//				
//				if  (company3 instanceof Company && company3.getCompanyName().equals(company.getCompanyName()))
//				  {
//				// verify if Company   exist (with compare) and if already exist
//				
//				JFrame frame = new JFrame("JOptionPane -Checking data");
//				JOptionPane.showMessageDialog(frame, "the Company" + company.getCompanyName()+ "Already Exist");
//				return;
//
//			}
//
//		   }
//		       companyDAO.insertCompany(company);
//		       
//	       }
//
//			
		/////////////////////////not finish////////////////
		   
		   
		   
		   


		   
		   
	   }

	public Company getCompanybyPW(String password) {
		// TODO Auto-generated method stub
		//this method will get all the companies and check if the password exist or not
		//make a while loop, where if password belongs  to Company - company name, return an object company
		//if password is incorrect exit give error message.
		
		
		return null;
	}

	public void removeCompany(long id) {
		// TODO Auto-generated method stub
		try {
			companyDAO.removeCompany(getCompany(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}