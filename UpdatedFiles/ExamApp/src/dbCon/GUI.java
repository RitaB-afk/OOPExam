package dbCon;
import java.awt.*;
import javax.swing.*;

import GUI.CustomerGUI;
import GUI.EmployeeGUI;
import GUI.OrdersGUI;

import java.awt.event.*;

public class GUI extends JFrame implements ActionListener{

	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Welcome to our exam application!");
	private JLabel label1 = new JLabel("To be able to add, update, delete or retrieve all data from either");
	private JLabel label2 = new JLabel("customer, orders or employees, click one of the buttons");
	private Font fontLabel = new Font("SansSerif", Font.BOLD, 24);
	private JButton b1, b2, b3, b4;
	private JMenuBar menuBar;
	private JMenu menu, menu2, menu3;
	private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6;
	private JMenu subMenu;
	private JCheckBoxMenuItem checkItem1, checkItem2;
	
	
	public GUI() {

		super();
		panel.setLayout(null);
		
		// Buttons
		b1 = new JButton("Customer");
		b1.addActionListener(e -> {
			CustomerGUI app = new CustomerGUI();
			app.setVisible(true);
		});
		b2 = new JButton("Orders");
		b2.addActionListener(e -> {
			OrdersGUI app = new OrdersGUI();
			app.setVisible(true);
		});
		b3 = new JButton("Employees");
		b3.addActionListener(e -> {
			EmployeeGUI app = new EmployeeGUI();
			app.setVisible(true);
		});
		b4 = new JButton("Exit");
		b4.addActionListener(e -> System.exit(0));
		
		// Button placement
		b1.setBounds(50, 110, 200, 70);
		b2.setBounds(300, 110, 200, 70);
		b3.setBounds(50, 220, 200, 70);
		b4.setBounds(175, 350, 200, 40);
		
		// Label placement
		label.setFont(fontLabel);
		label.setBounds(85, 10, 400, 50);
		label1.setBounds(100, 40, 400, 50);
		label2.setBounds(120, 60, 400, 50);
		
		// Adding buttons, label and border
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(label);
		panel.add(label1);
		panel.add(label2);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		
		// Frame values
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Exam Application");
		frame.setSize(550, 500);
		frame.setResizable(false);
		frame.setVisible(true);
		
		// Menu Bar beginning
		menuBar = new JMenuBar();
		
		// Visible menus
		menu = new JMenu("File");
		menuBar.add(menu);
		
		menu2 = new JMenu("Sections");
		menuBar.add(menu2);
		
		menu3 = new JMenu("Help");
		menuBar.add(menu3);
		
		// Menus within menus
		menuItem1 = new JMenuItem("Load");
		menuItem1.addActionListener(this);
		menu.add(menuItem1);
		
		menuItem2 = new JMenuItem("Save");
		menuItem2.addActionListener(this);
		menu.add(menuItem2);
		
		menuItem3 = new JMenuItem("Options");
		menuItem3.addActionListener(this);
		menu.add(menuItem3);
		
		menuItem4 = new JMenuItem("Customer");
		menuItem4.addActionListener(e -> {
			CustomerGUI app = new CustomerGUI();
			app.setVisible(true);
		});
		menu2.add(menuItem4);
		
		menuItem5 = new JMenuItem("Employees");
		menuItem5.addActionListener(e -> {
			EmployeeGUI app = new EmployeeGUI();
			app.setVisible(true);
		});

		
		menuItem6 = new JMenuItem("Orders");
		menuItem6.addActionListener(e -> {
			OrdersGUI app = new OrdersGUI();
			app.setVisible(true);
		});
		menu2.add(menuItem6);

		
		// Submenu within menus' menus
		subMenu = new JMenu("Submenu");
		menu.add(subMenu);
		
		// Checkbox items within submenus
		checkItem1 = new JCheckBoxMenuItem("item #1");
		checkItem1.addActionListener(this);
		subMenu.add(checkItem1);
		
		checkItem2 = new JCheckBoxMenuItem("item #2");
		checkItem2.addActionListener(this);
		subMenu.add(checkItem2);
		
		// Menu Bar sizing 
		frame.setSize(549, 500);
		frame.setJMenuBar(menuBar);
		
	}
			
		
	public static void main(String[] args) {
		new GUI();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
		
		
		
		
		
		

