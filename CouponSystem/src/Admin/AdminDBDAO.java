package Admin;
import java.util.Scanner;

///This class is for Admin User login will be implemented in the AdminDAO////

   public class AdminDBDAO implements AdminDAO  {
      
	   
	   public void AdminLogin(){
		   @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		   boolean user;
		   boolean admin = false;
		   user = admin;
		   String password = "1234";
		   
		   System.out.println("Please enter your userName:()");
		   String UserName = scanner.nextLine();
		   if (UserName.equals(user)) {
			System.out.println("Welcome admin user");
		} else {
                System.out.print("Your user is incorrect");
		}
		   
		   
		   System.out.print("Please enter your password" );
		   String EnterPassword = scanner.nextLine();
		   password = "1234";
		   
		   if (EnterPassword.equals(password))
		   System.out.print("Welcome to the System");
		   
		   else
			System.out.print("Incorrect userName");
		   
		   if (password.equals(password))
			   System.out.println("Welcome to the System");
	    
		   else
			   System.out.println("your password is incorrect");
		   

		}


}
		


		