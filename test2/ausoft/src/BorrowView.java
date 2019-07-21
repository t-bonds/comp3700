package com.ausoft;

import javax.swing.*;
import java.awt.*;

public class BorrowView extends JFrame {

    public JTextField txtBorrowID = new JTextField(30);
    public JTextField txtBookID = new JTextField(30);
    public JTextField txtReaderID = new JTextField(30);
    public JTextField txtStartDate = new JTextField(30);
    public JTextField txtDueDate = new JTextField(30);

    public JButton btnLoad = new JButton("Load");
    public JButton btnSave = new JButton("Save");

    public BorrowView() {

        this.setTitle("Borrow View");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("Borrow ID"));
        line1.add(txtBorrowID);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Book ID"));
        line2.add(txtBookID);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line2.add(new JLabel("Reader ID"));
        line2.add(txtReaderID);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line3.add(new JLabel("Start Date"));
        line3.add(txtStartDate);
        this.getContentPane().add(line4);

        JPanel line5 = new JPanel();
        line4.add(new JLabel("Due Date"));
        line4.add(txtDueDate);
        this.getContentPane().add(line5);




        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);

        this.getContentPane().add(buttonPanel);

    }

}
