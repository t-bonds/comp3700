package com.ausoft;


import javax.swing.*;
import java.awt.*;


public class ManagerView extends JFrame {


    public JButton btnUpdateProduct = new JButton("Update Product");
    public JButton btnLogOut = new JButton("Log Out");

    public ManagerView() {


        this.setTitle("Manager View");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnUpdateProduct);
        buttonPanel.add(btnLogOut);

        this.getContentPane().add(buttonPanel);

    }


}
