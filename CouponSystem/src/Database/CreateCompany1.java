package Database;
import java.sql.*;
//***********This class create table companies in DB**************
public class CreateCompany1 {

	public static void main(String[] args) throws SQLException {
		try {
		      Connection con = DriverManager.getConnection
		        ("jdbc:derby://localhost:3301/test;create=true"); 
		      
		
		      Statement stmt = con.createStatement();
	//********Code to create table Companies *************
		      
		    stmt.executeUpdate("CREATE TABLE COMPANIES (ID INT PRIMARY KEY, COMPANYNAME VARCHAR(50), PASSWORD VARCHAR (50), EMAIL VARCHAR (50))");
		    
		      
//		      stmt.executeUpdate( "CREATE TABLE COMPANIES ("
//					+ "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENTED BY 1), "
//						+ "COMPANYNAME VARCHAR(50) NOT NULL, " + "PASSWORD DOUBLE NOT NULL, " + "EMAIL VARCHAR (50) NOT NULL)");
		      
//		      stmt.executeUpdate( "CREATE TABLE COMPANIES (" 
//		    		     + "ID INT NOT NULL PRIMARY KEY, " +
//		    		    "COMPANYNAME varchar(50) NOT NULL, " +
//		    		    "PASSWORD varchar (50) NOT NULL, " + 
//		    		    "EMAIL VARCHAR (50) )");
//	    		    
//		      
		      System.out.println("Created Table");
		 
//  stmt.executeUpdate("INSERT INTO NAMES VALUES (1,'Redbend', '1234', 'email@gmail.com'),(1,'harman', '4444', 'harman@gmail.com'");
//	      System.out.println("Populated Table--companies added to table");
//		 
		      System.out.println("Done");
		 
		    } catch(SQLException e) {
		      System.out.println("SQL exception occurred" + e.toString() );
		    
	}
			
		}

	}
