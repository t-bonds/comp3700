package com.ausoft;


import javax.swing.*;
import java.awt.*;


public class NewUserView extends JFrame {

    public JTextField txtUserType = new JTextField(30);
    public JTextField txtUserName = new JTextField(30);
    public JTextField txtPassword = new JTextField(30);
    public JTextField txtConfirm = new JTextField(30);

    public JButton btnCreate = new JButton("Create User");


    public NewUserView() {

        this.setTitle("Create New User");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("User Type: 0 = 'admin', 1 = 'manager', 2 = 'cashier', 3 = 'customer' "));
        line1.add(txtUserType);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("User Name"));
        line2.add(txtUserName);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line3.add(new JLabel("Password"));
        line3.add(txtPassword);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line4.add(new JLabel("Confirm Password"));
        line4.add(txtConfirm);
        this.getContentPane().add(line4);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnCreate);


        this.getContentPane().add(buttonPanel);

    }


}
