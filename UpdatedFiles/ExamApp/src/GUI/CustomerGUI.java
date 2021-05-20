package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAO.DAOCustomer;
import dbCon.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerGUI extends JFrame {

		private JPanel panel1;
		private JTextField inputField;
		private JLabel request;
		private JButton Search;
		private JButton Add;
		private JScrollPane scrollPane;
		private JTable table1;

		private DAOCustomer cusDAO;
		
		private JButton UpdateButton;
		private JButton DeleteButton;
		private JButton StoreButton;
		private JButton ImportButton;
		private JButton BackToMainMenu;
		
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CustomerGUI Customerwin = new CustomerGUI();
						Customerwin.setVisible(true);
					} catch (Exception e) {
						System.out.println("Message: "+ e);
					}
				}
			});
		}

		// constructor to create the window
		public CustomerGUI() {
			
			// create the DAO
			try {
				cusDAO = new DAOCustomer();
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
					String sql = ""
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
					
				}
			});
			panel_1.add(Add);
			UpdateButton = new JButton("Update Customer");
	        UpdateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
	        panel_1.add(UpdateButton);
	        DeleteButton= new JButton("Delete Customer");
	        DeleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
	        
	        
	        panel_1.add(DeleteButton);
	        StoreButton= new JButton("Store to File");
	        StoreButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
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
		
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}