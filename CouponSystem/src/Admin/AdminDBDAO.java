package Admin;
import java.util.Scanner;
import Admin.Users;


///This class is for Admin User login will be implemented in the AdminDAO////

   public class AdminDBDAO implements AdminDAO  {
      
	   
	   public void AdminLogin() throws Throwable, IllegalAccessException{
		   @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		   boolean user;
		   boolean admin = true;
		   user = admin;
		   String password = "1234";
		   boolean authPassword = true;
		      
		   System.out.println("Please enter your userName:()");
		   
		   String UserName = scanner.nextLine();
		   if (UserName.equals(user)) {
			   admin = true;
			System.out.println("Welcome admin user");
		} else {
			admin = false;
                System.out.print("Your user is incorrect");
		}
		   
	///////////Code to verify the password //////////////	   
		   System.out.print("Please enter your password" );
		   String EnterPassword = scanner.nextLine();
		   password = "1234";
		   
		   if (EnterPassword.equals(password)){
			   authPassword = true;
		   System.out.print("Welcome to the System");
		   }
		   else {
			   authPassword = false;
		       System.out.print("Incorrect Password");
			
		   }
		   
		   ////Create on Object "admin1" ///
		   if (admin==true){}
		   else	if (authPassword==true){
			//   Users.class.newInstance();
			   Users admin1 = new Users();
			   }
		   }}
		   
	   
		


		