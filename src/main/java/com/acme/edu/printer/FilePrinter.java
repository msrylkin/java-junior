package com.acme.edu.printer;

import java.io.*;

/**
 * Printer which print data to file
 */
public class FilePrinter implements Printer {
    /**
     * private local var's
     */
    private BufferedWriter writer;
    private int messageCounter = 0;

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
     * prints message to file
     * @param message - data
     * @throws PrinterException - throw exception if something wrong
     */
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

    /**
     * closing FileWriter stream
     * @throws PrinterException - if something wrong, throw exception
     */
    @Override
    public void close() throws PrinterException{
        try {
            writer.close();
        } catch (Exception e) {
            throw new PrinterException("Error at closing File printer!",e);
        }

    }
}
