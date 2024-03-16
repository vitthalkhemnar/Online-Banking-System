package com.connectionfactory;

import java.sql.Connection;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionFactory {
	private static Connection con;
	
	public static Connection getcon() {
		try {
			MysqlDataSource ds = new MysqlDataSource();
			ds.setUrl("jdbc:mysql://localhost:3306/bank");
			ds.setUser("root");
			ds.setPassword("vitthal@2003");
			
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return con;
		}
	}
}
