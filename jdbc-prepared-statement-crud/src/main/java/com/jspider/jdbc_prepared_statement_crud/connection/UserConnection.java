package com.jspider.jdbc_prepared_statement_crud.connection;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class UserConnection {

	public static Connection getUserConnection() {
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			String url="jdbc:mysql://localhost:3306/jdbc-self";
			String username="root";
			String password="root";
			
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The connection is not established");
			e.printStackTrace();
			
			return null;
		}
		
	}

}
