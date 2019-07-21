package com.ausoft;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BorrowModel {

    public int borrowID;
    public Timestamp timestamp;


    public int bookID;
    public int readerID;
    public Date startDate;
    public Date dueDate;

    private ArrayList<com.ausoft.BorrowLine> borrowLines = new ArrayList<>();

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public void setBookID(int bookID) {this.bookID = bookID;}

    public int getBookID() {return bookID;}

    public int getReaderID() {
        return readerID;
    }

    public Date getStartDate() {return startDate;}

    public void setStartDate(Date startDate) {this.startDate = startDate;}

    public Date getDueDate() {return dueDate;}

    public void setDueDate(Date dueDate) {this.dueDate = dueDate;}

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public void addLine(com.ausoft.BorrowLine line) {
        borrowLines.add(line);
    }

    public ArrayList<com.ausoft.BorrowLine> getLines() {
        return borrowLines;
    }
}


