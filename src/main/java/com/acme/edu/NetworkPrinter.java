package com.acme.edu;

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

    public NetworkPrinter(String host, int port) throws PrinterException{
        try {
            this.socket = new Socket(host, port);
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new PrinterException("NETWORK ERROR!",e);
        }
    }

    @Override
    public void print(String message) throws PrinterException {
        try {
            bw.write(message);
            bw.newLine();
        } catch (IOException e) {
            throw new PrinterException("PRINTING ERROR!",e);
        }
    }

    @Override
    public void close() throws PrinterException {
        try {
            this.bw.close();
            this.socket.close();
        } catch (IOException e) {
            throw new PrinterException("NETWORK ERROR!",e);
        }
    }
}
