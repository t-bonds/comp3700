package com.ausoft;

import javax.swing.*;
import java.awt.*;

public class BookView extends JFrame {

    public JTextField txtBookID = new JTextField(30);
    public JTextField txtBookTitle = new JTextField(30);
    public JTextField txtBookAuthor = new JTextField(30);
    public JTextField txtPageNumbers = new JTextField(30);
    public JTextField txtPublicationYear = new JTextField(30);

    public JButton btnLoad = new JButton("Load");
    public JButton btnSave = new JButton("Save");

    public BookView() {

        this.setTitle("Book View");
        this.setSize(new Dimension(600, 300));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));    // make this window with box layout

        JPanel line1 = new JPanel();
        line1.add(new JLabel("Book ID"));
        line1.add(txtBookID);
        this.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Book Title"));
        line2.add(txtBookTitle);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line2.add(new JLabel("Book Author"));
        line2.add(txtBookAuthor);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line3.add(new JLabel("Page Numbers"));
        line3.add(txtPageNumbers);
        this.getContentPane().add(line4);

        JPanel line5 = new JPanel();
        line4.add(new JLabel("Publication Year"));
        line4.add(txtPublicationYear);
        this.getContentPane().add(line5);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);

        this.getContentPane().add(buttonPanel);

    }

}
