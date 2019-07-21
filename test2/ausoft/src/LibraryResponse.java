package com.ausoft;

public class LibraryResponse {
    public static final int OK = 0;

    public static final int BOOK_NOT_FOUND = 1;
    public static final int SAVE_BOOK_ERROR = 2;

    public static final int BORROW_NOT_FOUND = 3;
    public static final int SAVE_BORROW_ERROR = 4;

    public int code = 0;
    public String data = "";


}
