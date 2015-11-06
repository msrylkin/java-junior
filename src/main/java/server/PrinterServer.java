package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by user on 06.11.2015.
 */
public class PrinterServer {
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(6666)
        ){
            //serverSocket.accept();
            serverSocket.setSoTimeout(60000);
            Socket client = serverSocket.accept();
            //DataInputStream is = new DataInputStream(client.getInputStream());
//            try {
//                Thread.sleep(7000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //while (is.available()>0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String data;
            while ((data = br.readLine()) != null){
                System.out.println(">>>>> " + data);
            }
            //}
    } catch (IOException e){
            e.printStackTrace();
        }

    }
}
