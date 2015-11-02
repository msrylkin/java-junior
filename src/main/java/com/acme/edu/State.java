package com.acme.edu;

/**
 * Created by user on 02.11.2015.
 */
public interface State {

    /**
     * Summarize or print current message and buffer
     * @param message - message for printing
     */
    void printOrSum(String message);

    /**
     * Cleaning buffer. You must call that after all operations
     */
    void clearBuffer();
}
