package com.ausoft;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class RemoteDataAccess implements com.ausoft.DataAccess {
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

    public boolean saveBook(com.ausoft.BookModel book) {
        System.out.println("Request save book with id = " + book.bookID);

        try {
            com.ausoft.LibraryRequest request = new com.ausoft.LibraryRequest(com.ausoft.LibraryRequest.SAVE_BOOK, gson.toJson(book));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            com.ausoft.LibraryResponse response = gson.fromJson(ans, com.ausoft.LibraryResponse.class); // convert JSON string to a response object!

            return (response.code == com.ausoft.LibraryResponse.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public com.ausoft.BookModel loadBook(int bookID) {
        com.ausoft.BookModel book = null;

        System.out.println("Request load book with id = " + bookID);

        try {
            com.ausoft.LibraryRequest request = new com.ausoft.LibraryRequest(com.ausoft.LibraryRequest.LOAD_BOOK, String.valueOf(bookID));

            out.println(gson.toJson(request)); // convert it into JSON and send it to server
            out.flush();

            String ans = in.readLine(); //

            com.ausoft.LibraryResponse response = gson.fromJson(ans, com.ausoft.LibraryResponse.class); // convert JSON string to a response object!

            if (response.code == com.ausoft.LibraryResponse.OK)
                book = gson.fromJson(response.data, com.ausoft.BookModel.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }


}
