package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try (
                ServerSocket serverSocket = new ServerSocket(6666)
        ){
            while (true) {
                serverSocket.setSoTimeout(10000);
                Socket client = serverSocket.accept();
                Future future = executorService.submit(() -> {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        String data;
                        while ((data = br.readLine()) != null) {
                            System.out.println(">>>>> \"" + data + "\" ==> " + Thread.currentThread().getId());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //throw new IllegalArgumentException("asd");
                });
                if (future.isDone()){
                    try {
                        future.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
                        oos.writeObject(e);
                        oos.flush();
                        oos.close();
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
