package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static Connection connection;

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {

		if (connection == null || connection.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/video_browsing_db", "root", "");
		}

		return connection;
	}

}
