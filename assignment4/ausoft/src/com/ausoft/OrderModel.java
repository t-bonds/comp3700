package com.ausoft;

import java.sql.Timestamp;
import java.util.ArrayList;

public class OrderModel {

    private int orderID;
    private Timestamp timestamp;


    private int customerID;
    private int employeeID;
    private double taxTotal;
    private double total;

    private ArrayList<OrderLine> orderLines = new ArrayList<>();

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void addLine(OrderLine line) {
        orderLines.add(line);
    }

    public ArrayList<OrderLine> getLines() {
        return orderLines;
    }
}


