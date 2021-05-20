package DAO.Interfaces;
import Classes.Customers;

import java.util.List;

public interface CustomerDAO {
	public List<Customers> getAllCustomers();
	public Customers getCustomer(int customerNumber);
	public void updateCustomer(Customers customer);
	public void deleteCustomer(Customers customer);
	public void createCustomer(Customers customer);
}