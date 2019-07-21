package com.ausoft;

import javax.swing.*;
import java.awt.*;

public class UserView extends JFrame {



    public JButton btnAdmin = new JButton("Admin");
    public JButton btnManager = new JButton("Manager");
    public JButton btnCashier = new JButton("Cashier");
    public JButton btnCustomer = new JButton("Customer");

    public UserView() {

        this.setTitle("Select User Type");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdmin);
        buttonPanel.add(btnManager);
        buttonPanel.add(btnCashier);
        buttonPanel.add(btnCustomer);


        this.getContentPane().add(buttonPanel);

    }

}
