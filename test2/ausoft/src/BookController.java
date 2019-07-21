package com.ausoft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookController implements ActionListener {

    com.ausoft.BookView myView;
    com.ausoft.RemoteDataAccess myDB;

    public BookController(com.ausoft.BookView view, com.ausoft.RemoteDataAccess dao) {
        myView = view;
        myDB = dao;
        myView.btnLoad.addActionListener(this);
        myView.btnSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myView.btnLoad) {      // button Load is clicked
            loadBookAndDisplay();
        }

        if (e.getSource() == myView.btnSave) {      // button Load is clicked
            saveBook();
        }

    }

    private void saveBook() {
        com.ausoft.BookModel bookModel = new com.ausoft.BookModel();

        try {
            int bookID = Integer.parseInt(myView.txtBookID.getText());
            bookModel.bookID = bookID;
            bookModel.title = myView.txtBookTitle.getText();
            bookModel.author = myView.txtBookAuthor.getText();
            bookModel.pageNumbers = Double.parseDouble(myView.txtPageNumbers.getText());
            bookModel.publicationYear = Double.parseDouble(myView.txtPublicationYear.getText());

            myDB.saveBook(bookModel);
            JOptionPane.showMessageDialog(null, "Book saved successfully!");


        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for BookID");
            ex.printStackTrace();
        }    }

    private void loadBookAndDisplay() {
        try {
            int bookID = Integer.parseInt(myView.txtBookID.getText());
            com.ausoft.BookModel bookModel = myDB.loadBook(bookID);
            if (bookModel != null) {
                myView.txtBookTitle.setText(bookModel.title);
                myView.txtBookAuthor.setText(bookModel.author);
                myView.txtPageNumbers.setText(String.valueOf(bookModel.pageNumbers));
                myView.txtPublicationYear.setText(String.valueOf(bookModel.publicationYear));
            }
            else
                JOptionPane.showMessageDialog(null, "No book with that ID!");
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for BookID");
            ex.printStackTrace();
        }
    }
}
