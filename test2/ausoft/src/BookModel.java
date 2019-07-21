package com.ausoft;

public class BookModel {
    public int bookID;
    public String title;
    public String author;
    public double pageNumbers;
    public double publicationYear;

    @Override
    public String toString() {
        return "" + bookID + "," + title + "," +  author + "," + pageNumbers + "," + publicationYear;
    }
}



