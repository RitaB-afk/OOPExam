package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	
	static final String dbURL = "jdbc:mysql://localhost:3306/classicmodels";
	
	static final String user = "student";
	static final String pass = "student";
	
	public static void main(String[] args) {
	try {
		
    Connection myConn= DriverManager.getConnection(dbURL, user , pass);
    System.out.println("connection sucessful");
	}
	catch(SQLException err) {
		System.out.println(err.getMessage());
	}
	}
}