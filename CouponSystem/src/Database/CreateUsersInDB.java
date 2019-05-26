package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUsersInDB {

	public static void main(String[] args) {
		try {
		      Connection con = DriverManager.getConnection
		        ("jdbc:derby://localhost:3301/test;create=true"); 
		      
   Statement stmt = con.createStatement();
   stmt.executeUpdate("CREATE TABLE USERS (ID INT PRIMARY KEY, USER_NAME VARCHAR(50), PASSWORD VARCHAR (50))");
		      
      System.out.println("Created Table");
      System.out.println("Done");
		 
	    } catch(SQLException e) {
	      System.out.println("SQL exception occurred" + e.toString() );
	    
}
		
	}

}


