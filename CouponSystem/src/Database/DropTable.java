package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {
	
	private static final String URL = "jdbc:derby://localhost:3301/test";
   // private static final String USERNAME = "root";
    //private static final String PASSWORD = "";


	public static void main(String[] args) {
		
		try (Connection connection =
                DriverManager.getConnection(URL)) {
			//DriverManager.getConnection(URL, USERNAME, PASSWORD)) {  
			
			
			// To delete a table from database we use the DROP TABLE
            // command and specify the table name to be dropped
            String sql = "DROP TABLE COUPONS";

            // Create a statement
            Statement statement = connection.createStatement();
            // Execute the statement to delete the table
            statement.execute(sql);
            System.out.println("Drop Table action succeed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
