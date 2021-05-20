package com.exam.OOPGroup14;

import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;


	public class EmployeeForm extends JFrame implements ActionListener {
		    private Menu Menu;
	

		    private JTextField employeeNumberTextField= new JTextField();
		    private JTextField lastNameTextField= new JTextField();
		    private JTextField firstNameTextField= new JTextField();
		    private JTextField extensionTextField= new JTextField();
		    private JTextField emailTextField= new JTextField();
		    private JTextField officeCodeTextField= new JTextField();
		    private JTextField reportsToTextField= new JTextField();
		    private JTextField jobTitleTextField= new JTextField();
		    private JButton buttonOK;
		    private JButton buttonCancel;

		    private EmployeeDAO EmployeeDAO;

		    private EmployeeApp EmployeeApp;

		    private Employee originalEmployee= null;
		    private boolean update= false;
		    
		    public EmployeeForm(EmployeeApp theEAPP, EmployeeDAO theEDAO) {
		        this();
		        EmployeeDAO=theEDAO;
		        EmployeeApp= theEAPP;
		       

		    }
		    public EmployeeForm(EmployeeApp theEmployeeApp, EmployeeDAO theEmployeeDAO, Employee theoriginalEmployee, boolean Update) {
		        this();
		        EmployeeDAO=theEmployeeDAO;
		        EmployeeApp= theEmployeeApp;
		        originalEmployee= theoriginalEmployee;
		        update= Update;
		        // if the user chooses to update the form's title will change to update employee and we will fill the form with 
		        //the info from the selected employee
		        if (update) {
		            setTitle("Update Employee");
		            fillTheForm(originalEmployee);
		        }

		    }
		
		    private void fillTheForm(Employee theEmployee) {
		        firstNameTextField.setText(theEmployee.getFirstName());
		        lastNameTextField.setText(theEmployee.getLastName());
		        emailTextField.setText(theEmployee.getEmail());
		        employeeNumberTextField.setText(String.valueOf(theEmployee.getEmployeeNumber()));
		        extensionTextField.setText(theEmployee.getExtension());
		        officeCodeTextField.setText(theEmployee.getOfficeCode());
		        reportsToTextField.setText(String.valueOf(theEmployee.getReportto()));
		       jobTitleTextField.setText(theEmployee.getJobTitle());

		    }

		   
		    
		    public EmployeeForm() {
		        setDefaultCloseOperation(HIDE_ON_CLOSE);
		        setTitle("Add Employee");
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

		       builder.append("EmployeeNumber:", employeeNumberTextField);
		        builder.nextLine();


		        builder.append("Last Name:", lastNameTextField);
		        builder.nextLine();

		        builder.append("First Name:", firstNameTextField);
		        builder.nextLine();

		        builder.append("Extension:", extensionTextField);
		        builder.nextLine();

		        builder.append("Email:", emailTextField);
		        builder.nextLine();


		        builder.append("Office Code:", officeCodeTextField);
		        builder.nextLine();

		        builder.append("Reports To:", reportsToTextField);
		        builder.nextLine();

		        builder.append("Job Title:", jobTitleTextField);
		        builder.nextLine();
		        


		        {

		            buttonOK = new JButton("Save");
		            buttonOK.setFont(new Font("Arial", Font.PLAIN, 15));
		            buttonOK.setSize(100, 20);
		            buttonOK.setLocation(450, 600);
		            buttonOK.addActionListener(new ActionListener() {
		                public void actionPerformed(ActionEvent e) {
		                    saveEmployee();
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

		    

		    protected void saveEmployee() {

		        // get the customer info from gui

		    	 String firstName = firstNameTextField.getText();
	                String lastName = lastNameTextField.getText();
	                String email = emailTextField.getText();
	                int employeeNumber = Integer.parseInt(employeeNumberTextField.getText());
	                String extension = extensionTextField.getText();
	                String officeCode = officeCodeTextField.getText();
	                int reportsTo = Integer.parseInt(reportsToTextField.getText());
	                String jobTitle = jobTitleTextField.getText();

	                Employee tempEmployee = null;
	                if (update) {
	                    tempEmployee= originalEmployee;
	                    tempEmployee.setLastName(lastName);
	                    tempEmployee.setFirstName(firstName);
	                    tempEmployee.setExtension(extension);
	                    tempEmployee.setEmail(email);
	                    tempEmployee.setOfficeCode(officeCode);
	                    tempEmployee.setReportto(reportsTo);
	                    tempEmployee.setJobTitle(jobTitle);
	                }
	                else {
	                    //we will create a brand new employee object
	                    tempEmployee = new Employee(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
	                }
	                try {
	                    if (update) {
	                        EmployeeDAO.updateEmployee(tempEmployee);
	                    }
	                    else {
	                        // save to db
	                        EmployeeDAO.addEmployee(tempEmployee);
	                    }
	                    // close form
	                    setVisible(false);
	                    dispose();

	           
	                    JOptionPane.showMessageDialog(EmployeeApp,
	                      "Employee added succesfully.",
	                        "Employee Added",
	                        JOptionPane.INFORMATION_MESSAGE);
	            } catch (Exception exc) {
	                JOptionPane.showMessageDialog(
	                        EmployeeApp,
	                        "Error saving employee: "
	                                + exc.getMessage(), "Error",
	                        JOptionPane.ERROR_MESSAGE);
	            }

	        }
		   public static void main(String[] args) {
		        EmployeeForm dialog = new EmployeeForm();


		        dialog.setVisible(true);

		    }

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == buttonOK) {
		            saveEmployee();
		        } else if (e.getSource() == buttonCancel) {
		            setVisible(false);
		            dispose();
		        }
		    }
		}




