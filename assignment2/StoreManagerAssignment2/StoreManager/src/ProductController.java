import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController implements ActionListener {

    ProductView myView;
    CheckoutView myView1;
    SQLiteDataAccess myDB;
    public ProductController(ProductView view, CheckoutView view1, SQLiteDataAccess dao) {
        myView = view;
        myView1 = view1;
        myDB = dao;
        myView.btnLoad.addActionListener(this);
        myView.btnSave.addActionListener(this);
        myView.btnCheckout.addActionListener(this);
        myView1.btnLoad.addActionListener(this);
        myView1.btnPay.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myView.btnLoad) {     // button Load is clicked
            loadProductAndDisplay();
        }


        if (e.getSource() == myView.btnSave) {      // button Save is clicked
            saveProduct();
        }

        if (e.getSource() == myView.btnCheckout) {
            myView1.setVisible(true);

        }

        if (e.getSource() == myView1.btnLoad) {
            loadProductAndDisplayCheckout();
        }

        if (e.getSource() == myView1.btnPay) {
            payProduct();
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
            myView.txtProductName.setText(productModel.name);
            myView.txtProductPrice.setText(String.valueOf(productModel.price));
            myView.txtProductQuantity.setText(String.valueOf(productModel.quantity));

        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ProductID");
            ex.printStackTrace();
        }
    }

    private void loadProductAndDisplayCheckout() {
        try {

            int productID = Integer.parseInt(myView1.txtProductID.getText());
            ProductModel productModel = myDB.loadProduct(productID);
            myView1.txtProductName.setText(productModel.name);
            myView1.txtProductPrice.setText(String.valueOf(productModel.price));
            myView1.txtProductQuantity.setText(String.valueOf(productModel.quantity));

        }

        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format for ProductID");
            ex.printStackTrace();
        }
    }

    private void payProduct() {

    JOptionPane.showMessageDialog(null, "Total: " + myView1.txtProductPrice.getText());

    }
}
