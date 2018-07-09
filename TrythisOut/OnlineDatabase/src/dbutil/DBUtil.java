package dbutil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DBUtil {
	
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "VIVEK";
	private static final String password = "1234";
	
	private static Connection conn = null;
	private static  Driver driver = null;
	
	static {
		driver = new OracleDriver();
		System.out.println("Driver Loaded");
	}
	
	public static Connection getMyConnection() {
		try {
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url,user,password);
		} catch(SQLException sqe) {
			System.out.println("Error found in DButil.java");
			sqe.printStackTrace();
		}
		return conn;
	}
}
