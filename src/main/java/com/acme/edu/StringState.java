package com.acme.edu;


public class StringState implements State{
    /**
     * Buffer var's
     */
    private Printer printer;
    private int strCounter = 0;
    private String buffer = null;

    /**
     * Constructor
     * @param printer - data printer
     */
    public StringState(Printer printer) {
        this.printer = printer;
    }

    /**
     * Printing or sum
     * @param message - message for printing
     */
    @Override
    public void printOrSum(String message) {
        if (message.equals(buffer)){
            strCounter++;
        } else {
            clearBuffer();
            this.buffer = message;
            strCounter = 1;
        }
    }

    /**
     * Cleaning buffer and print
     */
    @Override
    public void clearBuffer() {
        switch (this.strCounter){
            case 0: return;
            case 1: this.printer.print(this.buffer);
                break;
            default:
                this.printer.print(this.buffer+" (x"+this.strCounter+")");
        }
        this.strCounter = 0;
        this.buffer = null;
    }
}
