package Coupon;
import Coupon.Coupon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import org.apache.derby.client.am.SqlException;
import com.sun.org.apache.regexp.internal.recompile;
import Database.ConnectionPool;
import Database.Database;
import sun.util.calendar.CalendarDate;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import Database.ConnectionPool;


public class CouponDBDAO implements CouponDAO {
	private static final String SqlException = null;
	Connection con;
	private char[] SQLException;
	
	
	@Override
	public void insertCoupon(Coupon coupon) throws Exception {
		//String getDBURL = null;
		con = DriverManager.getConnection(Database.getDBURL());
		String sql = "INSERT INTO COUPONS (ID,TITLE,START_DATE,END_DATE,AMOUNT,TYPE,MESSAGE,PRICE,IMAGE)  VALUES(?,?,?,?,?,?,?,?,?)";
		
		long timestamp = System.currentTimeMillis();
		Date date = new Date(timestamp);
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		LocalDate date2 = date.toLocalDate();
		LocalDate exparationDate= date2.plusDays(10);
		String myLocalDate = date2.toString();
		String expiredDate = exparationDate.toString();
		 
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			
		    pstmt.setLong    (1, coupon.getId());
			pstmt.setString  (2, coupon.getTitle());
	//	pstmt.setObject(3, coupon.getStartDate());
			pstmt.setString  (3, coupon.getStartDate(myLocalDate));
	//pstmt.setDate(4, coupon.getEndDate());
			pstmt.setString  (4, coupon.getEndDate(expiredDate));
			pstmt.setInt     (5, coupon.getAmount());
			pstmt.setString  (6, coupon.getType());
			pstmt.setString  (7, coupon.getMessage());
            pstmt.setDouble  (8, coupon.getPrice());
            pstmt.setString  (9, coupon.getImage());
		
			pstmt.executeUpdate();
			System.out.println("Coupon  created successfully" + coupon.toString());
		} catch (SQLException exception) {
			System.err.println(exception);
			throw new Exception("Coupon creation failed");
		} finally {
			con.close();
		}
	}

	@Override
	public void removeCoupon(Coupon coupon) throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
		String pre1 = "DELETE FROM COUPONS WHERE id=?";

		try (PreparedStatement pstm1 = con.prepareStatement(pre1);) {
			con.setAutoCommit(false);
			pstm1.setLong(1, coupon.getId());
			pstm1.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new Exception("Database error");
			}
			throw new Exception("failed to remove coupon");
		} finally {
			con.close();
		}

	}

	public void updateCoupon (Coupon coupon) throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
		try (Statement stm = con.createStatement()) {
			String sql = "UPDATE COUPONS " + " SET title='" + coupon.getTitle()  + "', START_DATE "
					+ coupon.getStartDate() + "', E " + coupon.getEndDate() + "', amount " 
					+ coupon.getAmount() + "', type " + coupon.getType() + "', message " + coupon.getMessage()
					+ "', price " + coupon.getPrice() + "', image " + coupon.getImage() +
				    "' WHERE ID=" + coupon.getId();

			stm.executeUpdate(sql);
		} catch (SQLException e) {
			throw new Exception(" update Coupons  failed");
		}
	}

	@Override
	public Coupon getCoupon(long id) throws Exception {
		//con = DriverManager.getConnection(Database.getDBURL());
		Connection con = DriverManager.getConnection("jdbc:derby://localhost:3301/test;crete=true"); 
		
		Coupon coupon = new Coupon();
	        
	     long timestamp = System.currentTimeMillis();
	Date date = new Date(timestamp);
	DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
	formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

		
	LocalDate myLocalDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	System.out.println( SQLException  );
	LocalDate exparationDate= myLocalDate.plusDays(10);
	//Date date2 = Date.valueOf(myLocalDate);
	//Date updatedDate = Date.valueOf(exparationDate);
		
		try (Statement stm = con.createStatement()) {
			String sql = "SELECT * FROM COUPONS WHERE ID=" + id;
			ResultSet rs = stm.executeQuery(sql);
			
			rs.next();
			coupon.setId(rs.getLong(1));
			coupon.setTitle(rs.getString(2));
		    
			coupon.setStartDate(myLocalDate);
			coupon.setEndDate(exparationDate);
			
			coupon.setAmount(rs.getInt(5));
			coupon.setType(rs.getString(6));
			coupon.setMessage(rs.getString(7));
			coupon.setPrice(rs.getDouble(8));
			coupon.setImage(rs.getString(9));
			

		} catch (SQLException e) {
			throw new Exception("Unable to get data");
		} finally {
			con.close();
		}
		return coupon;
	}

	
	///////////////original method for Get All Coupons ////////////////////////
	@SuppressWarnings("unused")
	@Override
	public synchronized Set<Coupon> getAllCoupons() throws Exception {
		con = DriverManager.getConnection(Database.getDBURL());
		//Connection con = DriverManager.getConnection("jdbc:derby://localhost:3301/test;crete=true");
		Set<Coupon> set = new HashSet<>();		
		String sql = "SELECT id FROM Coupons";
		try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
			while (rs.next()) {
			long id = rs.getLong(1);
			String title = rs.getString(1);
	  	// Date startDate = rs.getDate(1);
		// Date endDate = rs.getDate(1);
			int amount = rs.getInt(1);
			String type = rs.getString(1);
			String message = rs.getString(1);
			double price = rs.getDouble(1);
  		    String image = rs.getString(1);
				
		
             set.add(new Coupon());
            LocalDate startDate1 = null;
			LocalDate endDate1 = null;
			//    set.add(new Coupon(id, title, startDate, endDate, amount, type, message, price, image));
             set.add(new Coupon(id, title, startDate1, endDate1, amount, type, message, price, image));
             System.out.println("list coupons is " + couponDAO.getAllCoupons());
			}
		} catch (SQLException e) {
			//System.out.println(e);
			e.printStackTrace();
			throw new Exception("cannot get Coupon data");
		} finally {
			con.close();
		}

		return set;
	}
