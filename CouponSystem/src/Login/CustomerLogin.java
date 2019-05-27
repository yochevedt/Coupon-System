package Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerLogin {
	
	public void run() throws FileNotFoundException {
		Scanner scan = new Scanner (new File("C:/JavaExercise/LoginCouponSystemFile/customerFile.txt"));
		                            
		
		Scanner keyboard = new Scanner((System.in));
		
		String user = scan.nextLine();
		String pass = scan.nextLine();  //this will look in the file for the user and password//
		
		String inputUser = keyboard.nextLine();
		String inpPass = keyboard.nextLine();
		
		if (inputUser.equals(user) && inpPass.equals(pass)) {
			System.out.println("Dear Customer, Welcome to the Coupon System");
			
		} else {
			System.out.println("Invalid User or Password, please try again");
		}
	}

}
