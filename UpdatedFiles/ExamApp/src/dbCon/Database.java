package dbCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
	
	ArrayList<Connection> connections = new ArrayList<Connection>();
	
	private static Connection myConn;
	
	public static void main (String [] args) {
		try {
		String user = "root";
		String password = "Aneds1812";
		String dbURL = "jdbc:mysql://localhost:3306/classicmodels";
		
		myConn = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection to db" + dbURL + " successful");
		}
		catch (Exception e){
			System.out.println("Message:" + e);
			
		}
		
	}
}