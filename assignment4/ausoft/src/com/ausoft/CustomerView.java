package com.ausoft;


import javax.swing.*;
import java.awt.*;


public class CustomerView extends JFrame {


    public JButton btnManageInfo = new JButton("Manage Information");
    public JButton btnViewOrders = new JButton("View Orders");
    public JButton btnLogOut = new JButton("Log Out");

    public CustomerView() {


        this.setTitle("Customer View");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnManageInfo);
        buttonPanel.add(btnViewOrders);
        buttonPanel.add(btnLogOut);

        this.getContentPane().add(buttonPanel);

    }


}
