package Coupon;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.time.*;


  

public class oldCoupon {
   private long id;
   private String title;
   private java.util.Date startDate; 
   private LocalDate endDate;
   private int amount;
   private String type;
   private String message;
   private double price;
   private String image;
   

  public Coupon (long id, String title, LocalDate startDate, LocalDate endDate, 
	int amount, String type, String message, double price, String image){
	  
    super();
	  
	long timestamp = System.currentTimeMillis();
		Date date = new Date(timestamp);
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		LocalDate myLocalDate = date.toLocalDate();
		LocalDate exparationDate= myLocalDate.plusDays(10);
	
	   // System.out.println(myLocalDate);
		
	  setId(id);  
	  setTitle(title);
	  setStartDate(java.util.Date);
	  //setStartDate(startDate);  //changed now03.04
	  //setEndDate(endDate);      //changed now03.04
	  setEndDate(exparationDate);
	  setAmount(amount);
	  setType(type);
	  setMessage(message);
	  setPrice(price);
	  setImage(image);
	  	  
	    }

    public Coupon() {

    }

	

	public Coupon(long id, String title, Date startDate, Date endDate, int amount, String type, String message,
			double price, String image) {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public java.util.Date getStartDate() {
		
		return startDate;
	}

   public void setStartDate(java.util.Date date) {
	this.startDate=date;
    }
	
	public LocalDate getEndDate() {
		return endDate;
	}

//	public void setEndDate(LocalDate updatedDate) {
//		this.endDate = updatedDate;
//	}
	
	public void setEndDate(LocalDate exparationDate) {
		this.endDate = exparationDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", amount=" + amount + ", type=" + type + ", message=" + message + ", price=" + price + ", image="
				+ image + "]";
	}

	
	
	public String getStartDate(String startDate) {
		setStartDate(getStartDate());
		return startDate;
		}

	public String getEndDate (String endDate) {
		setEndDate(getEndDate());
		return endDate;
	}

	public  long getCoupon(long id) {
		Coupon coupon = new Coupon();
	
		return coupon.id;
		
	}
    
}