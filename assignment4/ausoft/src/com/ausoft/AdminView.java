package com.ausoft;


import javax.swing.*;
import java.awt.*;


public class AdminView extends JFrame {


    public JButton btnCreateNewUser = new JButton("Create New User");
    public JButton btnChangePassword = new JButton("Change Password");
    public JButton btnLogOut = new JButton("Log Out");

    public AdminView() {


        this.setTitle("Administrator View");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnCreateNewUser);
        buttonPanel.add(btnChangePassword);
        buttonPanel.add(btnLogOut);

        this.getContentPane().add(buttonPanel);

    }


}
