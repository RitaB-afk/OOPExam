package com.exam.OOPGroup14;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomerApp extends JFrame {

		private JPanel panel1;
		private JTextField inputField;
		private JLabel request;
		private JButton Search;
		private JButton Add;
		private JScrollPane scrollPane;
		private JTable table1;

		private CustomerDAO cusDAO;
		
		
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
			
			request = new JLabel("Enter customer's last name");
			panel.add(request);
			
			inputField = new JTextField();
			panel.add(inputField);
			inputField.setColumns(15);
			
			Search = new JButton("Search");
			Search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
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
					
				}
			});
			panel_1.add(Add);
		}

		
		}

	



