package com.acme.edu.printers;

import java.io.*;

/**
 * Created by user on 06.11.2015.
 */
public class FilePrinter implements Printer {
    private BufferedWriter writer;
    private int messageCounter = 0;

//    public FilePrinter() throws PrinterException{
//        try {
//            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("temp.txt")));
//        } catch (IOException e) {
////            throw new PrinterException("ERROR CREATING PRINTER!",e);
//            e.printStackTrace();
//        }
//    }

//    public FilePrinter(String filename) throws PrinterException{
//        try {
//            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true)));
//        } catch (IOException e) {
//            try {
//                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("temp.txt")));
//            } catch (IOException e1) {
////                throw new PrinterException("ERROR CREATING PRINTER!",e1);
//                e1.printStackTrace();
//            }
//        }
//    }

    public FilePrinter(String filename, String charset) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true),charset));
        } catch (Exception e){
            //throw new PrinterException("Error at creating File printer",e);
            System.err.println("Error at creating "+this.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws PrinterException{
        try {
            writer.close();
        } catch (Exception e) {
            throw new PrinterException("Error at closing File printer!",e);
        }

    }

    @Override
    public void print(String message) throws PrinterException{
        try {
            if (messageCounter == 50){
                writer.flush();
                messageCounter = 0;
            }
            writer.write(message);
            writer.newLine();
            messageCounter++;
        } catch (Exception e) {
            throw new PrinterException("Error at printing message in File printer!",e);
        }
    }
}
