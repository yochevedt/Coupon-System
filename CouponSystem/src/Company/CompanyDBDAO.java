package Company;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Database.Database;

public class CompanyDBDAO implements CompanyDAO {
	Connection con;
	private  CompanyDBDAO companyDAO = new CompanyDBDAO();

	@Override
	public void insertCompany(Company company) throws Exception {
		//String getDBURL = null;
		con = DriverManager.getConnection(Database.getDBURL());                    //(?,?,?,?);//
		String sql = "INSERT INTO Companies (id,companyName,password,email)  VALUES(?,?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {

//		    pstmt.setLong(1,company.getId());
//			pstmt.setString(2,company.getCompanyName());
//			pstmt.setString(3,company.getPassoword());
//			pstmt.setString(4,company.getEmail());

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

	@Override
	public void updateCompany(Company company) throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE Companies " + " SET companyName='" + company.getCompanyName() + "', password "
					+ company.getPassoword() + "', email " + company.getEmail() + "' WHERE ID=" + company.getId();

			// Statement stm = null;
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw new Exception(" update Comapny failed");
		}
	}

	@Override
	public Company getCompany(long id) throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
		Company company = new Company();
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM COMPANIES WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			company.setId(rs.getLong(1));
			company.setCompanyName(rs.getString(2));
			company.setPassword(rs.getString(3));
			company.setEmail(rs.getString(4));

		} catch (SQLException e) {
			throw new Exception("Unable to get data");
		} finally {
			con.close();
		}
		return company;
	}
	@SuppressWarnings("unused")
	@Override
	public synchronized Set<Company> getAllCompanies() throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
		Set<Company> set = new HashSet<>();
		String sql = "SELECT id FROM Companies";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				long id = rs.getLong(1);
				String companyName = rs.getString(1);
				String password = rs.getString(1);
				String email = rs.getString(1);

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
		//check if company exist - bring AllCompanies
		//make a loop while and if the company exist exit, if not exist insert method.
		//add System prints to exit and System prints to added company
		con = DriverManager.getConnection(Database.getDBURL());
		Set<Company> allCompanies = new HashSet<>();
		allCompanies = companyDAO.getAllCompanies();
		
		Iterator<Company> iterator = allCompanies.iterator();
		
		while (iterator.hasNext()) {
			Company company2 = new Company();
			company2 = iterator.next();
			
			if  (company2 instanceof Company && company2.getCompanyName().equals(company.getCompanyName()))
			  {
			// verify if Company   exist (with compare) and if already exist
			
			JFrame frame = new JFrame("JOptionPane -Checking data");
			JOptionPane.showMessageDialog(frame, "the Company" + company.getCompanyName()+ "Already Exist");
			return;

		}

	   }
	       companyDAO.insertCompany(company);
	       JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	      JOptionPane.showMessageDialog(frame, "Company " + company.getCompanyName() + " Created");
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
//		       JFrame frame = new JFrame("JOptionPane showMessageDialog example");
//		      JOptionPane.showMessageDialog(frame, "Company " + company.getCompanyName() + " Created");
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

	
}