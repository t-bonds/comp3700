package com.ausoft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController implements ActionListener {

    com.ausoft.UserView myView;
    ProductController productController;
    AdminLogin adminLogin;
    AdminView adminView;
    ManagerLogin managerLogin;
    ManagerView managerView;
    CashierLogin cashierLogin;
    CashierView cashierView;
    CustomerLogin customerLogin;
    CustomerView customerView;
    ProductView productView;
    NewUserView newUserView;
    ManageCustomerView manageCustomerView;
    CustomerOrdersView customerOrdersView;
    ChangePasswordView changePasswordView;
    RemoteDataAccess myDB;

    public UserController(UserView view, AdminLogin view1, AdminView view2, ManagerLogin view3, ManagerView view4,
                          CashierLogin view5, CashierView view6, CustomerLogin view7, CustomerView view8,
                          ProductView view9, NewUserView view10, ChangePasswordView view11, ManageCustomerView view12, CustomerOrdersView cview, RemoteDataAccess dao, ProductController prod) {
        myView = view;
        adminLogin = view1;
        adminView = view2;
        managerLogin = view3;
        managerView = view4;
        cashierLogin = view5;
        cashierView = view6;
        customerLogin = view7;
        customerView = view8;
        productView = view9;
        newUserView = view10;
        changePasswordView = view11;
        manageCustomerView = view12;
        customerOrdersView = cview;
        myDB = dao;
        productController = prod;
        myView.btnAdmin.addActionListener(this);
        myView.btnManager.addActionListener(this);
        myView.btnCashier.addActionListener(this);
        myView.btnCustomer.addActionListener(this);
        adminLogin.btnLogin.addActionListener(this);
        adminView.btnCreateNewUser.addActionListener(this);
        adminView.btnChangePassword.addActionListener(this);
        adminView.btnLogOut.addActionListener(this);
        managerLogin.btnLogin.addActionListener(this);
        managerView.btnUpdateProduct.addActionListener(this);
        managerView.btnLogOut.addActionListener(this);
        cashierLogin.btnLogin.addActionListener(this);
        cashierView.btnMakeOrder.addActionListener(this);
        cashierView.btnReturnOrder.addActionListener(this);
        cashierView.btnLogOut.addActionListener(this);
        customerLogin.btnLogin.addActionListener(this);
        customerView.btnManageInfo.addActionListener(this);
        customerView.btnViewOrders.addActionListener(this);
        customerView.btnLogOut.addActionListener(this);
        productView.btnLoad.addActionListener(this);
        productView.btnSave.addActionListener(this);
        newUserView.btnCreate.addActionListener(this);
        changePasswordView.btnChange.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myView.btnAdmin) {
            adminLogin.setVisible(true);
        }

        if (e.getSource() == adminLogin.btnLogin) {
            adminLogin();
        }

        if (e.getSource() == adminView.btnCreateNewUser) {
            newUserView.setVisible(true);
        }

        if (e.getSource() == newUserView.btnCreate) {
            createNewUser();
        }

        if (e.getSource() == adminView.btnChangePassword) {
            changePasswordView.setVisible(true);
        }

        if (e.getSource() == changePasswordView.btnChange) {
            changePassword();
        }

        if (e.getSource() == adminView.btnLogOut) {
            logOut();
        }

        if (e.getSource() == myView.btnManager) {
            managerLogin.setVisible(true);
        }

        if (e.getSource() == managerLogin.btnLogin) {
            managerLogin();
        }

        if (e.getSource() == managerView.btnUpdateProduct) {
            productView.setVisible(true);
        }

        if (e.getSource() == managerView.btnLogOut) {
            logOut();
        }

        if (e.getSource() == cashierLogin.btnLogin) {
            cashierLogin();
        }

        if (e.getSource() == cashierView.btnMakeOrder) {
            productController.checkoutView.setVisible(true);
        }

        if (e.getSource() == cashierView.btnReturnOrder) {
            productController.returnView.setVisible(true);
        }

        if (e.getSource() == cashierView.btnLogOut) {
            logOut();
        }

        if (e.getSource() == myView.btnCustomer) {
            customerLogin.setVisible(true);
        }

        if (e.getSource() == customerLogin.btnLogin) {
            customerLogin();
        }

        if (e.getSource() == customerView.btnManageInfo) {
            manageCustomerView.setVisible(true);
        }

        if (e.getSource() == manageCustomerView.btnSave) {
            manageCustomer();
        }

        if (e.getSource() == customerView.btnViewOrders) {
            customerOrdersView.setVisible(true);
        }

        if (e.getSource() == customerOrdersView.btnLoad) {
            loadOrders();
        }

        if (e.getSource() == customerView.btnLogOut) {
            logOut();
        }

    }


    private void adminLogin() {

        UserModel userModel = new UserModel();
        AdminView adminView = new AdminView();

        try {

            if (userModel.getUsername().equals(adminLogin.txtUserName.getText()) && userModel.getPassword().equals(adminLogin.txtPassword.getText())) {

                userModel.setRole(0);
                adminView.setVisible(true);

            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
            ex.printStackTrace();
        }    }

        private void createNewUser() {

        UserModel userModel = new UserModel();
        NewUserView newUserView = new NewUserView();

            userModel.setRole(Integer.parseInt(newUserView.txtUserType.getText()));
            userModel.setUsername(newUserView.txtUserName.getText());
            if (newUserView.txtPassword.getText() == newUserView.txtConfirm.getText()) {

                userModel.setPassword(newUserView.txtPassword.getText());

            }

        }

        private void changePassword() {

        UserModel userModel = new UserModel();
        ChangePasswordView changePasswordView = new ChangePasswordView();
        if (userModel.getPassword() == changePasswordView.txtCurrent.getText()) {
            if (changePasswordView.txtNew.getText() == changePasswordView.txtConfirm.getText()) {
                userModel.setPassword(changePasswordView.txtNew.getText());
            }
        }
        }


    private void managerLogin() {

        UserModel userModel = new UserModel();
        ManagerView managerView = new ManagerView();


        try {
            if (userModel.getUsername().equals(managerLogin.txtUserName.getText()) && userModel.getPassword().equals(managerLogin.txtPassword.getText())) {

                userModel.setRole(1);
                managerView.setVisible(true);

            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
            ex.printStackTrace();
        }    }

    private void cashierLogin() {

        UserModel userModel = new UserModel();
        CashierView cashierView = new CashierView();

        try {
            if (userModel.getUsername().equals(cashierLogin.txtUserName.getText()) && userModel.getPassword().equals(cashierLogin.txtPassword.getText())) {

                userModel.setRole(2);
                cashierView.setVisible(true);

            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
            ex.printStackTrace();
        }    }

    private void customerLogin() {

        UserModel userModel = new UserModel();
        CustomerView customerView = new CustomerView();

        try {
            if (userModel.getUsername().equals(customerLogin.txtUserName.getText()) && userModel.getPassword().equals(customerLogin.txtPassword.getText())) {

                userModel.setRole(3);
                customerView.setVisible(true);

            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
            ex.printStackTrace();
        }    }

        private void logOut() {
        JOptionPane.showMessageDialog(null, "Log Out Successful");
            System.exit(0);
        }

    private void loadOrders() {
        try {
            int productID = Integer.parseInt(customerOrdersView.txtProductID.getText());
            ProductModel productModel = myDB.loadProduct(productID);
            if (productModel != null) {
                customerOrdersView.txtProductName.setText(productModel.name);
                customerOrdersView.txtProductPrice.setText(String.valueOf(productModel.price));
                customerOrdersView.txtProductQuantity.setText(String.valueOf(productModel.quantity));
            }
            else
                JOptionPane.showMessageDialog(null, "No order with that ID!");
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for OrderID");
            ex.printStackTrace();
        }
    }

    private void manageCustomer() {

        UserModel userModel = new UserModel();
        ManageCustomerView manageCustomerView = new ManageCustomerView();

        if (manageCustomerView.txtCustomerUsername.getText() != null) {

            userModel.setUsername(manageCustomerView.txtCustomerUsername.getText());

        }
    }
}

