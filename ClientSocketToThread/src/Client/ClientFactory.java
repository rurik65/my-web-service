package Client;

import java.io.*;
import java.net.Socket;

public class ClientFactory extends Thread {
    private Socket socket;
    private int number;
    private BufferedReader in;
    private PrintWriter out;
    private CallCounter callCounter;

    public ClientFactory(Socket socket, int number) throws IOException{
        this.socket = socket;
        this.number = number;
        callCounter = new CallCounter();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        start();
    }
    public void run(){
     //   try {
            try {
                System.out.println("socket: " + socket.getLocalPort());

            for (int i =0;i<JabberClient.NUMBER_Call;i++){
                out.println("howdy " + i + " number: " + number );
                Thread.sleep(1);
                String str = in.readLine();
                callCounter.increment();
          //      System.out.println(str);
            }
            out.println("Bue.");
            }catch (Exception ex){ex.printStackTrace();}
            finally {
      //          socket.close();
                System.out.println(number +" " + callCounter.getCount());
            }
     //   }catch (IOException e){e.printStackTrace();}
    }
}
