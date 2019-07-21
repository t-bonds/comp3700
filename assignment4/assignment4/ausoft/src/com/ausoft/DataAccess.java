package com.ausoft;

public interface DataAccess {

    public boolean connect();
    public boolean disconnect();

    public com.ausoft.ProductModel loadProduct(int id);
    public boolean saveProduct(com.ausoft.ProductModel p);

    // ... similarly for load/save OrderModel, UserModel, ProviderModel, CustomerModel...
}
