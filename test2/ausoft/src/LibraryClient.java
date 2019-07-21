package com.ausoft;


public class LibraryClient {

    static com.ausoft.RemoteDataAccess dao = new com.ausoft.RemoteDataAccess();

    static com.ausoft.BookView bookView = new com.ausoft.BookView();

    static com.ausoft.BookController bookController = new com.ausoft.BookController(bookView, dao);

    public static void main(String[] args) {

        dao.connect();
        com.ausoft.BookModel book = dao.loadBook(1); // Apple;
        if (book != null)
            System.out.println("Book with ID = " + book.bookID + " title = " + book.title + " author = " + book.author + " page numbers = " + book.pageNumbers + " publication year = " + book.publicationYear);

        book.bookID = 100;
        book.title = "The Call Of Cthulhu";
        book.author = "H.P. Lovecraft";
        book.pageNumbers = 399;
        book.publicationYear = 1919;

        dao.saveBook(book);

        book = dao.loadBook(100); // Samsung!!!
        if (book != null)
            System.out.println("Book with ID = " + " title = " + book.title + " author = " + book.author + " page numbers = " + book.pageNumbers + " publication year = " + book.publicationYear);

        bookView.setVisible(true);
    }
}
