package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Classes.Employee;
import DAO.DAOEmployee;
import DAO.Interfaces.EmployeeDAO;
import Tables.EmployeeTable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class EmployeeGUI extends JFrame {
    private final JPanel panel1;
   
    private JButton searchButton;
    private JButton Addbutton;
    private JButton UpdateButton;
    private JButton DeleteButton;
    private JTable table1;
    private JScrollPane scrollPane;

    private DAOEmployee employeeDAO;
    private JPanel panel_1;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmployeeGUI frame = new EmployeeGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public EmployeeGUI() {
        // create the DAO
        try {
            employeeDAO = new DAOEmployee();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }
        setTitle("Employee Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 650, 450);
		panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(20, 25, 20, 15));
		panel1.setLayout(new BorderLayout(0, 0));
		setContentPane(panel1);
		

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 55, 50, 55));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		panel1.add(panel, BorderLayout.NORTH);

        JLabel Query = new JLabel("Pick JobTitle");
        panel.add(Query);

        JCheckBox presidentBox=  new JCheckBox ("President", false);
        JCheckBox VPSBox= new JCheckBox("VP Sales", false);
        JCheckBox SMABox= new JCheckBox("SM (APAC)", false);
        JCheckBox SMEBox= new JCheckBox("SM (EMEA)", false);
        JCheckBox SMNBox= new JCheckBox("SM (NA)", false);
        JCheckBox SRBox= new JCheckBox("Sales Rep", false);
        panel.add(presidentBox);
        panel.add(VPSBox);
        panel.add(SMABox);
        panel.add(SMEBox);
        panel.add(SMNBox);
        panel.add(SRBox);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        panel.add(searchButton);
        
        scrollPane = new JScrollPane();
        panel1.add(scrollPane, BorderLayout.CENTER);

        table1 = new JTable();
        scrollPane.setViewportView(table1);

        panel_1 = new JPanel();
        panel1.add(panel_1, BorderLayout.SOUTH);

        Addbutton = new JButton("Add Employee");
        Addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        panel_1.add(Addbutton);

        UpdateButton = new JButton("Update Employee");
	            UpdateButton.addActionListener(e -> {
        		updateEmployee();
        });
        UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        panel_1.add(UpdateButton);
        DeleteButton= new JButton("Delete Employee");
        DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        panel_1.add(DeleteButton);


    }

    public void refreshEmployeesView() {

        try {
            ArrayList<Employee> employees = employeeDAO.retrieveAllEmployees();

            // create the model and update the "table"
            EmployeeTable model = new EmployeeTable(employees);

            table1.setModel(model);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}
