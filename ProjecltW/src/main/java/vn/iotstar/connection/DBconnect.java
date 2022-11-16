package vn.iotstar.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	private final String serverName = "DESKTOP-052B03D";
	//private final String serverName = "DESKTOP-7CJHVGV";
	private final String dbName = "STATIONERY";
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
