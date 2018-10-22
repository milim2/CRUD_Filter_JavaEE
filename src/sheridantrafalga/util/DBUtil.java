package sheridantrafalga.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
*
* Used Singleton pattern
*
* */
public class DBUtil {

	// To connect MySQL with db.properities
	private static Connection conn;
	
	
	private DBUtil() {
    }

	public static Connection getConnection() {

		if (conn != null)
			return conn;

		InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("/db.properities");

		Properties properties = new Properties();

		try {
			properties.load(is);

			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");

			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, password);

		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	
	public static void closeConnection(Connection tobeClosed) {
		if (tobeClosed == null) {
			return;
		}

		try {
			tobeClosed.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
