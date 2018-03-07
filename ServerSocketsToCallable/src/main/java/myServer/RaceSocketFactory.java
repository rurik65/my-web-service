package myServer;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class RaceSocketFactory implements Callable<String>{
    private Socket socket;

    private BufferedReader in;
    private PrintWriter out;
  //  private CallCounter count;

    public RaceSocketFactory(Socket socket) throws IOException{
        this.socket = socket;

   //     count = new CallCounter();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    }

    @Override
    public String call() throws Exception {
            try {
                while (true) {
                    String str = in.readLine();
      //              System.out.println("Echoing: " + str);
                    if (str == null) break;
                    if (str.equals("Bue.")) break;
        //            count.increment();
                    out.println(str);
                }
     //       } catch (Exception e) {
       //         e.printStackTrace();
            } finally {
                try{
                    System.out.println(socket.getPort() +" closed");//) + count.getCount());
                    socket.close();
        }catch (IOException e){e.printStackTrace();
        }}
        return ": closed";
    }

}
