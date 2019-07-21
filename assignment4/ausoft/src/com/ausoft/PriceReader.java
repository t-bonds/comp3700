package com.ausoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*; 
        
public class PriceReader {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8008);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            JFrame readFrame = new JFrame();
            readFrame.setSize(new Dimension(600, 400));
            readFrame.getContentPane().setLayout(new BoxLayout(readFrame.getContentPane(), BoxLayout.PAGE_AXIS));
            JTextField txtID = new JTextField(10);
            readFrame.getContentPane().add(txtID);

            JButton buttonRead = new JButton("Read");
            readFrame.getContentPane().add(buttonRead);
            readFrame.setVisible(true);

            buttonRead.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String id = txtID.getText();
                        out.println(id);
                        out.flush();

                        String price = in.readLine();

                        JOptionPane.showMessageDialog(null, "Received product information: " + price);
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}