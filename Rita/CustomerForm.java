package com.exam.OOPGroup14;

import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

public class CustomerForm extends JFrame implements ActionListener {
	    private Menu Menu;
	    

	    private final JTextField customerNumberTextField= new JTextField();
	    private final JTextField customerNameTextField= new JTextField();
	    private final JTextField contactLastNameTextField= new JTextField();
	    private final JTextField contactFirstNameTextField= new JTextField();
	    private final JTextField phoneTextField= new JTextField();
	    private final JTextField addressLine1TextField= new JTextField();
	    private final JTextField addressLine2TextField= new JTextField();
	    private final JTextField cityTextField= new JTextField();
	    private final JTextField stateTextField= new JTextField();
	    private final JTextField postalCodeTextField= new JTextField();
	    private final JTextField countryTextField= new JTextField();
	    private final JTextField salesrepTextField= new JTextField();
	    private final JTextField creditLimitTextField= new JTextField();

	    private final JButton buttonOK;
	    private final JButton buttonCancel;


	    private CustomerDAO CustomerDAO;

	private CustomerApp CustomerApp;
	private Customer originalCustomer= null;
	public static boolean update= false;

	   
	    public CustomerForm(CustomerApp theCSA, CustomerDAO theCustomerDAO, Customer theoriginalCustomer, boolean Update) {
	        this();
	        CustomerDAO = theCustomerDAO;
	        CustomerApp= theCSA;
	        originalCustomer= theoriginalCustomer;
	        update= Update;

	        if (update) {
	            setTitle("Update the selected customer");
	            fillTheForm(originalCustomer);
	        }
	    }
	    
	    public CustomerForm(CustomerApp theCSA,
	                          CustomerDAO theCustomerDAO) {
	        this(theCSA, theCustomerDAO, null, false);
	    }
	    
	private void fillTheForm(Customer theCustomer){
	    customerNumberTextField.setText(String.valueOf(theCustomer.getCustomerNumber()));
	    customerNameTextField.setText(theCustomer.getCustomerName());
	    contactLastNameTextField.setText(theCustomer.getContactLastName());
	    contactFirstNameTextField.setText(theCustomer.getContactFirstName());
	    phoneTextField.setText(theCustomer.getPhone());
	    addressLine1TextField.setText(theCustomer.getAddressLine1());
	    addressLine2TextField.setText(theCustomer.getAddressLine2());
	    cityTextField.setText(theCustomer.getCity());
	    stateTextField.setText(theCustomer.getState());
	    postalCodeTextField.setText(theCustomer.getPostalCode());
	    countryTextField.setText(theCustomer.getCountry());
	    salesrepTextField.setText(String.valueOf(theCustomer.getSalesRepEmployeeNumber()));
	    creditLimitTextField.setText(theCustomer.getCreditLimit().toString());

	}
	    public CustomerForm() {
	        setDefaultCloseOperation(HIDE_ON_CLOSE);
	        setTitle("Add Customer");
	        setBounds(100, 100, 550, 500);

	        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(""));
	        builder.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	        builder.appendColumn("center:pref");
	        builder.appendColumn("3dlu");
	        builder.appendColumn("fill:max(pref; 100px)");
	        builder.appendColumn("5dlu");
	        builder.appendColumn("center:pref");
	        builder.appendColumn("3dlu");
	        builder.appendColumn("fill:max(pref; 100px)");

	       builder.append("CustomerNumber:", customerNumberTextField);
	        builder.nextLine();

	        builder.append("CustomerName:", customerNameTextField);
	        builder.nextLine();

	        builder.append("ContactLastName:", contactLastNameTextField);
	        builder.nextLine();

	        builder.append("ContactFirstName:", contactFirstNameTextField);
	        builder.nextLine();

	        builder.append("Phone:", phoneTextField);
	        builder.nextLine();

	        builder.append("AddressLine1:", addressLine1TextField);
	        builder.nextLine();


	        builder.append("AddressLine2:", addressLine2TextField);
	        builder.nextLine();

	        builder.append("City:", cityTextField);
	        builder.nextLine();

