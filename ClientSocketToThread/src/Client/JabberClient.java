package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Future;

public class JabberClient {
    public static final int NUMBER_Call = 5000;

    public static void main(String[] args) throws IOException{
 //      CallCounter callCounter = new CallCounter();
        long startTime = (new Date()).getTime();
        for (int i=0;i<10;i++){
            InetAddress addr = InetAddress.getByName(null);
       //     System.out.println("addr: " + addr);
            Socket socket = new Socket(addr, 5050);
            new ClientFactory(socket,i);
        }

        long finishTime = System.currentTimeMillis();
        System.out.println("Time spent: " + (finishTime - startTime));
    }

}
