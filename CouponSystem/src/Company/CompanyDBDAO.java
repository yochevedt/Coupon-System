package Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import Database.Database;

public class CompanyDBDAO implements CompanyDAO {
	Connection con;

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
}