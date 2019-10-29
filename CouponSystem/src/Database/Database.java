package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

////This is the principal class for DB -- the packages and classes are connected to it////////////
///////////Database.Database--- DONT DELETE/////////////////
public class Database {
	//
	public static String getDBURL() {
		
	//	Database Database = new Database();
		
	     return "jdbc:derby://localhost:3301/test;create=true";
	}

	public static void createTables(Connection con) throws SQLException {
		try {
			Statement stmt = con.createStatement();
			String sql;

//			sql = "CREATE TABLE COMPANIES ("
//					+ "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENTED BY 1), "
//					+ "COMPANYNAME VARCHAR(50) NOT NULL, " + "PASSWORD DOUBLE NOT NULL, " + "EMAIL VARCHAR (50) NOT NULL)";
//			
			sql = "CREATE TABLE CUSTOMERS ("
				+ "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENTED BY 1), "
					+ "CUSTOMERNAME VARCHAR(50) NOT NULL, " + "PASSWORD VARCHAR(50) NOT NULL)";
			
//			
//			stmt.executeUpdate(sql);
//			System.out.println("success:" + sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public void insertUser(User user) {
//		// TODO Auto-generated method stub
		
	}

