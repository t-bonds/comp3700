package com.ausoft;

class OrderLine {
    private int orderID;
    private int productID;
    private double amount;
    private double price;
    private double subTotal;
    private double taxTotal;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double units) {
        this.amount = units;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
