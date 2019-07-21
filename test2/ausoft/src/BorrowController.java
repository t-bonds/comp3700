package com.ausoft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class BorrowController implements ActionListener {

    com.ausoft.BorrowView myView;
    com.ausoft.RemoteDataAccess myDB;

    public BorrowController(com.ausoft.BorrowView view, com.ausoft.RemoteDataAccess dao) {
        myView = view;
        myDB = dao;
        myView.btnLoad.addActionListener(this);
        myView.btnSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myView.btnLoad) {      // button Load is clicked
            loadBorrowAndDisplay();
        }

        if (e.getSource() == myView.btnSave) {      // button Load is clicked
            saveBorrow();
        }

    }

    public void saveBorrow() {
        com.ausoft.BorrowModel borrowModel = new com.ausoft.BorrowModel();

        try {
            int borrowID = Integer.parseInt(myView.txtBorrowID.getText());
            borrowModel.borrowID = borrowID;
            int bookID = Integer.parseInt(myView.txtBookID.getText());
            borrowModel.bookID = bookID;
            int readerID = Integer.parseInt(myView.txtReaderID.getText());
            borrowModel.readerID = readerID;
            Date startDate = Integer.parseInt(myView.txtStartDate.getText());
            borrowModel.startDate = startDate;
            Date dueDate = Integer.parseInt(myView.txtDueDate.getText());
            borrowModel.dueDate = dueDate;


            myDB.saveBorrow(borrowModel);
            JOptionPane.showMessageDialog(null, "Book saved successfully!");


        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for BookID");
            ex.printStackTrace();
        }    }

    private void loadBorrowAndDisplay() {
        try {
            int borrowID = Integer.parseInt(myView.txtBorrowID.getText());
            com.ausoft.BookModel borrowModel = myDB.loadBorrow(borrowID);
            if (borrowModel != null) {
                myView.txtBookID.setText(borrowModel.bookID);
                myView.txtReaderID.setText(borrowModel.readerID);
                myView.txtStartDate.setText(String.valueOf(borrowModel.startDate));
                myView.txtDueDate.setText(String.valueOf(borrowModel.dueDate));
            }
            else
                JOptionPane.showMessageDialog(null, "No borrow record with that ID!");
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for BorrowID");
            ex.printStackTrace();
        }
    }
}
