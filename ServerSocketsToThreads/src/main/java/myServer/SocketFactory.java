package myServer;

import java.io.*;
import java.net.Socket;

public class SocketFactory extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
  //  private CallCounter count;

    public SocketFactory(Socket socket) throws IOException{
        this.socket = socket;
   //     count = new CallCounter();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }

    @Override
    public void run() {

            try {
       //         System.out.println("Connection accepted: " + socket + " ");

                while (true) {
                    String str = in.readLine();
      //              System.out.println("Echoing: " + str);
                    if (str == null) break;
                    if (str.equals("Bue.")) break;
        //            count.increment();
                    out.println(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try{
                    System.out.println(socket.getPort() +" closed");//) + count.getCount());
                    socket.close();
        }catch (IOException e){e.printStackTrace();
        }}
     //   super.run();
    }
}
