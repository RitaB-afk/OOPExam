package DAO;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import Classes.Orders;

public class DAOOrders {
	ResultSet result;
	private static Connection myConn;
	PreparedStatement prepStmt;
	
	public static void main (String [] args) throws Exception {
		
		DAOOrders test = new DAOOrders();
		System.out.println(test.retrieveAllOrders());
		
		
	}
	
	private Orders convertToOrders(ResultSet result) throws Exception {
		
		int orderNumber = result.getInt("orderNumber");
		String orderDate = result.getString("orderDate");
		String requiredDate = result.getString("requiredDate");
		String shippedDate = result.getString("shippedDate");
		String status = result.getString("status");
		String comments = result.getString("comments");
		int customerNumber = result.getInt("customerNumber");
		Orders temp2 = new Orders(orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);
		
		return temp2;
	}
	
	
	
	public DAOOrders() {
		try {
			String user = "root";
			String password = "Aneds1812";
			String dbURL = "jdbc:mysql://localhost:3306/classicmodels";
			
			myConn = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Connection to db " + dbURL + " successful");
			}
			catch (Exception e){
				System.out.println("Message:" + e);
				
			}
	}
	public ArrayList<Orders> searchOrders(String orderDate) throws Exception {
		ArrayList<Orders> listOfOrders = new ArrayList();
		
		try {
			prepStmt = myConn.prepareStatement("SELECT * FROM orders WHERE orderDate = ?");
			prepStmt.setString(1, orderDate);
			result = prepStmt.executeQuery();
			while (result.next()) {
				
				Orders temp2 = convertToOrders(result);
				listOfOrders.add(temp2);
			}
			
			return listOfOrders;
		}
		
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		
		return null;
	}
	
	public ArrayList<Orders> retrieveAllOrders() throws Exception {
		ArrayList<Orders> listOfOrders = new ArrayList();
		try {
			prepStmt = myConn.prepareStatement("SELECT * FROM orders");
			result = prepStmt.executeQuery();
			while (result.next()) {
				
				Orders temp2 = convertToOrders(result);
				listOfOrders.add(temp2);
			}
			
			return listOfOrders;
		}
		
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		
		return null;
	}
	

	public void updateOrder(Orders order) {
		PreparedStatement statement;
		try {
			statement = myConn.prepareStatement("UPDATE orders SET orderDate = ?, requiredDate = ?, shippedDate = ?, status = ?, comments = ? , customerNumber = ? WHERE orderNumber = ?");

			statement.setInt(1, order.getOrderNumber());
			statement.setString(2, order.getOrderDate());
			statement.setString(3, order.getRequiredDate());
			statement.setString(4, order.getShippedDate());
			statement.setString(5, order.getStatus());
			statement.setString(6, order.getComments());
			statement.setInt(7,order.getCustomerNumber());


			statement.executeQuery();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}


	}
	
	
public void deleteOrders(Orders orderDate) {

        PreparedStatement statement;
        try {
            statement = myConn.prepareStatement("DELETE FROM Orders WHERE orderDate = ?");
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

public static void addOrder(Orders anOrder) throws Exception{
    PreparedStatement myStmt= null;

try {
   //prepare statement
   myStmt = myConn.prepareStatement("insert into orders"
           + " (orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber)" + "values (?,?,?,?,?,?,?)");


   //set params
   myStmt.setInt(1, anOrder.getOrderNumber());
   myStmt.setString(2, anOrder.getOrderDate());
   myStmt.setString(3, anOrder.getRequiredDate());
   myStmt.setString(4, anOrder.getShippedDate());
   myStmt.setString(5, anOrder.getStatus());
   myStmt.setString(6, anOrder.getComments());
   myStmt.setInt(7, anOrder.getCustomerNumber());
  

   //execute SQL
   myStmt.executeUpdate();
}
catch (SQLException throwables) {
    throwables.printStackTrace();
}
}
}