package com.acme.edu;

import java.io.IOException;

/**
 * Prints our data to somewhere
 */
public interface Printer {
    /**
     * Print something to somewhere
     * @param message - data
     */
    void print(String message) throws PrinterException;

    void close() throws PrinterException;
}
