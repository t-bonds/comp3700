package com.ausoft;

import java.net.ServerSocket;
import java.net.Socket;

public class LibraryServer {

    public static void main(String[] args) {
    try {
        ServerSocket s = new ServerSocket(8008);

        while (true) {
            Socket incoming = s.accept();
            System.out.println("There is an incoming connection: " + incoming);
            new com.ausoft.LibraryTeller(incoming, com.ausoft.DataServer.getInstance().getDataAccess()).start();
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

}
