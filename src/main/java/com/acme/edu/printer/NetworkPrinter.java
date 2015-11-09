package com.acme.edu.printer;

import java.io.BufferedWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;


/**
 * Printer which prints data to remote server
 */
public class NetworkPrinter extends Printer {
    /**
     * local var's
     */
    private Socket socket;

    /**
     * Constructor
     * @param host - hostname/ip
     * @param port - port
     * @param charSet - chars encoding
     */
    public NetworkPrinter(String host, int port, String charSet){
        try {
            this.socket = new Socket(host, port);
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),charSet));
        } catch (Exception e){
            System.err.println("Error at creating"+this.getClass().getSimpleName());
            e.printStackTrace();
        }
    }


    /**
     * closing remote connection
     * @throws PrinterException - if something wrong throw exception
     */
    @Override
    public void close() throws PrinterException{
        flush();
        try {
            this.writer.close();
            this.socket.close();
        } catch (IOException e) {
            throw new PrinterException("Error at closing network printer!",e);
        }
    }
}
