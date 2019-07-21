package com.ausoft;

import java.awt.print.Book;

public interface DataAccess {

    public boolean connect();
    public boolean disconnect();

    public com.ausoft.BookModel loadBook(int id);
    public boolean saveBook(com.ausoft.BookModel p);

    // ... similarly for load/save OrderModel, UserModel, ProviderModel, CustomerModel...
}
