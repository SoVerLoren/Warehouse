package com.hushi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Linkdb {

	public static final	String userName="sa";
	public static final	String passWord="123";
	public static final	String url="jdbc:sqlserver://localhost:1433;DatabaseName=Warehouse";
	public static final	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static Connection con;
	
	public static Connection getcon()
	{
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, userName, passWord);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
