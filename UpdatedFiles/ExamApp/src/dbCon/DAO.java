package dbCon;

import java.sql.*;
import java.time.*;
import java.util.*;

import DAO.Interfaces.CustomerDAO;
import DAO.Interfaces.EmployeeDAO;
import DAO.Interfaces.OrdersDAO;
import dbCon.Database;
import Classes.Customers;
import Classes.Employee;
import Classes.Orders;

public class DAO {
	
	ResultSet result;
	private static Connection myConn;
	PreparedStatement prepStmt;
	
	public static void main (String [] args) throws Exception {
		
		DAO test = new DAO();
		System.out.println(test.retrieveAllEmployees());
		
		
	}
	
	private Employee convertToEmployee(ResultSet result) throws Exception {
		
		int employeeNumber = result.getInt("employeeNumber");
		String lastName = result.getString("lastName");
		String firstName = result.getString("firstName");
		String extension = result.getString("extension");
		String jobTitle = result.getString("jobTitle");
		String email = result.getString("email");
		String officeCode = result.getString("officeCode");
		int reportsTo = result.getInt("reportsTo");
		Employee temp = new Employee(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
		
		return temp;
	}
	
	
	
	public DAO() {
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
	
	
	
	public ArrayList<Employee> retrieveAllEmployees() throws Exception {
		
		ArrayList<Employee> listOfEmployee = new ArrayList();
		
		try {
			prepStmt = myConn.prepareStatement("SELECT * FROM employees");
			result = prepStmt.executeQuery();
			
			while (result.next()) {
				
				Employee temp = convertToEmployee(result);
				listOfEmployee.add(temp);
				
			} 
			
			return listOfEmployee;
		}
		
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		
		return null;
	}
	
	
	public ArrayList<Customers> retrieveAllCustomers() {
		try {	
			prepStmt = myConn.prepareStatement("SELECT * FROM customers");
			result = prepStmt.executeQuery();
			
			
			return toCustomers(result);
		}
		
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		
		return null;
	}
	
	public ArrayList<Orders> retrieveAllOrders() {
		try {
			prepStmt = myConn.prepareStatement("SELECT * FROM orders");
			result = prepStmt.executeQuery();
			
			
			return toOrders(result);
		}
		
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		
		return null;
	}
	
	

}