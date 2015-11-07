package com.acme.edu.printers;

import java.io.BufferedWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by user on 06.11.2015.
 */
public class NetworkPrinter implements Printer {
    private Socket socket;
    private BufferedWriter bw;
    private int messageCounter = 0;

    public NetworkPrinter(String host, int port, String charSet){
        try {
            this.socket = new Socket(host, port);
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),charSet));
            //throw new PrinterException("Asd");
        } catch (Exception e){
            //throw new PrinterException("Error at creating Network printer",e);
            System.err.println("Error at creating"+this.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    @Override
    public void print(String message) throws PrinterException{
        try {
            if (messageCounter == 50){
                bw.flush();
                messageCounter = 0;
            }
            bw.write(message);
            bw.newLine();
        } catch (Exception e) {
            throw new PrinterException("Error at printing message to remote server",e);
        }
    }

    @Override
    public void close() throws PrinterException{
        try {
            this.bw.close();
            this.socket.close();
        } catch (IOException e) {
            throw new PrinterException("Error at closing network printer!",e);
        }
    }
}
