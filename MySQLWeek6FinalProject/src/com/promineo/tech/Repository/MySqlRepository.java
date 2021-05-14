package com.promineo.tech.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlRepository {
	private Connection conn;
	private final String Username = "root";
	private final String Password = "M303h792!";
	
	public Connection getConnection(String dbname) {
		try
		{
			String rennlist = "jdbc:mysql://localhost:3306/" + dbname;
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(rennlist, Username, Password);
			}
			
			return conn;
		} 
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return conn;
		}
	}
}
