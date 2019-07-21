package com.ausoft;

public class StoreResponse {
    public static final int OK = 0;

    public static final int PRODUCT_NOT_FOUND = 1;
    public static final int SAVE_PRODUCT_ERROR = 2;

    public static final int ORDER_NOT_FOUND = 3;
    public static final int SAVE_ORDER_ERROR = 4;

    public int code = 0;
    public String data = "";


}
