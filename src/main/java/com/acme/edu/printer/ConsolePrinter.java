package com.acme.edu.printer;

/**
 * Printer realization.
 * Prints our data to System output
 */
public class ConsolePrinter extends Printer {


    /**
     * Prints data to console
     * @param message - data
     */
    @Override
    public void print(String message){
        System.out.println(message);
    }

    /**
     * useless method
     */
    @Override
    public void close(){
        /*
        nothing to do here
         */
    }

    /**
     * useless method
     * @throws PrinterException
     */
    @Override
    protected void flush() throws PrinterException {
        /*
        nothing to do here
         */
    }
}
