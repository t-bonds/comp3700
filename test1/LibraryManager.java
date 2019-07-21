public class LibraryManager {

   static SQLiteDataAccess dao = new SQLiteDataAccess();

   static BookView bookView = new BookView();

   static BookController bookController = new bookController(bookView, dao);

   public static void main(String[] args) {
   
      dao.connect();
      BookModel bo = dao.loadBook(1); // Apple;
    
   
      bo.bookID = 100;
      bo.title = "Harry Potter";
      bo.author = "JK Rowlingn;
      bo.pageNumbers = 1000;
      bo.publicationYear = 1991;
      
   
      dao.saveBook(bo);
   
      prod = dao.loadProduct(100); // Samsung!!!
      if (prod != null)
         System.out.println("Book with ID = " + bo.bookID + " title = " + bo.title + " author = " + bo.author + " number of pages = " + bo.pageNumbers + " publication year = " bo.publicationYear);
   
      bookView.show();
   }
}
