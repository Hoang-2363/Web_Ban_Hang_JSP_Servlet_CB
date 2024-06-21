package admin.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private final String url = "jdbc:mysql://localhost:3306/QL_BH?useSSL=false";
	private final String username = "root";
	private final String password = "88888888";
	protected Connection connection = null;

	public ConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
}
