package com.ausoft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController implements ActionListener {

    com.ausoft.ProductView myView;
    CheckoutView checkoutView;
    ReturnView returnView;
    RemoteDataAccess myDB;

    public ProductController(ProductView view, CheckoutView view1, ReturnView view2, RemoteDataAccess dao) {
        myView = view;
        myDB = dao;
        checkoutView = view1;
        returnView = view2;
        myView.btnLoad.addActionListener(this);
        myView.btnSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myView.btnLoad) {      // button Load is clicked
            loadProductAndDisplay();
        }

        if (e.getSource() == myView.btnSave) {      // button Load is clicked
            saveProduct();
        }

        if (e.getSource() == checkoutView.btnLoad) {      // button Load is clicked
            loadProductAndDisplay();
        }

        if (e.getSource() == checkoutView.btnPay) {      // button Load is clicked
            checkout();
        }

        if (e.getSource() == returnView.btnLoad) {      // button Load is clicked
            loadProductAndDisplay();
        }

        if (e.getSource() == returnView.btnReturn) {      // button Load is clicked
            returnItem();
        }

    }

    private void saveProduct() {
        ProductModel productModel = new ProductModel();

        try {
            int productID = Integer.parseInt(myView.txtProductID.getText());
            productModel.productID = productID;
            productModel.name = myView.txtProductName.getText();
            productModel.price = Double.parseDouble(myView.txtProductPrice.getText());
            productModel.quantity = Double.parseDouble(myView.txtProductQuantity.getText());

            myDB.saveProduct(productModel);
            JOptionPane.showMessageDialog(null, "Product saved successfully!");


        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ProductID");
            ex.printStackTrace();
        }    }

    private void loadProductAndDisplay() {
        try {
            int productID = Integer.parseInt(myView.txtProductID.getText());
            ProductModel productModel = myDB.loadProduct(productID);
            if (productModel != null) {
                myView.txtProductName.setText(productModel.name);
                myView.txtProductPrice.setText(String.valueOf(productModel.price));
                myView.txtProductQuantity.setText(String.valueOf(productModel.quantity));
            }
            else
                JOptionPane.showMessageDialog(null, "No product with that ID!");
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ProductID");
            ex.printStackTrace();
        }
    }

    private void checkout() {
        ProductModel productModel = new ProductModel();
        int productID = Integer.parseInt(myView.txtProductID.getText());
        productModel.productID = productID;

        if (productModel != null) {
            if (productModel.productID == productID) {
                productModel.quantity -= 1;
                JOptionPane.showMessageDialog(null, "Item Checked Out! Total: " + myView.txtProductPrice.getText());
            }
        }
    }

    private void returnItem() {
        ProductModel productModel = new ProductModel();
        int productID = Integer.parseInt(myView.txtProductID.getText());
        productModel.productID = productID;

        if (productModel != null) {
            if (productModel.productID == productID) {
                productModel.quantity += 1;
                JOptionPane.showMessageDialog(null, "Item Returned");
            }
        }
    }
}
