package com.acme.edu.printer;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Prints our data to somewhere
 */
public abstract class Printer {
    public static final String ERROR_MESSAGE = "ERROR";
    protected List<String> buffer = new ArrayList<>();
    protected BufferedWriter writer;
    protected int messageCounter = 0;

    /**
     * closing all writer streams
     * @throws PrinterException - exception if something wrong
     */
    public abstract void close() throws PrinterException;

    /**
     * Print something to somewhere
     * @param message - data
     */

    public void print(String message) throws PrinterException{
        buffer.add(message);
        messageCounter++;
        if (messageCounter==50){
            flush();
        }
    }

    /**
     * clear local buffer and outStreams
     * @throws PrinterException
     */
    protected void flush() throws PrinterException{
        try {
            Collections.sort(buffer, (o1, o2) -> {
                if (o1.contains(ERROR_MESSAGE) && o2.contains(ERROR_MESSAGE))
                    return 0;
                if (o1.contains(ERROR_MESSAGE))
                    return -1;
                return 1;
            });
            messageCounter = 0;
            for (String element : buffer){
                writer.write(element);
                writer.newLine();
            }
            writer.flush();
            buffer.clear();
        } catch (Exception e) {
            throw new PrinterException("Error at printing message in File printer!",e);
        }
    }
}
