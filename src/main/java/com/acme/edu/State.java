package com.acme.edu;

/**
 * State
 */
public interface State {

    /**
     * Summarize or log current message and buffer
     * @param message - message for printing
     */
    void log(String message) throws PrinterException;


    /**
     * Cleaning buffer. You must call that after all operations
     */
    void clearBuffer() throws PrinterException;

    void close() throws PrinterException;
}
