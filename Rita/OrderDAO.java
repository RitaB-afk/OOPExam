package com.exam.OOPGroup14;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

    public class OrderDAO {
        private static Connection myConn;

        public OrderDAO () throws Exception {
            String user= "root";
            String password= "A5gtrw6e";
            String dburl= "jdbc:mysql://localhost:3306/classicmodels";

            //connect to database
            myConn= DriverManager.getConnection(dburl, user, password);
            System.out.println("Connection to db " + dburl + " successful");
        }
    
        public void updateOrder(Order order) {
    		PreparedStatement statement;
    		try {
    			statement = myConn.prepareStatement("UPDATE orders SET orderDate =?, requiredDate =?, shippedDate =?, status =?, comments =? , customerNumber =? WHERE orderNumber =?");

    			statement.setInt(7, order.getOrderNumber());
    			statement.setString(1, order.getOrderDate());
    			statement.setString(2, order.getRequiredDate());
    			statement.setString(3, order.getShippedDate());
    			statement.setString(4, order.getStatus());
    			statement.setString(5, order.getComments());
    			statement.setInt(6,order.getCustomerNumber());


    			statement.executeUpdate();

    		} catch (SQLException throwables) {
    			throwables.printStackTrace();
    		}


    	}
    	
        public void deleteOrders(int orderNumber) throws SQLException {

            PreparedStatement statement;
            try {
                statement = myConn.prepareStatement("DELETE FROM orders WHERE orderNumber=?");
                statement.setInt(1,orderNumber);
                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        public ArrayList<Order> DisplayAllOrders() throws Exception {
            ArrayList<Order> Orderlist= new ArrayList<>();
            Statement myStmt= null;
            ResultSet myRs= null;

            try {
                myStmt= myConn.createStatement();
                myRs=myStmt.executeQuery("select * from orders");

                while(myRs.next()) {
                    Order tempOrder= convertRowToOrderObj(myRs);
                    Orderlist.add(tempOrder);
                }
                return Orderlist;
            }
            finally
            {
                close(myStmt,myRs);
            }

        }
        private Order convertRowToOrderObj(ResultSet myRs) throws SQLException {

            int orderNumber = myRs.getInt("orderNumber");
            String orderDate = myRs.getString("orderDate");
            String requiredDate = myRs.getString("requiredDate");
            String shippedDate = myRs.getString("shippedDate");
            String status= myRs.getString("status");
            String comments= myRs.getString("comments");
            int customerNumber= myRs.getInt("customerNumber");


            Order tempOrder = new Order(orderNumber,orderDate,requiredDate,shippedDate,status,comments,customerNumber);

            return tempOrder;
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

        private void close(Statement myStmt, ResultSet myRs) throws SQLException {
            close(null, myStmt, myRs);
        }
        private static void close(Statement myStmt) throws SQLException {
            close(null, myStmt, null);
        }


        public static void main(String[] args) throws Exception {

            OrderDAO dao = new OrderDAO();
            System.out.println(dao.DisplayAllOrders());
        }

        public static void addOrder(Order anOrder) throws Exception{
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
        


        public ArrayList<Order> searchOrders(String orderDate) throws Exception {
    		ArrayList<Order> listOfOrders = new ArrayList();
    		PreparedStatement prepStmt = null;
            ResultSet result = null;
    		
    		try {
    			prepStmt = myConn.prepareStatement("SELECT * FROM orders WHERE orderDate=?");
    			prepStmt.setString(1, orderDate);
    			result = prepStmt.executeQuery();
    			while (result.next()) {
    				
    				Order temp2 = convertRowToOrderObj(result);
    				listOfOrders.add(temp2);
    			}
    		}
    		
    		catch (SQLException throwables) {
    			throwables.printStackTrace();
    		}
    		return listOfOrders;
        
    }
    }

