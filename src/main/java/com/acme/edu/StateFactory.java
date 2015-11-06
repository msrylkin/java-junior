package com.acme.edu;

/**
 * Created by user on 05.11.2015.
 */
public class StateFactory {
    /**
     * local variables for states
     */
    private IntState intState;
    private StringState stringState;
    private EmptyBufferState emptyBufferState;

    /**
     * Create new states
     * @param printers - printer
     */
    public StateFactory(Printer... printers) {
        this.intState  = new IntState(printers);
        this.stringState = new StringState(printers);
        this.emptyBufferState = new EmptyBufferState(printers);
    }

    /**
     * returns IntState object
     * @return - intState object
     */
    public IntState getIntState() {
        return intState;
    }

    /**
     * returns StringState object
     * @return - StringState object
     */
    public StringState getStringState() {
        return stringState;
    }

    /**
     * returns EmptyBufferState object
     * @return - emptyBufferState object
     */
    public EmptyBufferState getEmptyBufferState() {
        return emptyBufferState;
    }
}
