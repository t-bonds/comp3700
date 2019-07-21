package com.ausoft;


import javax.swing.*;
import java.awt.*;


public class ManageCustomerView extends JFrame {

    public JTextField txtCustomerID = new JTextField(30);
    public JTextField txtCustomerName = new JTextField(30);
    public JTextField txtCustomerEmail = new JTextField(30);
    public JTextField txtCustomerPhone = new JTextField(30);
    public JTextField txtCustomerUsername = new JTextField(30);


    public JButton btnSave = new JButton("Save");

    public ManageCustomerView() {

        this.setTitle("Manage Customer Information");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("Customer ID"));
        line1.add(txtCustomerID);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Customer Name"));
        line2.add(txtCustomerName);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line3.add(new JLabel("Email"));
        line3.add(txtCustomerEmail);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line4.add(new JLabel("Phone Number"));
        line4.add(txtCustomerPhone);
        this.getContentPane().add(line4);

        JPanel line5 = new JPanel();
        line4.add(new JLabel("Username"));
        line4.add(txtCustomerUsername);
        this.getContentPane().add(line5);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSave);

        this.getContentPane().add(buttonPanel);

    }


}