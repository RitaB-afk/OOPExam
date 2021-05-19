package DAO;

import java.sql.*;
import java.util.ArrayList;

import Classes.Customers;
import Classes.Employee;
import dbCon.DAO;

public class DAOEmployee {
	
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

public ArrayList<Employee> searchEmployees(String jobTitle) throws Exception {
	ArrayList<Employee> listOfEmployees = new ArrayList();
	
	try {
		prepStmt = myConn.prepareStatement("SELECT * FROM employees WHERE jobTitle = ?");
		prepStmt.setString(1, jobTitle);
		result = prepStmt.executeQuery();
		while (result.next()) {
			
			Employee temp2 = convertToEmployee(result);
			listOfEmployees.add(temp2);
		}
		
		return listOfEmployees;
	}
	
	catch (SQLException throwables) {
		throwables.printStackTrace();
	}
	
	
	return null;
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

	public void updateEmployee(Employee employee) {
	
		PreparedStatement statement;
		try {
			statement = myConn.prepareStatement("UPDATE employees SET lastName = ?, firstName = ?, extension = ?, email = ?, officeCode = ? , reportsTo = ?, jobTitle = ? WHERE employeeNumber = ?");
	
			statement.setString(1, employee.getLastName());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getExtension());
			statement.setString(4, employee.getEmail());
			statement.setString(5, employee.getOfficeCode());
			statement.setInt(6, employee.getReportsTo());
			statement.setString(7, employee.getJobTitle());
			statement.setInt(8,employee.getEmployeeNumber());
	
			statement.executeQuery();
	
		} catch (SQLException throwables) {
			throwables.printStackTrace();
	}

}


public void deleteEmployee(Employee employeeNumber) {
	
        PreparedStatement statement;
        try {
            statement = myConn.prepareStatement("DELETE FROM employee WHERE employeeNumber = ?");
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


public static void addEmployee(Employee anEmployee) throws Exception{
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
        myStmt.setInt(7, anEmployee.getReportsTo());
        myStmt.setString(8, anEmployee.getJobTitle());

        //execute SQL
        myStmt.executeUpdate();
    }
    catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}
		

}
