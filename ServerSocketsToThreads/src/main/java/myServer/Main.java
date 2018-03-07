package myServer;

import myServer.SocketFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final int PORT = 5050;


    public static void main(String[] args) throws IOException{
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server started");
            try {
                while (true) {
                Socket socket = s.accept();
                    try {
                        new SocketFactory(socket);
                        }catch (IOException e){socket.close();}
                    }
                } finally {
                    s.close();
        //        System.out.println(callCounter.getCount());
                }

    }
}
