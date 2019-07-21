import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookController implements ActionListener {

   BookView myView;
   SQLiteDataAccess myDB;
   public ProductController(BookView view, SQLiteDataAccess dao) {
      myView = view;
      myDB = dao;
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
   
   }

   private void saveBook() {
      BookModel bookModel = new BookModel();
   
      try {
         int bookID = Integer.parseInt(myView.txtBookID.getText());
         bookModel.bookID = bookID;
         bookModel.title = myView.txtBookTitle.getText();
         bookModel.author = myView.txtBookAuthor.getText();
         bookModel.pageNumbers = Double.parseDouble(myView.txtPageNumbers.getText());
         bookModel.publicationYear = Double.parseDouble(myView.txtPublicationYear.getText());
      
         myDB.saveProduct(bookModel);
         JOptionPane.showMessageDialog(null, "book saved successfully!");
      
      
      }
      catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(null, "Invalid format for bookID");
         ex.printStackTrace();
      }    }

   private void loadProductAndDisplay() {
      try {
         int bookID = Integer.parseInt(myView.txtBookID.getText());
         BookModel bookModel = myDB.loadBook(bookID);
         myView.txtBookTitle.setText(bookModel.title);
         myView.txtBookAuthor.setText(bookModel.author);
         myView.txtPageNumbers.setText(String.valueOf(bookModel.pageNumbers));
         myView.txtPublicationYear.setText(String.valueOf(bookModel.publiocationYear));
      
      }
      catch (NumberFormatException ex) {
         JOptionPane.showMessageDialog(null, "Invalid format for BookID");
         ex.printStackTrace();
      }
   }
}
