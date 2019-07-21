package com.ausoft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderController implements ActionListener {

    com.ausoft.ReaderView myView;
    com.ausoft.RemoteDataAccess myDB;

    public void BookController(com.ausoft.ReaderView view, com.ausoft.RemoteDataAccess dao) {
        myView = view;
        myDB = dao;
        myView.btnLoad.addActionListener(this);
        myView.btnSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myView.btnLoad) {      // button Load is clicked
            loadReaderAndDisplay();
        }

        if (e.getSource() == myView.btnSave) {      // button Load is clicked
            saveReader();
        }

    }

    private void saveReader() {
        com.ausoft.ReaderModel readerModel = new com.ausoft.ReaderModel();

        try {
            int readerID = Integer.parseInt(myView.txtReaderID.getText());
            readerModel.readerID = readerID;
            readerModel.name = myView.txtReaderName.getText();
            readerModel.address = myView.txtReaderAddress.getText();
            readerModel.phoneNum = Double.parseDouble(myView.txtPhoneNum.getText());

            myDB.saveReader(readerModel);
            JOptionPane.showMessageDialog(null, "Reader saved successfully!");


        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ReaderID");
            ex.printStackTrace();
        }    }

    private void loadReaderAndDisplay() {
        try {
            int readerID = Integer.parseInt(myView.txtReaderID.getText());
            com.ausoft.ReaderModel readerModel = myDB.loadReader(readerID);
            if (readerModel != null) {
                myView.txtReaderName.setText(readerModel.name);
                myView.txtReaderAddress.setText(readerModel.address);
                myView.txtPhoneNum.setText(String.valueOf(readerModel.phoneNum));
            }
            else
                JOptionPane.showMessageDialog(null, "No reader with that ID!");
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for readerID");
            ex.printStackTrace();
        }
    }
}
