package com.acme.edu;

/**
 * Created by user on 05.11.2015.
 */
public class StateFactory {
    private IntState intState;
    private StringState stringState;
    private EmptyBufferState emptyBufferState;

    public StateFactory(Printer printer) {
        this.intState  = new IntState(printer);
        this.stringState = new StringState(printer);
        this.emptyBufferState = new EmptyBufferState(printer);
    }

    public IntState getIntState() {
        return intState;
    }

    public StringState getStringState() {
        return stringState;
    }

    public EmptyBufferState getEmptyBufferState() {
        return emptyBufferState;
    }
}
