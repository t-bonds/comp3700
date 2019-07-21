package com.ausoft;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class RemoteDataAccess implements DataAccess {
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    Gson gson = new Gson();

    public boolean connect() {
        try {
            socket = new Socket("localhost", 8008);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Connection to DataServer works!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public boolean disconnect() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean saveProduct(ProductModel product) {
        System.out.println("Request save product with id = " + product.productID);

        try {
            com.ausoft.StoreRequest request = new com.ausoft.StoreRequest(com.ausoft.StoreRequest.SAVE_PRODUCT, gson.toJson(product));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            StoreResponse response = gson.fromJson(ans, StoreResponse.class); // convert JSON string to a response object!

            return (response.code == StoreResponse.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ProductModel loadProduct(int productID) {
        ProductModel product = null;

        System.out.println("Request load product with id = " + productID);

        try {
            StoreRequest request = new StoreRequest(StoreRequest.LOAD_PRODUCT, String.valueOf(productID));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            StoreResponse response = gson.fromJson(ans, StoreResponse.class); // convert JSON string to a response object!

            if (response.code == StoreResponse.OK)
                product = gson.fromJson(response.data, ProductModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }


}
