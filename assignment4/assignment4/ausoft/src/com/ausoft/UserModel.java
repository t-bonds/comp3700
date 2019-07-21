package com.ausoft;

public class UserModel {
    public static int ADMIN = 0;
    public static int MANAGER = 1;
    public static int CASHIER = 2;
    public static int CUSTOMER = 3;


    private int role;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {return role;}

    public void setRole(int role) {this.role = role;}
}