//	}////////////////////////////////////////////////////////////////finish original method get all coupons
	
	
//	/**
//	 * new method get all coupons
//	 * @throws Exception 
//	 */
//	@Override
//	public Set<Coupon> getAllCoupons() throws Exception {
//		Collection<Coupon> coupons = new ArrayList<Coupon>();
//
//		try {
//			con = ConnectionPool.getInstance().getConnection();
//			String getAllSQL = "SELECT ID FROM COUPONS";
//			PreparedStatement pStatement = con.prepareStatement(getAllSQL);
//			ResultSet result = pStatement.executeQuery();
//
//			if (result != null) {
//				while (result.next()) {
//					Coupon coupon = getCoupon(result.getLong("ID"));
//					coupon.getCoupon(result.getLong("ID"));
//				}
//				System.out.println("All coupons retrieved from the database!" + coupons.addAll(coupons));
//				
//			}
//		} catch (SQLException e) {
//			System.out.println(SQLException + "Error connection..");
//			throw new SQLException("Failed to retrieve all coupons from the database.");
//		} finally {
//			System.out.println("Connecting......");
//			             ConnectionPool.getInstance().returnConnection(con);
//			System.out.println(SqlException + "error sql");
//		
//		}
//		return (Set<Coupon>) coupons;
//	}

	public void removeCoupon(long id) throws Exception {
		// TODO Auto-generated method stub
		couponDAO.removeCoupon(getCoupon(id));
	}

	
//	public void removeExpiredCoupon() {
//		
//		Collection<Coupon> taskList = null;
//		//CouponDAO couponTask = new CouponDAO() {
//		CouponDBDAO couponTask = new CouponDBDAO(); 
//		
//		try {
//			taskList = (ArrayList<Coupon>) couponTask.getAllCoupons();
//		} catch (SQLException e) {
//			throw new SQLException("Failed to remove expired Coupons.");
//		}
//		Iterator<Coupon> iter = taskList.iterator();
//		if (iter != null) {
//			while (iter.hasNext()) {
//				Coupon currentCoupon = iter.next();
////				if (!currentCoupon.getEndDate().isAfter(getTime())) {
////					try {
////						couponTask.removeCoupon(currentCoupon);
////					} catch (SQLException e) {
////						throw new SQLException("Failed to remove expired Coupons.");
////					}
//               }
//			}}

	private Object getTime() {
		java.util.Date today = new java.util.Date();
		today = Calendar.getInstance().getTime();
		return (Date) today;
	}

	@Override
	public void removeExpiredCoupon() {
		// TODO Auto-generated method stub
		
	}
	
	}


