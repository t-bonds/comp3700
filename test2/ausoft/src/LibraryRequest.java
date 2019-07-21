package com.ausoft;

public class LibraryRequest {
    public static final int GOOD_BYE = 0;

    public static final int LOAD_BOOK = 1;
    public static final int SAVE_BOOK = 2;

    public static final int LOAD_BORROW = 3;
    public static final int SAVE_BORROW = 4;

    int code;
    String data;

    public LibraryRequest(int request, String data) {
        this.code = request;
        this.data = data;
    }
}
