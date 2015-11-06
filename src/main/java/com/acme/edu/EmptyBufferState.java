package com.acme.edu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmptyBufferState implements State {
    /**
     * local variable for printer
     */
    private List<Printer> printers;

    /**
     * constructor
     * @param printers - printer
     */
    public EmptyBufferState(Printer... printers) {
        this.printers = new ArrayList<Printer>(Arrays.asList(printers));
//        for (Printer printer : printers){

//            this.printers.add(printer);
//        }
    }

    /**
     * Just prints our message to printer
     * @param message - message for printing
     */
    @Override
    public void log(String message) throws PrinterException{
        for (Printer printer : this.printers){
            printer.print(message);
        }
        //this.printer.print(message);
    }



    /**
     * useless method
     */
    @Override
    public void clearBuffer() throws PrinterException{

    }

    public void close() throws PrinterException{
        clearBuffer();
        for (Printer printer : this.printers){
            printer.close();
        }
    }
}
