package com.ausoft;

import java.sql.*;

public class SQLiteDataAccess implements com.ausoft.DataAccess {
    Connection conn = null;

    public boolean connect() {
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


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean disconnect() {
        try {
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }

    public boolean saveReader(com.ausoft.ReaderModel reader) {
        try {
            Statement stmt = conn.createStatement();

            if (loadReader(reader.readerID) == null) {           // this is a new product!
                stmt.execute("INSERT INTO Reader(readerID, nname, address, phoneNum) VALUES ("
                        + reader.readerID + ","
                        + '\'' + reader.name + '\'' + ","
                        + '\'' + reader.address + '\'' + ","
                        + reader.phoneNum + ")"
                );
            }
            else {
                stmt.executeUpdate("UPDATE reader SET "
                        + "readerID = " + reader.readerID + ","
                        + "name = " + '\'' + reader.name + '\'' + ","
                        + "address = " + '\'' + reader.address + '\'' + ","
                        + "phone number = " + reader.phoneNum +
                        " WHERE readerID = " + reader.readerID
                );

            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public com.ausoft.ReaderModel loadReader(int readerID) {
        com.ausoft.ReaderModel reader = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Reader WHERE ReaderID = " + readerID);
            if (rs.next()) {
                reader = new com.ausoft.ReaderModel();
                reader.readerID = rs.getInt(1);
                reader.name = rs.getString(2);
                reader.address = rs.getString(3);
                reader.phoneNum = rs.getDouble(4);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reader;
    }

    public boolean saveBook(com.ausoft.BookModel book) {
        try {
            Statement stmt = conn.createStatement();

            if (loadBook(book.bookID) == null) {           // this is a new product!
                stmt.execute("INSERT INTO Book(bookID, title, author, pageNumbers, publicationYear) VALUES ("
                        + book.bookID + ","
                        + '\'' + book.title + '\'' + ","
                        + '\'' + book.author + '\'' + ","
                        + book.pageNumbers + ","
                        + book.publicationYear + ")"
                );
            }
            else {
                stmt.executeUpdate("UPDATE Book SET "
                        + "bookID = " + book.bookID + ","
                        + "title = " + '\'' + book.title + '\'' + ","
                        + "author = " + '\'' + book.author + '\'' + ","
                        + "page numbers = " + book.pageNumbers + ","
                        + "publication year = " + book.publicationYear +
                        " WHERE bookID = " + book.bookID
                );

            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    public com.ausoft.BookModel loadBook(int bookID) {
        com.ausoft.BookModel book = null;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE BookID = " + bookID);
            if (rs.next()) {
                book = new com.ausoft.BookModel();
                book.bookID = rs.getInt(1);
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


    public com.ausoft.BorrowModel loadBorrow(int id) {
        try {
            com.ausoft.BorrowModel borrow = null;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Borrow WHERE borrowID = " + id);

            if (resultSet.next()) {
                borrow = new com.ausoft.BorrowModel();
                borrow.setBorrowID(resultSet.getInt("BorrowID"));
                borrow.setReaderID(resultSet.getInt("ReaderID"));
              borrow.setStartDate(resultSet.getDate("StartDate"));
                borrow.setDueDate(resultSet.getDate("DueDate"));
                resultSet.close();
                statement.close();
            }

            // loading the order lines for this order
            resultSet = statement.executeQuery("SELECT * FROM BorrowLine WHERE borrowID = " + id);

            while (resultSet.next()) {
                com.ausoft.BorrowLine line = new com.ausoft.BorrowLine();
                line.setBorrowID(resultSet.getInt(1));
                line.setBookID(resultSet.getInt(2));
               line.setStartDate(resultSet.getDouble(3));
               line.setDueDate(resultSet.getDouble(4));
                borrow.addLine(line);
            }

            return borrow;

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveBorrow(com.ausoft.BorrowModel borrow) {
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO Borrow VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, borrow.getBorrowID());
//            statement.setDate(2, borrow.getStartDate());
//            statement.setDouble(3, borrow.getReaderID());
//            statement.setDouble(4, borrow.getDueDate());
//            statement.setDouble(5, borrow.getBookID());

            statement.execute();    // commit to the database;
            statement.close();

            statement = conn.prepareStatement("INSERT INTO BorrowLine VALUES (?, ?, ?, ?)");

            for (com.ausoft.BorrowLine line: borrow.getLines()) { // store for each order line!
                statement.setInt(1, line.getBorrowID());
                statement.setInt(2, line.getBookID());
                statement.setDouble(3, line.getStartDate());
                statement.setDouble(4, line.getDueDate());

                statement.execute();    // commit to the database;
            }
            statement.close();
            return true; // save successfully!
        }
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }

}
