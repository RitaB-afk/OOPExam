package com.exam.OOPGroup14;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerDAO {
	 private Connection myConn;
	    public ResultSet myRs;

	    public CustomerDAO() throws Exception {
	        //get db connection info
	        Properties props = new Properties();
	        props.load(new FileInputStream("lib/info.properties"));

	        String user = props.getProperty("user");
	        String dbUrl = props.getProperty("dburl");
	        String pass = props.getProperty("password");

	        try {
	            //connect to the database
	            myConn = DriverManager.getConnection(dbUrl, user, pass);
	            System.out.println("DB connection successful to: " + dbUrl);
	        }
	        catch (Exception e) {
	            System.out.print("Message: " +e);
	        }

	    }

	    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
	            throws SQLException {

	        if (myRs != null) {
	            myRs.close();
	        }

	        if (myStmt != null) {

	        }

	        if (myConn != null) {
	            myConn.close();
	        }
	    }

	    public static void main(String[] args) throws Exception {

	        CustomerDAO dao = new CustomerDAO();
	        System.out.println(dao.searchCustomers("Herkku Gifts"));


	        System.out.println(dao.displayAllCustomers());
	    }
	    
        //method to retrieve all customers
	    public ArrayList<Customer> displayAllCustomers() throws Exception {
	        ArrayList<Customer> customerlist = new ArrayList<>();

	        Statement myStmt = null;
	        ResultSet myRs = null;

	        try {
	            myStmt = myConn.createStatement();
	            myRs = myStmt.executeQuery("select * from customers");

	            while (myRs.next()) {
	                Customer tempCustomer = convertRowToCustomer(myRs);
	                customerlist.add(tempCustomer);
	            }
	            return customerlist;

	        } finally {
	            close(myStmt, myRs);
	        }
	    }
         // method to add a customer
	    public void addCustomer(Customer aCust) throws Exception {
	        PreparedStatement myStmt = null;

	        try {
	            // prepare the statement
	            myStmt = myConn.prepareStatement("insert into customers"
	                    + "(customerNumber,customerName,contactLastName,contactFirstName," +
	                    "phone, addressLine1, addressLine2, city,state, postalCode, country," +
	                    "salesRepEmployeeNumber, creditLimit)"

	                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

	            // set params
	            myStmt.setInt(1, aCust.getCustomerNumber());
	            myStmt.setString(2, aCust.getCustomerName());
	            myStmt.setString(3, aCust.getContactLastName());
	            myStmt.setString(4, aCust.getContactFirstName());
	            myStmt.setString(5, aCust.getPhone());
	            myStmt.setString(6, aCust.getAddressLine1());
	            myStmt.setString(7, aCust.getAddressLine2());
	            myStmt.setString(8, aCust.getCity());
	            myStmt.setString(9, aCust.getState());
	            myStmt.setString(10, aCust.getPostalCode());
	            myStmt.setString(11, aCust.getCountry());
	            myStmt.setInt(12, aCust.getSalesRepEmployeeNumber());
	            myStmt.setBigDecimal(13, aCust.getCreditLimit());

	            // execute SQL
	            myStmt.executeUpdate();

	        } finally {
	            close(myStmt);
	        }

	    }
	    
	    // method to search for a specific customer
	    public ArrayList<Customer> searchCustomers(String customerName) throws Exception {
	        ArrayList<Customer> customerlist = new ArrayList<>();

	        PreparedStatement myStmt = null;
	        myRs = null;

	        try {
	            customerName += "%";
	            myStmt = myConn.prepareStatement("select * from customers where customerName like ?");

	            myStmt.setString(1, customerName);

	            myRs = myStmt.executeQuery();

	            while (myRs.next()) {
	                Customer tempCustomer = convertRowToCustomer(myRs);
	                customerlist.add(tempCustomer);
	            }

	            return customerlist;
	        } finally {
	            close(myStmt, myRs);
	        }
	    }
	    public void deleteCustomer(int customerNumber) throws SQLException {
	        PreparedStatement myStmt = null;
	        try {
	            //prepare statement
	            myStmt = myConn.prepareStatement("Delete from customers where customerNumber=?");

	            //set parameter
	            myStmt.setInt(1, customerNumber);

	            myStmt.executeUpdate();
	        } 
	        catch (SQLException throwables) {
				throwables.printStackTrace();
			}
	    }
	    public void updateCustomer(Customer customer) {
			PreparedStatement statement= null;
			try {
				statement = myConn.prepareStatement("UPDATE customers SET customerName=?, contactLastName=?, contactFirstName=?, phone=?, addressLine1=?, addressLine2=?, city=?, state=?, postalCode=?, country=?, salesRepEmployeeNumber=?, creditLimit=? WHERE customerNumber=?");

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
				statement.setBigDecimal(12, customer.getCreditLimit());
				statement.setInt(13, customer.getCustomerNumber());

				statement.executeUpdate();
			} 
			
			catch (SQLException throwables) {
				throwables.printStackTrace();
			}
	    }

 
	    //method to make the results display as a customer
	    private Customer convertRowToCustomer(ResultSet myRs) throws SQLException {

	        int customerNumber = myRs.getInt("customerNumber");
	        String customerName = myRs.getString("customerName");
	        String contactLastName = myRs.getString("contactLastName");
	        String contactFirstName = myRs.getString("contactFirstName");
	        String phone = myRs.getString("phone");
	        String addressLine1 = myRs.getString("addressLine1");
	        String addressLine2 = myRs.getString("addressLine2");
	        String city = myRs.getString("city");
	        String state = myRs.getString("state");
	        String postalCode = myRs.getString("postalCode");
	        String country = myRs.getString("country");
	        int salesRepEmployeeNumber = myRs.getInt("salesRepEmployeeNumber");
	        BigDecimal creditLimit = myRs.getBigDecimal("creditLimit");


	        Customer tempCustomer = new Customer(customerNumber, customerName, contactLastName, contactFirstName,
	                phone,
	                addressLine1,
	                addressLine2,
	                city,
	                state,
	                postalCode,
	                country,
	                salesRepEmployeeNumber,
	                creditLimit);

	        return tempCustomer;
	    }

	    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
	        close(null, myStmt, myRs);
	    }

	    private void close(Statement myStmt) throws SQLException {
	        close(null, myStmt, null);
	    }

}
