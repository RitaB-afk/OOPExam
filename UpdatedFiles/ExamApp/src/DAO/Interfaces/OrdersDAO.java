package DAO.Interfaces;

import Classes.Orders;

import java.util.ArrayList;

public interface OrdersDAO {
    ArrayList<Orders> getAllOrders();
    Orders getOrders(int ordersNumber);
    void updateOrders(Orders employee);
    void deleteOrders(Orders employee);
}
