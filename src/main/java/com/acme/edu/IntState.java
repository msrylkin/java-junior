package com.acme.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 02.11.2015.
 */
public class IntState implements State {
    /**
     * Buffer var's
     */
    private int buffer;
    private List<Printer> printers;

    /**
     * Constructor with printers
     * @param printers - printers
     */
    public IntState(Printer... printers) {
        this.printers = new ArrayList<Printer>(Arrays.asList(printers));
//        for (Printer printer : printers){
//            this.printers.add(printer);
//        }
    }



    /**
     * Printing or sum
     * @param message - message for printing
     */
    @Override
    public void log(String message) throws PrinterException{
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
    public void clearBuffer() throws PrinterException{
        for (Printer printer : this.printers){
            printer.print(buffer+"");
        }
        buffer = 0;

    }

    public void close() throws PrinterException{
        clearBuffer();
        for (Printer printer : this.printers){
            printer.close();
        }
    }
}
