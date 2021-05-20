package com.exam.OOPGroup14;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerApp extends JFrame implements DocumentManager {

		private JPanel panel1;
		private JTextField inputField;
		private JLabel request;
		private JButton Search;
		private JButton Add;
		private JScrollPane scrollPane;
		private JTable table1;
		

		private CustomerDAO cusDAO;
		private JButton UpdateButton;
		private JButton DeleteButton;
		private JButton StoreButton;
		private JButton ImportButton;
		
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CustomerApp Customerwin = new CustomerApp();
						Customerwin.setVisible(true);
					} catch (Exception e) {
						System.out.println("Message: "+ e);
					}
				}
			});
		}

		// constructor to create the window
		public CustomerApp() {
			
			// create the DAO
			try {
				cusDAO = new CustomerDAO();
			} catch (Exception e) {
				System.out.println("Message:" + e); 
			}
			
			setTitle("Customer Window");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(250, 100, 650, 450);
			panel1 = new JPanel();
			panel1.setBorder(new EmptyBorder(20, 15, 20, 15));
			panel1.setLayout(new BorderLayout(0, 0));
			setContentPane(panel1);
			
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.CENTER);
			panel1.add(panel, BorderLayout.NORTH);
			
			request = new JLabel("Enter customer's name");
			panel.add(request);
			
			inputField = new JTextField();
			panel.add(inputField);
			inputField.setColumns(15);
			
			Search = new JButton("Search");
			Search.addActionListener(new ActionListener() {
				

				public void actionPerformed(ActionEvent e) {
					try {
	                    String customerName = inputField.getText();

	                    ArrayList<Customer> customers = null;

	                    if (customerName != null && customerName.trim().length() > 0) {
	                        customers = cusDAO.searchCustomers(customerName);
	                    } else {
	                        customers = cusDAO.displayAllCustomers();
	                    }

	                    // create the model and update the "table"
	                    customerTable model = new customerTable(customers);

	                   table1.setModel(model);


						for (Customer temp : customers) {
							System.out.println(temp);
						}

	                } catch (Exception exc) {
	                    JOptionPane.showMessageDialog(CustomerApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
	                }


	            }
	        });
			panel.add(Search);
			
			scrollPane = new JScrollPane();
			panel1.add(scrollPane, BorderLayout.CENTER);
			
			table1 = new JTable();
			scrollPane.setViewportView(table1);
			
			JPanel panel_1 = new JPanel();
	        panel1.add(panel_1, BorderLayout.SOUTH);
	        
	         Add = new JButton("Add Customer");
			Add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CustomerForm add = new CustomerForm(CustomerApp.this,cusDAO);
					add.setVisible(true);
				}
			});
			panel_1.add(Add);
			UpdateButton = new JButton("Update Customer");
	        UpdateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table1.getSelectedRow();
					 Customer tempCustomer = (Customer) table1.getValueAt(row, customerTable.Cust_COL);

		             

		                CustomerForm form = new CustomerForm(CustomerApp.this, cusDAO,tempCustomer, true);

		                
		                form.setVisible(true);
					
				}
			});
	        panel_1.add(UpdateButton);
	        DeleteButton= new JButton("Delete Customer");
	        DeleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table1.getSelectedRow();
					 Customer tempCustomer = (Customer) table1.getValueAt(row, customerTable.Cust_COL);
					 try {
						cusDAO.deleteCustomer(tempCustomer.getCustomerNumber());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
	        
	        
	        panel_1.add(DeleteButton);
	        StoreButton= new JButton("Store to File");
	        
			StoreButton.addActionListener(ep -> {JFileChooser fc = new JFileChooser();
				
	            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	            fc.setDialogTitle("Specify a file to save");

	            //set default folder
	            fc.setCurrentDirectory(new File("C:\\Users\\Rita.DESKTOP-NDQVPRR\\OneDrive\\Bureau\\Objectoriented programming 2"));

	            // adding filter to only accept .txt
	            FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
	            fc.setFileFilter(filter);

	            int returnVal = fc.showSaveDialog(null);

	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File fileToSave = fc.getSelectedFile();

	                try {
	                    CustomerDAO dao = new CustomerDAO();
	                    JTextField LastNametextField= new JTextField();

	                    String customerName = LastNametextField.getText();


	                    if (customerName != null && customerName.trim().length() > 0) {

	                        writeToFile(String.valueOf(dao.searchCustomers(customerName)), fileToSave);
	                    }
	                    else {

	                        writeToFile(String.valueOf(dao.displayAllCustomers()),fileToSave);

	                    }

	                    JOptionPane.showMessageDialog(this, "Successful Update ", "Update",
	                            JOptionPane.INFORMATION_MESSAGE);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                    JOptionPane.showMessageDialog(this, "Unsuccessful update", "Update",
	                            JOptionPane.INFORMATION_MESSAGE);
	                }

	            }
		});
					
			
	        panel_1.add(StoreButton);
	        ImportButton= new JButton("Import from file");
	        ImportButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
	        panel_1.add(ImportButton);


		}

		@Override
		public void writeToFile(String text, File file) throws IOException {
			 BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		        writer.write(text);
		        writer.close();
			
		}

		@Override
		public String readFromFile(File file) throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		
		}

	



