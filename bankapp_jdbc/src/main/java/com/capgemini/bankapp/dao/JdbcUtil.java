package com.capgemini.bankapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	
	
	public static Connection getconnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		conn=	DriverManager
			.getConnection("jdbc:mysql://localhost:3306/db?"
			        + "user=root&password=Capgemini123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

}
