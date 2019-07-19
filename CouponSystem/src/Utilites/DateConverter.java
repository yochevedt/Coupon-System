package Utilites;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.apache.derby.iapi.error.PublicAPI;
import org.apache.derby.iapi.store.raw.RecordHandle;
import org.apache.derby.iapi.types.SQLDate;
import org.apache.derby.tools.sysinfo;

public class DateConverter {
	
	public String javaDate;
	public LocalDate LocalDate;
	
		////////**Convert current date --(java date) to Local Date  (today date)
		java.util.Date today = new java.util.Date();
		Instant instant = Instant.ofEpochMilli(today.getTime());
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
		java.time.LocalDate localDate = localDateTime.toLocalDate();
		private Date sqlDate;

		public void printLocalDate (){
			System.out.println("java.util.Date: " + today); 
		    System.out.println("java.time.LocalDate: " + localDate); 
		}
///////////////////////////////////////////////
		////Convert from localDate to SQL Date
		
   public void convertLocalDateToSQL (){
	   sqlDate = java.sql.Date.valueOf(localDate);
	   System.out.println(sqlDate);
		}
  ////////////////////////////////////
    /////////Convert from sql date to localDate
   
   public  LocalDate convertSQLTolocalDate() {
		  sqlDate.toLocalDate();
		  return localDate;
	  }

   ///////////////////////////////////////////////
   /////////Convert from localDate to java.util date
   
   public java.util.Date convertLocalDateToJava(){
	  LocalDateTime localDateTime = LocalDateTime.now();
      ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneOffset.systemDefault());
      Instant instant = zonedDateTime.toInstant();
      java.util.Date date = Date.from(instant);

	System.out.println("Result Date is : "+date);
	return date;
   }
   
}
        
	
 
