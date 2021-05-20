package com.exam.OOPGroup14;

import java.io.FileInputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeDAO {
    private static Connection myConn;



    public EmployeeDAO () throws Exception {

        //get db properties
        Properties props = new Properties();
        props.load(new FileInputStream("lib/info.properties"));

        String user= props.getProperty("user");
        String password= props.getProperty("password");
        String dburl= props.getProperty("dburl");

        //connect to database
        myConn= DriverManager.getConnection(dburl, user, password);
        System.out.println("Connection to db " + dburl + " successful");
    }

    public void deleteEmployee(int employeeNumber) throws SQLException {
    PreparedStatement myStmt= null;
    try {
        //prepare statement
        myStmt= myConn.prepareStatement("delete from employees where employeeNumber=?");
        //set param
        myStmt.setInt(1,employeeNumber);
        //execute SQL
        myStmt.executeUpdate();
    }
    finally {
    close(myStmt);
    }
    }



    public ArrayList<Employee> getAllEmployees() throws Exception {
   ArrayList<Employee> list= new ArrayList<>();
    Statement myStmt= null;
    ResultSet myRs= null;

   try {
      myStmt= myConn.createStatement();
      myRs=myStmt.executeQuery("select * from employees");

    while(myRs.next()) {
        Employee tempEmployee= convertRowToEmployee(myRs);
        list.add(tempEmployee);
    }
    return list;
    }
    finally
    {
        close(myStmt,myRs);
    }

}
public void addEmployee(Employee anEmployee) throws Exception{
        PreparedStatement myStmt= null;

        try {
            //prepare statement
            myStmt = myConn.prepareStatement("insert into employees"
                    + " (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)" + "values (?,?,?,?,?,?,?,?)");


            //set params
            myStmt.setInt(1, anEmployee.getEmployeeNumber());
            myStmt.setString(2, anEmployee.getLastName());
            myStmt.setString(3, anEmployee.getFirstName());
            myStmt.setString(4, anEmployee.getExtension());
            myStmt.setString(5, anEmployee.getEmail());
            myStmt.setString(6, anEmployee.getOfficeCode());
            myStmt.setInt(7, anEmployee.getReportto());
            myStmt.setString(8, anEmployee.getJobTitle());

            //execute SQL
            myStmt.executeUpdate();
        }
        finally {
            close(myStmt);
            }
}
public static void updateEmployee(Employee theEmployee) throws SQLException {
        PreparedStatement myStmt= null;

        try{
            //prepare statement
            myStmt= myConn.prepareStatement("update employees"
                    + " set lastName=?, firstName=?, extension=?, email=?, officeCode=?, reportsTo=?, jobTitle=?"
            + "where employeeNumber=?");
        myStmt.setString(1, theEmployee.getLastName());
        myStmt.setString(2, theEmployee.getFirstName());
        myStmt.setString(3, theEmployee.getExtension());
        myStmt.setString(4, theEmployee.getEmail());
        myStmt.setString(5, theEmployee.getOfficeCode());
        myStmt.setInt(6,theEmployee.getReportto());
        myStmt.setString(7, theEmployee.getJobTitle());
            myStmt.setInt(8, theEmployee.getEmployeeNumber());

        //execute SQL
            myStmt.executeUpdate();
        }
        finally {
            close(myStmt);}

}
    public ArrayList<Employee> searchEmployees(String jobTitle) throws Exception {
        ArrayList<Employee> list = new ArrayList<>();

        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            jobTitle += "%";
            myStmt = myConn.prepareStatement("select * from employees where jobTitle like ?");

            
			myStmt.setString(1, jobTitle);

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                Employee tempEmployee = convertRowToEmployee(myRs);
                list.add(tempEmployee);
            }

            return list;
        }
        finally {
            close(myStmt, myRs);
        }
    }


        private Employee convertRowToEmployee(ResultSet myRs) throws SQLException {

            int employeeNumber = myRs.getInt("employeeNumber");
            String lastName = myRs.getString("lastName");
            String firstName = myRs.getString("firstName");
            String email = myRs.getString("email");
            int reportsTo = myRs.getInt("reportsTo");
            String jobTitle= myRs.getString("jobTitle");
            String officeCode= myRs.getString("officeCode");
            String extension= myRs.getString("extension");


            Employee tempEmployee = new Employee(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);

            return tempEmployee;
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

        EmployeeDAO dao = new EmployeeDAO();
        System.out.println(dao.searchEmployees("thom"));

        System.out.println(dao.getAllEmployees());
    }
    }

