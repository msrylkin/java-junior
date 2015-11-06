package com.acme.edu;

/**
 * Printer realization.
 * Prints our data to System output
 */
public class ConsolePrinter implements Printer {

    /**
     * Prints data to console
     * @param message - data
     */
    @Override
    public void print(String message) throws PrinterException{
        System.out.println(message);
    }

    @Override
    public void close() throws PrinterException {

    }
}
