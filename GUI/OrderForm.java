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

public class OrderForm extends JFrame implements ActionListener {
    private Menu Menu;
	

    private JTextField orderNumberTextField= new JTextField();
    private JTextField orderDateTextField= new JTextField();
    private JTextField requiredDateTextField= new JTextField();
    private JTextField shippedDateTextField= new JTextField();
    private JTextField statusTextField= new JTextField();
    private JTextField commentsTextField= new JTextField();
    private JTextField customernumberTextField= new JTextField();
    private JButton buttonOK;
    private JButton buttonCancel;
    
    private OrderDAO OrderDAO;

    private OrderApp OrderApp;

    
    
    public OrderForm(OrderApp OrderApp, OrderDAO theOrderDAO) {
        this();
	    OrderDAO=theOrderDAO;
        OrderApp= theOrderApp;
        
    }
    private void populateGUI(Order theOrder) {
    	orderNumberTextField.setText(String.valueOf(theOrder.getOrderNumber()));
        orderDateTextField.setText(theOrder.getOrderDate());
        requiredDateTextField.setText(theOrder.getRequiredDate());
        shippedDateTextField.setText(String.valueOf(theOrder.getShippedDate()));
        statusTextField.setText(theOrder.getStatus());
        commentsTextField.setText(theOrder.getComments());
        customernumberTextField.setText(String.valueOf(theOrder.getCustomerNumber()));
       
    }

   
    
    public OrderForm() {
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

       builder.append("Order Number:", orderNumberTextField);
        builder.nextLine();


        builder.append("Order Date (yyyy-mm-dd):", orderDateTextField);
        builder.nextLine();

        builder.append("Required Date (yyyy-mm-dd):", requiredDateTextField);
        builder.nextLine();

        builder.append("Shipped Date (yyyy-mm-dd):", shippedDateTextField);
        builder.nextLine();

        builder.append("Status:", statusTextField);
        builder.nextLine();


        builder.append("comments:", commentsTextField);
        builder.nextLine();

        builder.append("Customer Number:", customernumberTextField);
        builder.nextLine();

        {

            buttonOK = new JButton("Save");
            buttonOK.setFont(new Font("Arial", Font.PLAIN, 15));
            buttonOK.setSize(100, 20);
            buttonOK.setLocation(450, 600);
            buttonOK.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    saveOrder();
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

    

    protected void saveOrder() {

        // get the customer info from gui

    	 int orderNumber = Integer.parseInt(orderNumberTextField.getText());
            String orderDate = orderDateTextField.getText();
            String requiredDate = requiredDateTextField.getText();
            String shippedDate = shippedDateTextField.getText();
            String status = statusTextField.getText();
            int customerNumber = Integer.parseInt(customernumberTextField.getText());
            String comments = commentsTextField.getText();

       Order tempOrder= null;

       

        tempOrder = new Order(orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);
        try {
           
            
            OrderDAO.addOrder(tempOrder);

            // close dialog
            setVisible(false);
            dispose();

            // refresh gui list
            /*CustomerSearchApp.refreshCustomerView();*/

            // show success message
            JOptionPane.showMessageDialog(OrderApp,
                    "Order added succesfully.",
                    "Order Added",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(
                    OrderApp,
                    "Error saving order: "
                            + exc.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

   public static void main(String[] args) {
       OrderForm dialog = new OrderForm();


        dialog.setVisible(true);

    }

    
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == buttonOK) {
	            saveOrder();
	        } else if (e.getSource() == buttonCancel) {
	            setVisible(false);
	            dispose();
	        }
		
	}
	
}

