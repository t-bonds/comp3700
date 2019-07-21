package com.ausoft;

class BorrowLine {
    private int borrowID;
    private int bookID;
    private double startDate;
    private double dueDate;


    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public double getStartDate() {
        return startDate;
    }

    public void setStartDate(double units) {
        this.startDate = units;
    }

    public double getDueDate() {
        return dueDate;
    }

    public void setDueDate(double dueDate) {
        this.dueDate = dueDate;
    }
}
