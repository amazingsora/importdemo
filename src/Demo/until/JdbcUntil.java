package Demo.until;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUntil {
	private static Connection con = null;

	public static Connection getCon() {
		if (con != null) {
			return con;
		} else {
			try {
				String dbDriver = "org.postgresql.Driver";
				String connectionUrl ="jdbc:postgresql://localhost:5432/demo"; 
				String userName = "amazingsora";
				String password = "4321";
				Class.forName(dbDriver).newInstance();
				con = DriverManager.getConnection(connectionUrl, userName, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
	}


	
}
