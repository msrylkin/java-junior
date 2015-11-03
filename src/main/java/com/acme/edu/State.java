package com.acme.edu;

/**
 * State
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
