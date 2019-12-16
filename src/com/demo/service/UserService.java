package com.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserService {
	Connection connection;
	Statement statement;

	public UserService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "1020zxnH");
			if (connection != null) {
				System.out.println("Connected to DB!");
				statement = connection.createStatement();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}