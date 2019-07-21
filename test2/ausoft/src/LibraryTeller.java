package com.ausoft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import com.google.gson.*;

public class LibraryTeller extends Thread {
    protected Socket socket;
    protected com.ausoft.DataAccess dao;

    public LibraryTeller(Socket incoming, com.ausoft.DataAccess dao) {
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
                com.ausoft.LibraryRequest request = gson.fromJson(str, com.ausoft.LibraryRequest.class);
                com.ausoft.LibraryResponse response = new com.ausoft.LibraryResponse();


                if (request.code == com.ausoft.LibraryRequest.GOOD_BYE) break; // the client wants to stop!

                if (request.code == com.ausoft.LibraryRequest.LOAD_BOOK) {
                    int id = Integer.parseInt(request.data);
                    com.ausoft.BookModel book = dao.loadBook(id);

                    if (book == null)
                        response.code = com.ausoft.LibraryResponse.BOOK_NOT_FOUND;
                    else
                        response.data = gson.toJson(book);

                    out.println(gson.toJson(response));
                    out.flush();
                    continue;
                }

                if (request.code == com.ausoft.LibraryRequest.SAVE_BOOK) {
                    com.ausoft.BookModel book = gson.fromJson(request.data, com.ausoft.BookModel.class);

                    if  (dao.saveBook(book))
                        response.code = com.ausoft.LibraryResponse.OK;
                    else
                        response.code = com.ausoft.LibraryResponse.SAVE_BOOK_ERROR;

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
