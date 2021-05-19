package DAO;

import java.sql.*;
import java.util.*;

import Classes.Customers;
import Classes.Orders;


public class DAOCustomer{
	
	ResultSet result;
	private static Connection myConn;
	PreparedStatement prepStmt;
	
	public static void main (String [] args) throws Exception {
		
		DAOCustomer test1 = new DAOCustomer();
		System.out.println(test1.retrieveAllCustomers());
		
	}
	
	private Customers convertToCustomers(ResultSet result) throws Exception {
		
		int customerNumber = result.getInt("customerNumber");
		String customerName = result.getString("customerName");
		String contactLastName = result.getString("contactLastName");
		String contactFirstName = result.getString("contactFirstName");
		String phone = result.getString("phone");
		String addressLine1 = result.getString("addressLine1");
		String addressLine2 = result.getString("addressLine2");
		String city = result.getString("city");
		String state = result.getString("state");
		String postalCode = result.getString("postalCode");
		String country = result.getString("country");
		int salesRepEmployeeNumber = result.getInt("salesRepEmployeeNumber");
		double creditLimit = result.getDouble("creditLimit");
		Customers temp1 = new Customers(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
		
		return temp1;
	}
	
	
	public DAOCustomer() {
		try {
			String user = "root";
			String password = "Aneds1812";
			String dbURL = "jdbc:mysql://localhost:3306/classicmodels";
			
			myConn = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection to db: " + dbURL + " successful");
			}
			catch (Exception e){
				System.out.println("Message:" + e);
				
			}
	}
	
	public ArrayList<Customers> searchCustomers(String customerName) throws Exception {
		ArrayList<Customers> listOfCustomers = new ArrayList();
		
		try {
			prepStmt = myConn.prepareStatement("SELECT * FROM customers WHERE customerName = ?");
			prepStmt.setString(1, customerName);
			result = prepStmt.executeQuery();
			while (result.next()) {
				
				Customers temp2 = convertToCustomers(result);
				listOfCustomers.add(temp2);
			}
			
			return listOfCustomers;
		}
		
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		
		return null;
	}
	
	
	public ArrayList<Customers> retrieveAllCustomers() throws Exception {
		ArrayList<Customers> listOfCustomers = new ArrayList();
		
		try {
			prepStmt = myConn.prepareStatement("SELECT * FROM customers");
			result = prepStmt.executeQuery();
			
			while (result.next()) {
				
				Customers temp1 = convertToCustomers(result);
				listOfCustomers.add(temp1);
				
			} 
			
			return listOfCustomers;
		}
		
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		
		return null;
	}

	
	public void updateCustomer(Customers customer) {
		PreparedStatement statement;
		try {
			statement = myConn.prepareStatement("UPDATE customers SET customerName = ?, contactLastName = ?, contactFirstName = ?, phone = ?, addressLine1 = ? , addressLine2 = ? , city = ? , state = ? , postalCode = ? , country = ? , salesRepEmployeeNumber = ? , creditLimit = ? WHERE customerNumber = ?");

			statement.setString(1, customer.getCustomerName());
			statement.setString(2, customer.getContactLastName());
			statement.setString(3, customer.getContactFirstName());
			statement.setString(4, customer.getPhone());
			statement.setString(5, customer.getAddressLine1());
			statement.setString(6, customer.getAddressLine2());
			statement.setString(7, customer.getCity());
			statement.setString(8, customer.getState());
			statement.setString(9, customer.getPostalCode());
			statement.setString(10, customer.getCountry());
			statement.setInt(11, customer.getSalesRepEmployeeNumber());
			statement.setDouble(12, customer.getCreditLimit());

			statement.executeQuery();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}


	}
	
	public void deleteCustomer(int customerNumber) {

	    PreparedStatement statement;
	    try {
	        statement = myConn.prepareStatement("DELETE FROM customers WHERE customerNumber = ?");

	        statement.setInt(1, customerNumber);
	        statement.executeUpdate();

	    } catch (SQLException throwables) {
	        throwables.printStackTrace();
	    }
	
	}
	
	public void addCustomer(Customers theCustomer) throws Exception {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = myConn.prepareStatement("insert into customers"
                    + "(customerNumber,customerName,contactLastName,contactFirstName," +
                    "phone, addressLine1, addressLine2, city,state, postalCode, country," +
                    "salesRepEmployeeNumber, creditLimit)"

                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // set params
            myStmt.setInt(1, theCustomer.getCustomerNumber());
            myStmt.setString(2, theCustomer.getCustomerName());
            myStmt.setString(3, theCustomer.getContactLastName());
            myStmt.setString(4, theCustomer.getContactFirstName());
            myStmt.setString(5, theCustomer.getPhone());
            myStmt.setString(6, theCustomer.getAddressLine1());
            myStmt.setString(7, theCustomer.getAddressLine2());
            myStmt.setString(8, theCustomer.getCity());
            myStmt.setString(9, theCustomer.getState());
            myStmt.setString(10, theCustomer.getPostalCode());
            myStmt.setString(11, theCustomer.getCountry());
            myStmt.setInt(12, theCustomer.getSalesRepEmployeeNumber());
            myStmt.setDouble(13, theCustomer.getCreditLimit());

            // execute SQL
            myStmt.executeUpdate();

        }
        catch (SQLException throwables) {
	        throwables.printStackTrace();
	    }

    }

}

	