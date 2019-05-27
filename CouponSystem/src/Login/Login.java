package Login;
import java.sql.*;
import Company.CompanyDBDAO;
import Company.Company;



public class Login {
	
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
	   static final String DB_URL = "jdbc:derby://localhost:3301/test";
	   
	//  Database credentials
	   static final String USER = "admin";
	   static final String PASS = "1234";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("org.apache.derby.jdbc.ClientDriver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT id, companyname, password, email FROM COMPANIES";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         int companyname = rs.getInt("companyname");
	         String password = rs.getString("password");
	         String email = rs.getString("email");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", CompanyName: " + companyname);
	         System.out.print(", Password: " + password);
	         System.out.println(", email: " + email);
	      }
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	}//end FirstExample

   