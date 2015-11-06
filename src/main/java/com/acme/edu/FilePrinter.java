package com.acme.edu;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by user on 06.11.2015.
 */
public class FilePrinter implements Printer {
    private BufferedWriter writer;

    public FilePrinter() throws PrinterException{
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("temp.txt")));
        } catch (IOException e) {
            throw new PrinterException("ERROR CREATING PRINTER!",e);
        }
    }

    public FilePrinter(String filename) throws PrinterException{
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true)));
        } catch (IOException e) {
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("temp.txt")));
            } catch (IOException e1) {
                throw new PrinterException("ERROR CREATING PRINTER!",e1);
            }
        }
    }

    public FilePrinter(String filename, Charset charset) throws PrinterException{
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true),charset));
        } catch (IOException e) {
            try {
                this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("temp.txt")));
            } catch (IOException e1) {
                throw new PrinterException("ERROR CREATING PRINTER!",e1);
            }
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
