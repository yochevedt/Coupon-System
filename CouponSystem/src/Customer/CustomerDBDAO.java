package Customer;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Company.Company;
import Database.Database;


	public class CustomerDBDAO implements CustomerDAO {
		Connection con;
		

		public void CreateCustomer(Customer customer) throws Exception {
			//String getDBURL = null;
			con = DriverManager.getConnection(Database.getDBURL());
			String sql = "INSERT INTO CUSTOMERS (id,customerName,password)  VALUES(?,?,?)";
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {

			    pstmt.setLong(1, customer.getId());
				pstmt.setString(2, customer.getCustomerName());
				pstmt.setString(3, customer.getPassword());
			

				pstmt.executeUpdate();
				System.out.println("Customer created successfully" + customer.toString());
			} catch (SQLException exception) {
				System.err.println(exception);
				throw new Exception("Customer creation failed");
			} finally {
				con.close();
			}
		}

		@Override
		public void removeCustomer(Customer customer) throws Exception {
			con = DriverManager.getConnection(Database.getDBURL());
			String pre1 = "DELETE FROM CUSTOMERS WHERE id=?";

			try (PreparedStatement pstm1 = con.prepareStatement(pre1);) {
				con.setAutoCommit(false);
				pstm1.setLong(1, customer.getId());
				pstm1.executeUpdate();
				con.commit();
			} catch (SQLException e) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					throw new Exception("Database error");
				}
				throw new Exception("failed to remove customer");
			} finally {
				con.close();
			}

		}

		public void updateCustomer (Customer customer) throws Exception {
			con = DriverManager.getConnection(Database.getDBURL());
			try (Statement stm = con.createStatement()) {
				String sql = "UPDATE CUSTOMERS " + " SET customerName='" + customer.getCustomerName() + "', password "
						+ customer.getPassword() + "' WHERE ID=" + customer.getId();

				//Statement stm = null;
				stm.executeUpdate(sql);
			} catch (SQLException e) {
				throw new Exception(" update Customers failed");
			}
		}

		@Override
		public Customer getCustomer(long id) throws Exception {
			con = DriverManager.getConnection(Database.getDBURL());
		     Customer customer = new Customer();
			
			try (Statement stm = con.createStatement()) {
				String sql = "SELECT * FROM CUSTOMERS WHERE ID=" + id;
				ResultSet rs = stm.executeQuery(sql);
				rs.next();
				customer.setId(rs.getLong(1));
				customer.setCustomerName(rs.getString(2));
				customer.setPassword(rs.getString(3));
				

			} catch (SQLException e) {
				throw new Exception("Unable to get data");
			} finally {
				con.close();
			}
			return customer;
		}

		@Override
		public synchronized Set<Customer> getAllCustomers() throws Exception {
			con = DriverManager.getConnection(Database.getDBURL());
			Set<Customer> set = new HashSet<>();
			String sql = "SELECT id FROM Customers";
			try (Statement stm = con.createStatement(); ResultSet rs = stm.executeQuery(sql)) {
				while (rs.next()) {
					long id = rs.getLong(1);
					String customerName = rs.getString(1);
					String password = rs.getString(1);

					set.add(new Customer(id, customerName, password));
				}
			} catch (SQLException e) {
				System.out.println(e);
				throw new Exception("cannot get Customer data");
			} finally {
				con.close();
			}

			return set;
		}

	//	public void createCustomer(Customer customer) throws Exception {
			// TODO:
			//Auto-generated method stub
			//check if customer exist - bring AllCustomers
			//make a loop while and if the customer  exist exit, if not exist insert method.
			//add insert customer method.
			//add System prints to exit and System prints to added company
			
			//Yailin Code //
//			con = DriverManager.getConnection(Database.getDBURL());
//			Set<Customer> allCustomers = new HashSet<>();
//			allCustomers = custDAO.getAllCustomers();
//			
//			Iterator<Customer> iterator = allCustomers.iterator();
//			
//			while (iterator.hasNext()) {
//				
//				Customer customer2 = new Customer();
//				customer2 = iterator.next();
//					if  (customer2 instanceof Customer && customer.getCustomerName().equals(customer.getCustomerName()))
//						{
//			      	// verify if Company   exist (with compare) and if already exist
//				
//				JFrame frame = new JFrame("JOptionPane -Checking data");
//				JOptionPane.showMessageDialog(frame, "the Customer" + customer.getCustomerName()+ "Customer already exit");
//				return;
//
////			}
//
//		       custDAO.insertCustomer(customer);
//		       System.out.println("Customer created successfully");
//	       }
		
		
		public void removeCustomerCoupons(Customer customer) {
			
			//TODO:
			//Create a method that will check the list in Customer_Coupon table
			//the join table will be  displayed  as a list
			//bring the list of the Customer_Coupons table and 
			//need to create a while loop, that checks if Customer id  exist or not in Costumer table
			//if not exist remove all the coupons that has Customer id in the same row.
			//if exist do nothing.
			
		}

		@Override
		public void insertCustomer(Customer customer) throws Exception {
			// TODO Auto-generated method stub
			
		}

		

		
	}


