package com.acme.edu;


public class EmptyBufferState implements State {
    private Printer printer;

    public EmptyBufferState(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void printOrSum(String message) {
        this.printer.print(message);
    }

    @Override
    public void clearBuffer() {

    }
}
