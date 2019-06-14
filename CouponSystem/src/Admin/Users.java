package Admin;

import Database.User;

public class Users {
	
	private String user;
	private String password;
	
	public Users(){
	}
	
	public Users(String user, String password){
		this.user = user;
		this.password = password;
	}
	
	public String getUser() {
	return user;
	}
	public void setUsername(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
  //Users admin = new Users("admin", "1234");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}}

