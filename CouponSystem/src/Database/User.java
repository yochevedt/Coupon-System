package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

//Create a class for Users


public class User {
	private long id;
	private  String user_name;
	private String password;
	
	public User (){
	}
	
	public User (long id, String user_name, String password){
		setId(id);
		setUserName(user_name);
		setPassword(password);
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", user_Name=" + user_name + ", password=" + password + ", getId()=" + getId() + ", getUserName()="
        + getUserName() + ", getPassword()=" + getPassword() + "]"; 
	}

	Connection con;
	private java.sql.PreparedStatement preparedStatement;
	
	public void insertUser (User user) throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
				preparedStatement = null;
				
					preparedStatement.setLong(1, getId());
					preparedStatement.setString(2, getUserName());
					preparedStatement.setString(3, getPassword());
                      			
		}
	public User getUser(long id) throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
		User user = new User();
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM USERS WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
            user.setId(rs.getLong(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
		

		} catch (SQLException e) {
			throw new Exception("Unable to get data");
		} finally {
			con.close();
		}
		return user;
	}
	
	public synchronized Set<User> getAllUser() throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
		Set<User> set = new HashSet<>();
		String sql = "SELECT id FROM USER";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
				long id = rs.getLong(1);
				String userName = rs.getString(1);
				String password = rs.getString(1);
				
				set.add(new User(id, userName, password));
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new Exception("cannot get User data");
		} finally {
			con.close();
		}

		return set;
	}

}