	        builder.append("PostalCode:", postalCodeTextField);
	        builder.nextLine();
	        builder.append("Country:", countryTextField);
	        builder.nextLine();
	        builder.append("SalesRepEmNumber:", salesrepTextField);
	        builder.nextLine();
	        builder.append("CreditLimit:", creditLimitTextField);
	        builder.nextLine();


	        {

	            buttonOK = new JButton("Save");
	            buttonOK.setFont(new Font("Arial", Font.PLAIN, 15));
	            buttonOK.setSize(100, 20);
	            buttonOK.setLocation(450, 600);
	            buttonOK.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                	saveCustomer();
	                  
	                }
	            });



	            {
	                buttonCancel = new JButton("Cancel");
	                buttonCancel.setFont(new Font("Arial", Font.PLAIN, 15));
	                buttonCancel.setSize(100, 20);
	                buttonCancel.setLocation(570, 600);
	                buttonCancel.addActionListener(this);


	            }
	        builder.append(buttonOK);
	            builder.append(buttonCancel);

	        add(builder.getPanel());





	        }
	    }
	    protected void saveCustomer() {

	        // get the customer info from gui

	        int customerNumber = Integer.parseInt(customerNumberTextField.getText());
	        String customerName = customerNameTextField.getText();
	        String contactLastName = contactLastNameTextField.getText();
	        String contactFirstName = contactFirstNameTextField.getText();
	        String phone = phoneTextField.getText();
	        String addressLine1 = addressLine1TextField.getText();
	        String addressLine2 = addressLine2TextField.getText();
	        String city = cityTextField.getText();
	        String state = stateTextField.getText();
	        String postalCode = postalCodeTextField.getText();
	        String country = countryTextField.getText();
	        int salesRepEmployeeNumber = Integer.parseInt(salesrepTextField.getText());
	        String creditLimitstr = creditLimitTextField.getText();
	        BigDecimal creditLimit = convertStringToBigDecimal(creditLimitstr);

	        Customer tempCustomer= new Customer(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
	        
	        if (update) {
	            tempCustomer= originalCustomer;
	            tempCustomer.setCustomerName(customerName);
	            tempCustomer.setContactFirstName(contactLastName);
	            tempCustomer.setContactFirstName(contactFirstName);
	            tempCustomer.setPhone(phone);
	            tempCustomer.setAddressLine1(addressLine1);
	            tempCustomer.setAddressLine2(addressLine2);
	            tempCustomer.setCity(city);
	            tempCustomer.setState(state);
	            tempCustomer.setPostalCode(postalCode);
	            tempCustomer.setCountry(country);
	            tempCustomer.setSalesRepEmployeeNumber(salesRepEmployeeNumber);
	            tempCustomer.setCreditLimit(creditLimit);
	        } else {

	            tempCustomer = new Customer(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
	        }
	        try {
	        	
	        
	            //set in db
	            if (update){
	                CustomerDAO dao= new CustomerDAO();
	                dao.updateCustomer(tempCustomer);
	            }
	            
	            else{
            CustomerDAO.addCustomer(tempCustomer);}

            // close dialog
            setVisible(false);
            dispose();

            // refresh gui list
            /*CustomerSearchApp.refreshCustomerView();*/

            // show success message
            JOptionPane.showMessageDialog(CustomerApp,
                    "Customer added succesfully.",
                    "Customer Added",
                    JOptionPane.INFORMATION_MESSAGE);
        
	            } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    CustomerApp,
                    "Error saving customer: "
                            + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);}
        }


	    protected BigDecimal convertStringToBigDecimal(String creditLimitstr) {

	        BigDecimal result;

	        try {
	            double cl = Double.parseDouble(creditLimitstr);

	            result = BigDecimal.valueOf(cl);
	        } catch (Exception exc) {
	            System.out.println("Invalid value. Defaulting to 0.0");
	            result = BigDecimal.valueOf(0.0);
	        }

	        return result;
	    }

	    

	   public static void main(String[] args) {
	        CustomerForm dialog = new CustomerForm();


	        dialog.setVisible(true);

	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	   
	    }
	


