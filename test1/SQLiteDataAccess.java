import java.sql.*;

public class SQLiteDataAccess {
   Connection conn = null;

   public void connect() {
      try {
         // db parameters
         String url = "jdbc:sqlite:store.db";
         // create a connection to the database
         Class.forName("org.sqlite.JDBC");
      
         conn = DriverManager.getConnection(url);
      
         if (conn == null)
            System.out.println("Cannot make the connection!!!");
         else
            System.out.println("The connection object is " + conn);
      
         System.out.println("Connection to SQLite has been established.");
      
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Pook");
      
         while (rs.next())
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
      
      
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }

   public void saveBook(BookModel book) {
      try {
         Statement stmt = conn.createStatement();
      
         if (loadBook(book.bookID) == null) {           // this is a new product!
            stmt.execute("INSERT INTO Book(bookID, title, author, pageNumbers, publicationYear) VALUES ("
                   + book.bookID + ","
                   + '\'' + book.title + '\'' + ","
                   + book.author + "," + '\''
                   + book.pageNumbers ","
                   + book.publicationYear + ")"
               );
         }
         else {
            stmt.executeUpdate("UPDATE Book SET "
                   + "bookID = " + book.bookID + ","
                   + "title = " + '\'' + book.title + '\'' + ","
                   + "author = " + '\'' + book.author + '\'' + ","
                   + "pageNumbers = " + book.pageNumbers + ","
                   + "publicationYear = " + book.publicationYear +
                   " WHERE bookID = " + book.bookID
               );
         
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

   public ProductModel loadBook(int bookID) {
      BookModel book = null;
      try {
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Product WHERE ProductID = " + productID);
         if (rs.next()) {
            book = new BookModel();
            book.productID = rs.getString(1);
            book.title = rs.getString(2);
            book.author = rs.getString(3);
            book.pageNumbers = rs.getDouble(4);
            book.publicationYear = rs.getDouble(5);
         }
      
      } catch (Exception ex) {
         ex.printStackTrace();
      }
      return book;
   }


}
