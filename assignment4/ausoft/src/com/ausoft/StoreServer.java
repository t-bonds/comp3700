package com.ausoft;

import java.net.ServerSocket;
import java.net.Socket;

public class StoreServer {

    public static void main(String[] args) {
    try {
        ServerSocket s = new ServerSocket(8008);

        while (true) {
            Socket incoming = s.accept();
            System.out.println("There is an incoming connection: " + incoming);
            new StoreTeller(incoming, DataServer.getInstance().getDataAccess()).start();
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

}
