package com.acme.edu.states;

/**
 * State
 */
public interface State {

    /**
     * Summarize or log current message and buffer
     * @param message - message for printing
     */
    void log(String message);


    /**
     * Cleaning buffer. You must call that after all operations
     */
    void clearBuffer();

    void close();
}
