package Database;
import Coupon.*;
import Customer.*;
import Company.*;
import java.sql.*;

import javax.activation.DataSource;

import com.sun.xml.internal.ws.api.server.InstanceResolver;


//this class is the Singletone --Connection Pool ///

public class ConnectionPool {
	
	private final static int MAX_CONNECTIONS = 8;
	private static ConnectionPool instance = null;
	private static  Connection[] connections = new Connection[MAX_CONNECTIONS];
	private static String dbUrl = "jdbc:derby://localhost:3301/test;create=true";
	private static int counter;
	
	private ConnectionPool(){}
	
	public static ConnectionPool getInstance() {
		if (instance ==null) {
			synchronized (ConnectionPool.class) {
				if (instance == null) {
					instance = new ConnectionPool();
					initializerConnections();
					counter = 0;
				}
				
			}
		}
		return instance;
		
	}

	private static void initializerConnections() {
		for (int i=0; i < MAX_CONNECTIONS; i++){
			try {
				connections [i] = DriverManager.getConnection(dbUrl);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static Connection getConnection() {
		counter ++;
		if (counter == Integer.MAX_VALUE)
			counter = 0;
		return connections [counter%MAX_CONNECTIONS];
	}	  

}
