package com.ausoft;

import javax.swing.*;
import java.awt.*;

public class CustomerLogin extends JFrame {

    public JTextField txtUserName = new JTextField(30);
    public JTextField txtPassword = new JTextField(30);

    public JButton btnLogin = new JButton("Login");

    public CustomerLogin() {

        this.setTitle("Customer Login");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("User Name"));
        line1.add(txtUserName);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Password"));
        line2.add(txtPassword);
        this.getContentPane().add(line2);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLogin);

        this.getContentPane().add(buttonPanel);

    }

}
