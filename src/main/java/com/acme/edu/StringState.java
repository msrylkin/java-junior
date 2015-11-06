package com.acme.edu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringState implements State{
    /**
     * Buffer var's
     */
    private List<Printer> printers;
    private int strCounter = 0;
    private String buffer = null;

    /**
     * Constructor
     * @param printers - data printers
     */
    public StringState(Printer... printers) {
        this.printers = new ArrayList<Printer>(Arrays.asList(printers));
//        for (Printer printer : printers){
//            this.printers.add(printer);
//        }
        //this.printer = printer;
    }



    /**
     * Printing or sum
     * @param message - message for printing
     */
    @Override
    public void log(String message) throws PrinterException{
        if (message.equals(buffer)){
            strCounter++;
        } else {
            clearBuffer();
            this.buffer = message;
            strCounter = 1;
        }
    }

    /**
     * Cleaning buffer and log
     */
    @Override
    public void clearBuffer() throws PrinterException{
        switch (this.strCounter){
            case 0: return;
            case 1: {
                for (Printer printer : this.printers){
                    printer.print(this.buffer);
                }
                //this.printer.print(this.buffer);
                break;
            }
            default:{
                //this.printer.print(this.buffer+" (x"+this.strCounter+")");
                for (Printer printer : this.printers){
                    printer.print(this.buffer+" (x"+this.strCounter+")");
                }
            }
        }
        this.strCounter = 0;
        this.buffer = null;

    }

    public void close() throws PrinterException{
        clearBuffer();
        for (Printer printer : this.printers){
            printer.close();
        }
    }

}
