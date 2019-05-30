package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Database.User;
import Database.User;

public class TestUser {
	
	User user = new User();
	User user2 = new User(100, "admin", "1234");
	User user3 = new User (101, "support", "1234");

	//SQL connection string//
	private Connection connect() {
		String url = "jdbc:derby://localhost:3301/test";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (Exception exception) {
			System.out.println("sorry you have a connection problems");
		}
		return conn;
	}
	//Insert new row in table db
	public void insert(long id, String userName, String passwrod) {
		String sql = "INSERT INTO USERS (ID, USER_NAME, PASSWORD) VALUES(?,?,?)";
		
	try (Connection conn = this.connect();
		java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setLong(1, id);
			pstmt.setString(2, userName);
			pstmt.setString(3, passwrod);
			pstmt.executeUpdate();
				}catch (SQLException exception){
					System.out.println("The data could not be added to table");
				}
	}
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
	}

//	public static void main (String []args){
//		InsertConstantAction app = new InsertConstantAction();
//		app.insert
	public void insertUser(Database User) throws Exception {
		//User.insertUser(user);	
	user.insertUser(user);
	user.insertUser(user2);
	user.insertUser(user3);
	
	}
	
}