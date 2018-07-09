
package connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Driver driver = new oracle.jdbc.OracleDriver();
		try {
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","VIVEK", "1234");
			System.out.println(conn);
		} catch(SQLException sqe) {
			sqe.printStackTrace();
		}
	}

}
