package com.ausoft;

public class ProductModel {
    public int productID;
    public String name;
    public double price;
    public double quantity;

    @Override
    public String toString() {
        return "" + productID + "," + name + "," + price + "," + quantity;
    }
}



