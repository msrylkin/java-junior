package com.acme.edu.printers;

import java.io.BufferedWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Printer which prints data to remote server
 */
public class NetworkPrinter implements Printer {
    /**
     * local var's
     */
    private Socket socket;
    private BufferedWriter bw;
    private int messageCounter = 0;

    /**
     * Constructor
     * @param host - hostname/ip
     * @param port - port
     * @param charSet - chars encoding
     */
    public NetworkPrinter(String host, int port, String charSet){
        try {
            this.socket = new Socket(host, port);
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),charSet));
        } catch (Exception e){
            System.err.println("Error at creating"+this.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    /**
     * prints message to remote server
     * @param message - data
     * @throws PrinterException - if something wrong throw exception
     */
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

    /**
     * closing remote connection
     * @throws PrinterException - if something wrong throw exception
     */
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
