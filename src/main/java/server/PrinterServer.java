package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Example server for NetworkPrinter
 */
public class PrinterServer {
    private PrinterServer() {
    }

    /**
     * method to start local server
     * @param args - arguments of server
     */
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(6666)
        ){
            serverSocket.setSoTimeout(60000);
            Socket client = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String data;
            while ((data = br.readLine()) != null){
                System.out.println(">>>>> " + data);
            }
    } catch (IOException e){
            e.printStackTrace();
        }

    }
}
