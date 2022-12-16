package vn.iotstar.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
<<<<<<< Updated upstream
	private final String serverName = "DESKTOP-052B03D";
	//private final String serverName = "DESKTOP-7CJHVGV";
=======
	//private final String serverName = "DESKTOP-052B03D";
	//private final String serverName = "DESKTOP-S151P30";
	private final String serverName = "DESKTOP-7CJHVGV";
>>>>>>> Stashed changes
	private final String dbName = "STATIONERYv3";
	private final String portNumber = "1433";
	private final String instance = "\\SQLEXPRESS";
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + instance + ";integratedSecurity=true;databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";integratedSecurity=true;databaseName="
					+ dbName;
		// DriverManager.registerDriver(new
		// com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
	}
	public static void main(String[] args) {
		try {
			System.out.println(new DBconnect().getConnection());
			//System.out.println("Sucessfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
