import java.awt.*;
import javax.swing.*;


public class GUI extends JFrame{

	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Welcome to our exam application!");
	private JButton b1, b2, b3, b4, b5;
	
	
	
	public GUI() {

		super();
		panel.setLayout(null);
		
		b1 = new JButton("Add customer");
		b2 = new JButton("Listing orders");
		b3 = new JButton("Retrieve all employees");
		b4 = new JButton("Bulk import from file");
		b5 = new JButton("Exit");
		
		b1.setBounds(50, 100, 200, 70);
		b2.setBounds(300, 100, 200, 70);
		b3.setBounds(50, 220, 200, 70);
		b4.setBounds(300, 220, 200, 70);
		b5.setBounds(175, 350, 200, 40);
		
		label.setBounds(185, 40, 400, 50);
		
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(label);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Exam Application");
		frame.setSize(550, 500);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	

	
	
	public static void main(String[] args) {
		new GUI();
		
	}



}
