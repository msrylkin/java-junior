package com.acme.edu;

/**
 * Printer realization.
 * Prints our data to System output
 */
public class SysOutPrinter implements Printer {

    /**
     * Prints data to console
     * @param message - data
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
