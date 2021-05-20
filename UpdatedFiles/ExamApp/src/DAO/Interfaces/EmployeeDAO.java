package DAO.Interfaces;

import Classes.Employee;

import java.util.List;

public interface EmployeeDAO{
	List<Employee> getAllEmployees();
	Employee getEmployee(int employeeNumber);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);

}