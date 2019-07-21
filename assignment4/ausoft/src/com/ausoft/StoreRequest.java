package com.ausoft;

public class StoreRequest {
    public static final int GOOD_BYE = 0;

    public static final int LOAD_PRODUCT = 1;
    public static final int SAVE_PRODUCT = 2;

    public static final int LOAD_ORDER = 3;
    public static final int SAVE_ORDER = 4;

    int code;
    String data;

    public StoreRequest(int request, String data) {
        this.code = request;
        this.data = data;
    }
}
