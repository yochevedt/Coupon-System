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

import org.apache.derby.iapi.error.PublicAPI;

import com.sun.xml.internal.ws.message.stream.StreamHeader11;

import Company.Company;
import Database.Database;
import sun.awt.geom.AreaOp.AddOp;


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
		
		
/*******************************************************************************************************/
		/***********************************Remover Customer   ********************************************************************/
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
		
		
		/*****************************Remove by customer id ***/
		/*******************************************************************************************************/

		
		public void removeCustomerbyId(long id ) throws Exception {
			// TODO Auto-generated method stub
			con = DriverManager.getConnection(Database.getDBURL());
			String pre1 = "DELETE FROM CUSTOMERS WHERE id=?";
             Customer customer = new Customer();
			try (PreparedStatement pstm1 = con.prepareStatement(pre1);) {
				con.setAutoCommit(false);
				pstm1.setLong(1, customer.getId());
				pstm1.executeUpdate();
				System.out.println("the customer was deleted ");
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
		
		

			
/*******************************************************************************************************/
		
/*********************************************************************************************/
		@Override
		public void updateCustomer (Customer customer) throws Exception{
      //	con = DriverManager.getConnection(Database.getDBURL());
//			try (Statement stm = con.createStatement()) {
//				String sql = "UPDATE CUSTOMERS " + " SET customerName='" + customer.getCustomerName() + "', password "
//						+ customer.getPassword() + "' WHERE ID=" + customer.getId();
//
//				//Statement stm = null;
//				stm.executeUpdate(sql);
//			} catch (SQLException e) {
//				throw new Exception(" update Customers failed");
//			}
			
//			try {
//				///String sql = "UPDATE CUSTOMERS  SET  CUSTOMERNAME = ?,PASSWORD = ? WHERE ID = ?";
//				String sql = "UPDATE CUSTOMERS SET customerName= ? " + customer.getCustomerName() + "', password = ?"
//				+ customer.getPassword() + "' WHERE ID= ? " + customer.getId();
//				
//				PreparedStatement stm1 = con.prepareStatement(sql);
//				
//				System.out.println("Exception is : " + sql  );
//				stm1.setLong(1, customer.getId());
//				stm1.setString(2, customer.getCustomerName());
//				stm1.setString(3, customer.getPassword());
//				stm1.executeUpdate();
		////////////from here new code to updated //////////////	
			Set <Customer> allCustomers = new HashSet<Customer>();
			allCustomers = getAllCustomers();
			Iterator<Customer> itr = allCustomers.iterator();
			
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:3301/test;crete=true");
			
			PreparedStatement pstms = null;
			System.out.println("Starting to update data..................");
			String sql = "UPDATE CUSTOMERS  SET  customerName = ?, password = ? WHERE id = ?";
			try {
						
				while (itr.hasNext()) {
					Customer customer2 = new Customer();
				    customer2 = itr.next();
				    pstms = con.prepareStatement(sql);
		
			    if (customer2.getCustomerName().equals(customer.getCustomerName())){ 
				
					System.out.println("Starting to update data");					
					pstms.setLong(1, customer.getId());
					System.out.println("Starting to update data");
					pstms.setString(2, customer2.getCustomerName());
					pstms.setString(3, customer.getPassword());
						pstms.executeUpdate();
						}
			    }
				
		
			} catch (SQLException e) {
				throw new Exception ("update customer  failed " + e.getMessage());
			} finally {
			
			con.close();
			System.out.println("Connection closed");
			}
		
		}

		
		
		/*******************************************************************************************/
		/*******************************************************************************************/
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

		/*******************************************************************************************************/
		/*******************************************************************************************************/
		@Override
		public synchronized Set<Customer> getAllCustomers() throws Exception {
			//con = DriverManager.getConnection(Database.getDBURL());
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:3301/test;crete=true");
			Set<Customer> set = new HashSet<>();
			String sql = "SELECT * FROM Customers";
			
			try (Statement stm = con.createStatement(); 
					ResultSet rs = stm.executeQuery(sql)) {
				while (rs.next()) {
			
					long id = rs.getLong(1);
					String customerName = rs.getString(2);
					String password = rs.getString(3);

					set.add(new Customer(id, customerName, password));
					
				}		
				
			} catch (SQLException e) {
				System.out.println("cannot get data list - getAllCustomers " + e);
				throw new Exception("cannot get Customer data");
			} finally {
				con.close();
			}

			return set;
		}
		
		
		

		@Override
		public void insertCustomer(Customer customer) throws Exception {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void removeCustomerbyId(Customer customer) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
		/***********************************************************************************/
		
		
				}	
	
	


