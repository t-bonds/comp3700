package com.ausoft;


import javax.swing.*;
import java.awt.*;


public class CashierView extends JFrame {


    public JButton btnMakeOrder = new JButton("Create New Order"); // only one item per time
    public JButton btnReturnOrder = new JButton("Return Order"); // only one item per time
    public JButton btnLogOut = new JButton("Log Out");

    public CashierView() {


        this.setTitle("Cashier View");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnMakeOrder);
        buttonPanel.add(btnReturnOrder);
        buttonPanel.add(btnLogOut);

        this.getContentPane().add(buttonPanel);

    }


}
