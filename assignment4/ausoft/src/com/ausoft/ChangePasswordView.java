package com.ausoft;


import javax.swing.*;
import java.awt.*;


public class ChangePasswordView extends JFrame {

    public JTextField txtUsername = new JTextField(30);
    public JTextField txtCurrent = new JTextField(30);
    public JTextField txtNew = new JTextField(30);
    public JTextField txtConfirm = new JTextField(30);

    public JButton btnChange = new JButton("Change Password");


    public ChangePasswordView() {

        this.setTitle("Change Password");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("User Name"));
        line1.add(txtUsername);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Current Password"));
        line2.add(txtCurrent);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line3.add(new JLabel("New Password"));
        line3.add(txtNew);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line4.add(new JLabel("Confirm New Password"));
        line4.add(txtConfirm);
        this.getContentPane().add(line4);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnChange);


        this.getContentPane().add(buttonPanel);

    }


}