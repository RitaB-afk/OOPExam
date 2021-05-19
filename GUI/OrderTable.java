package com.exam.OOPGroup14;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;

public class OrderTable extends AbstractTableModel {

    public static final int OBJECT_COL = -1 ;
    private static final int ORD_DATE_COL = 1;
    private static final int REQ_DATE_COL = 2;
    private static final int STAT_COL = 4;
    private static final int ORD_NUM_COL=0;
    private static final int SHIP_DATE_COL=3;
    private static final int COM_COL= 5;
    private static final int CUS_NUM_COL=6;
    


    private String[] columnNames = { "orderNumber", "orderDate", "requiredDate", "shippedDate", "status", "comments", "customerNumber"};
    private ArrayList<Order> orders;

    public OrderTable(ArrayList<Order> AllOrders) {
        orders = AllOrders;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Order selOrder = orders.get(row);

         switch (col) {
            case ORD_NUM_COL: return selOrder.getOrderNumber();
            
            case REQ_DATE_COL: return selOrder.getRequiredDate();
            case SHIP_DATE_COL: return selOrder.getShippedDate();
            case STAT_COL: return selOrder.getStatus();
            case COM_COL: if (selOrder.getComments()== null)
                return "No comment";
            case CUS_NUM_COL: return selOrder.getCustomerNumber();
            case OBJECT_COL: return selOrder;
            default: return selOrder.getOrderDate();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
