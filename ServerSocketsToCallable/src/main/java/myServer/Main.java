package myServer;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static final int PORT = 5050;
    private static final int THREADS_NUMBER = 10;

    public static void main(String[] args) throws IOException{
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);
        ServerSocket s = new ServerSocket(PORT);
        RaceSocketFactory rsf;
     //   Future<String> futures;
        System.out.println("Server started");
            try {
                for (int i=0;i<THREADS_NUMBER;i++) {
                Socket socket = s.accept();

                  //  try {
                        rsf = new RaceSocketFactory(socket);
                        executorService.submit(rsf);
                  //      new CallService(executorService, socket);
                  //      }catch (Exception e){socket.close();}
                    }
                } finally {
                    s.close();
        //        System.out.println(callCounter.getCount());
                }
        executorService.shutdown();
    }


}
