package newbies.java16.crmapp.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private static Connection connection = null;
	private final static String URL = "jdbc:mysql://localhost:3306/crm";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "30102001";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				return connection;
			}else {
				return connection;
			}
		} catch (ClassNotFoundException | SQLException e) {
		System.out.println("DB connection couldn't be established");
		}
		return null;
	}
}
