package Database;
import java.sql.*;

//////////**********this class is to "Create  tables in db"***********
public class CreateDatabase {

	public static void main(String[] args) {
		try {
		      Connection con = DriverManager.getConnection
		        ("jdbc:derby://localhost:3301/test;create=true"); 
		      System.out.println("Database succeed");
		 
		      Statement stmt = con.createStatement();
	//********Code to create table Companies *************
		      
		    //  stmt.executeUpdate("CREATE TABLE COMPANIES (ID INT PRIMARY KEY, COMPANYNAME VARCHAR(50), PASSWORD VARCHAR (50), EMAIL VARCHAR (50))");
		    //  System.out.println("Created Table");
		 
//		      stmt.executeUpdate("INSERT INTO NAMES VALUES (1,'Redbend', '1234', 'email@gmail.com'),(1,'harman', '4444', 'harman@gmail.com'");
//		      System.out.println("Populated Table--companies added to table");
//		 
//		      System.out.println("Done");
//		 
//		    } catch(SQLException e) {
//		      System.out.println("SQL exception occurred" + e.toString() );
//		    }
/////////////////////////////////////////
		/////******Code to create table Customers*************
		     // stmt.executeUpdate("CREATE TABLE CUSTOMERS (ID INT PRIMARY KEY, CUSTOMERNAME VARCHAR(50), PASSWORD VARCHAR (50))");
			//  System.out.println("Created Table - CUSTOMERS");   
		      
		      
		 // stmt.executeUpdate("INSERT INTO NAMES VALUES (1,'Redbend', '1234', 'email@gmail.com'),(1,'harman', '4444', 'harman@gmail.com'");
	      //System.out.println("Populated Table--companies added to table");
	//////////////////////////////// 
		      /////////////*******Code to create Coupons table *********
		      
//		      stmt.executeUpdate("CREATE TABLE COUPONS (ID INT PRIMARY KEY, TITLE VARCHAR(50), START_DATE DATE, END_DATE DATE, AMOUNT INT, TYPE VARCHAR(50), MESSAGE VARCHAR(50), PRICE DOUBLE, IMAGE VARCHAR(50))");
//			  System.out.println("Created Table - COUPONS");     
//		      
//		        System.out.println("Done");
//	 
//	    } catch(SQLException e) {
//	      System.out.println("SQL exception occured" + e.toString() );
//	    }
	//////////////////////////////////////////////////////
//		stmt.executeUpdate("CREATE TABLE TESTTABLE (ID INT PRIMARY KEY, TITLE VARCHAR(50), START_DATE DATE, END_DATE DATE, AMOUNT INT, TYPE VARCHAR(50), MESSAGE VARCHAR(50), PRICE DOUBLE, IMAGE VARCHAR(50))");
//		  System.out.println("Created Table - TEST1");     
//	      
//	        System.out.println("Done");

  } catch(SQLException e) {
    System.out.println("SQL exception occured" + e.toString() );
  }
		
	}

}
