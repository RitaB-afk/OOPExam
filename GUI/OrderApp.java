package com.exam.OOPGroup14;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class OrderApp extends JFrame {
	private JPanel panel1;
	
	private JLabel request;
	private JButton Search;
	private JButton Add;
	private JScrollPane scrollPane;
	private JTable table1;

	private OrderDAO orDAO;

	private JButton UpdateButton;

	private JButton DeleteButton;

	private JButton StoreButton;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderApp Orwin = new OrderApp();
					Orwin.setVisible(true);
				} catch (Exception e) {
					System.out.println("Message: "+ e);
				}
			}
		});
	}

	// constructor to create the window
	public OrderApp() {
		
		// create the DAO
		try {
			orDAO = new OrderDAO();
		} catch (Exception e) {
			System.out.println("Message:" + e); 
		}
		
		setTitle("Order Window");
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
		
		request = new JLabel("Enter Order date");
		panel.add(request);
		
		{
            String[] year= {"2003","2004","2005"};
            JComboBox yearChoice = new JComboBox(year);
            String[] month={"01","02","03","04","05","06","07","08","09","10","11","12"};
            JComboBox monthChoice= new JComboBox(month);
            String[] day={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
            JComboBox dayChoice= new JComboBox(day);
            panel.add(yearChoice);
            panel.add(monthChoice);
            panel.add(dayChoice);

        }
		
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
        
         Add = new JButton("Add Order");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_1.add(Add);
		UpdateButton = new JButton("Update Order");
        UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        panel_1.add(UpdateButton);
        DeleteButton= new JButton("Delete Order");
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

	}

	

}
