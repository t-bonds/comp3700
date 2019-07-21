package com.ausoft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import com.google.gson.*;

public class StoreTeller extends Thread {
    protected Socket socket;
    protected DataAccess dao;

    public StoreTeller(Socket incoming, DataAccess dao) {
        this.socket = incoming;
        this.dao = dao;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()));

            while (true) {
                String str = in.readLine();
                if (str == null) break; // client closed connection
                System.out.println("Received from client: " + str);

                Gson gson = new Gson();
                StoreRequest request = gson.fromJson(str, StoreRequest.class);
                StoreResponse response = new StoreResponse();


                if (request.code == StoreRequest.GOOD_BYE) break; // the client wants to stop!

                if (request.code == StoreRequest.LOAD_PRODUCT) {
                    int id = Integer.parseInt(request.data);
                    ProductModel prod = dao.loadProduct(id);

                    if (prod == null)
                        response.code = StoreResponse.PRODUCT_NOT_FOUND;
                    else
                        response.data = gson.toJson(prod);

                    out.println(gson.toJson(response));
                    out.flush();
                    continue;
                }

                if (request.code == StoreRequest.SAVE_PRODUCT) {
                    ProductModel prod = gson.fromJson(request.data, ProductModel.class);

                    if  (dao.saveProduct(prod))
                        response.code = StoreResponse.OK;
                    else
                        response.code = StoreResponse.SAVE_PRODUCT_ERROR;

                    out.println(gson.toJson(response));
                    out.flush();
                }
            }
            in.close();
            out.close();
            socket.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
