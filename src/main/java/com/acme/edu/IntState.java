package com.acme.edu;

/**
 * Created by user on 02.11.2015.
 */
public class IntState implements State {
    /**
     * Buffer var's
     */
    private int buffer;
    private Printer printer;

    public IntState(Printer printer) {
        this.printer = printer;
    }


    /**
     * Printing or sum
     * @param message - message for printing
     */
    @Override
    public void printOrSum(String message) {
        long test = (long) Integer.parseInt(message) + buffer;
        if (test>Integer.MAX_VALUE||test<Integer.MIN_VALUE){
            clearBuffer();
            this.buffer = Integer.parseInt(message);
        } else {
            buffer += Integer.parseInt(message);
        }
    }

    /**
     * Cleaning buffer and printing data
     */
    @Override
    public void clearBuffer() {
        printer.print(buffer+"");
        buffer = 0;
    }
}
