package com.ausoft;

public class ReaderModel {
    public int readerID;
    public String name;
    public String address;
    public double phoneNum;


    @Override
    public String toString() {
        return "" + readerID + "," + name + "," +  address + "," + phoneNum;
    }
}

