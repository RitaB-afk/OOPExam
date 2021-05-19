package com.exam.OOPGroup14;

import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;

public class customerTable extends AbstractTableModel{

	private static final int CUST_NAME_COL = 1;
    private static final int CON_LASTNAME_COL = 2;
    private static final int CON_FIRSTNAME_COL = 3;
    private static final int PHONE_COL = 4;
    private static final int CUST_NUM_COL=0;
    private static final int ADDRESS1_COL_COL=5;
    //private static final int ADDRESS2_COL= 6;
    private static final int CITY_COL=6;
    //private static final int STATE_COL=7;
    private static final int POST_COL = 7;
    private static final int COUNTR_COL = 8;
    private static final int SALESREP_COL = 9;
    private static final int CRED_COL = 10;

    private String[] columnNames = {"customerNumber","customerName","contactLastName","contactFirstName", "phone","AddressLine","City","PostalCode","Country","SalesRep", "creditLimit"};
    private ArrayList<Customer> customers;

    public customerTable(ArrayList<Customer> theCustomers) {
        customers = theCustomers;
    }
    @Override
    public int getRowCount() {
        return customers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Customer tempCustomer = customers.get(row);

        switch (col) {
            case CON_FIRSTNAME_COL: return tempCustomer.getContactFirstName();
            case CON_LASTNAME_COL: return tempCustomer.getContactLastName();
            case CUST_NUM_COL: return tempCustomer.getCustomerNumber();
            case PHONE_COL: return tempCustomer.getPhone();
	            case ADDRESS1_COL_COL: if (tempCustomer.getAddressLine2()== null)
	                return tempCustomer.getAddressLine1();
            else
                return tempCustomer.getAddressLine1()+","+tempCustomer.getAddressLine2();

            case CITY_COL: return tempCustomer.getCity();
            //case STATE_COL -> tempCustomer.getState();
            case POST_COL: return tempCustomer.getPostalCode();
            case COUNTR_COL:
                if (tempCustomer.getCountry().equals("USA")) return tempCustomer.getState()+","+ tempCustomer.getCountry();
                else return tempCustomer.getCountry();
            case SALESREP_COL: return tempCustomer.getSalesRepEmployeeNumber();
            case CRED_COL: return tempCustomer.getCreditLimit();
            //case OBJECT_COL: return tempCustomer;
            default: return tempCustomer.getCustomerName();
        }
    }
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}
