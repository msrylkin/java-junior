package com.acme.edu.printer;

import java.io.*;


/**
 * Printer which print data to file
 */
public class FilePrinter extends Printer {


    /**
     * Constructor
     * @param filename - name/path of the file
     * @param charset - chars encoding
     */
    public FilePrinter(String filename, String charset) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true),charset));
        } catch (Exception e){
            System.err.println("Error at creating "+this.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    /**
     * closing FileWriter stream
     * @throws PrinterException - if something wrong, throw exception
     */
    @Override
    public void close() throws PrinterException{
        try {
            flush();
            writer.close();
        } catch (Exception e) {
            throw new PrinterException("Error at closing File printer!",e);
        }

    }
}
