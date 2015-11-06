package com.acme.edu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by user on 06.11.2015.
 */
public class FilePrinter implements Printer {
    private BufferedWriter writer;

    public FilePrinter() throws PrinterException{
        try {
            writer = new BufferedWriter(new FileWriter("result.txt"));
        } catch (IOException e) {
            throw new PrinterException("ERROR CREATING PRINTER!",e);
        }
    }

    @Override
    public void close() throws PrinterException{
        try {
            writer.close();
        } catch (IOException e) {
            throw new PrinterException("ERROR CLOSING I/O STREAM!",e);
        }
    }

    public FilePrinter(String filename) throws PrinterException{
        try {
            writer = new BufferedWriter(new FileWriter(filename));
        } catch (IOException e) {
            throw new PrinterException("ERROR CREATING PRINTER!",e);
        }
    }

    @Override
    public void print(String message) throws PrinterException{
        try {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            throw new PrinterException("ERROR PRINTING MESSAGE!",e);
        }
    }
}
