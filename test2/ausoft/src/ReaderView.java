package com.ausoft;

import javax.swing.*;
import java.awt.*;

public class ReaderView extends JFrame {

    public JTextField txtReaderID = new JTextField(30);
    public JTextField txtReaderName = new JTextField(30);
    public JTextField txtReaderAddress = new JTextField(30);
    public JTextField txtPhoneNum = new JTextField(30);


    public JButton btnLoad = new JButton("Load");
    public JButton btnSave = new JButton("Save");

    public ReaderView() {

        this.setTitle("Reader View");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("Reader ID"));
        line1.add(txtReaderID);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Name"));
        line2.add(txtReaderName);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line2.add(new JLabel("Address"));
        line2.add(txtReaderAddress);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line3.add(new JLabel("Phone Number"));
        line3.add(txtPhoneNum);
        this.getContentPane().add(line4);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);

        this.getContentPane().add(buttonPanel);

    }

}



