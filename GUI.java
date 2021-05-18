import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener{

	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Welcome to our exam application!");
	private JButton b1, b2, b3, b4, b5;
	private JMenuBar menuBar;
	private JMenu menu, menu2, menu3;
	private JMenuItem menuItem1, menuItem2, menuItem3;
	private JMenu subMenu;
	private JCheckBoxMenuItem checkItem1, checkItem2;
	
	
	public GUI() {

		super();
		panel.setLayout(null);
		
		// Buttons
		b1 = new JButton("Add customer");
		b2 = new JButton("Listing orders");
		b3 = new JButton("Retrieve all employees");
		b4 = new JButton("Bulk import from file");
		b5 = new JButton("Exit");
		
		// Button placement
		b1.setBounds(50, 100, 200, 70);
		b2.setBounds(300, 100, 200, 70);
		b3.setBounds(50, 220, 200, 70);
		b4.setBounds(300, 220, 200, 70);
		b5.setBounds(175, 350, 200, 40);
		
		// Label placement
		label.setBounds(185, 40, 400, 50);
		
		// Adding buttons, label and border
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(label);
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
		
		menu2 = new JMenu("Actions");
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
		
		
		
		
		
		

