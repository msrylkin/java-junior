package com.acme.edu.printer;

/**
 * Prints our data to somewhere
 */
public interface Printer {
    /**
     * Print something to somewhere
     * @param message - data
     */
    void print(String message) throws PrinterException;

    /**
     * closing all writer streams
     * @throws PrinterException - exception if something wrong
     */
    void close() throws PrinterException;
}
