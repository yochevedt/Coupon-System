package Utilites;
import Utilites.DateConverter;

public class UtilitiesTest {
	
	static DateConverter dateConverter = new DateConverter();
	static DateConverter dateConverter1 = new DateConverter();
	
  	
	public static void main(String[] args) {
		
		((DateConverter) dateConverter).convertSQLTolocalDate();
		System.out.println("the method" + dateConverter.convertLocalDateToJava() + "this is convertion to from local date to java date" );
		//System.out.println("The second method is " +  dateConverter1.convertLocalDateToSQL()  + "this convert from sql date to local date  date");
		
		
		

	}
}
