package com.acme.edu.states;


import com.acme.edu.printer.Printer;
import com.acme.edu.printer.PrinterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * State, if our buffer is empty
 */
public class EmptyBufferState extends State {


    /**
     * constructor
     * @param printers - printer
     */
    public EmptyBufferState(Printer... printers) {
        this.printers = new ArrayList<Printer>(Arrays.asList(printers));
    }

    /**
     * Just prints our message to printer
     * @param message - message for printing
     */
    @Override
    public void log(String message){
        Iterator<Printer> it = this.printers.iterator();
        while (it.hasNext()){
            Printer item = it.next();
            try {
                item.print(message);
            } catch (PrinterException e) {
                System.err.println("Error at printing message in " + item.getClass().getSimpleName());
                e.printStackTrace();
                it.remove();
            }
        }
    }


    /**
     * useless method
     */
    @Override
    public void clearBuffer(){
        /*
        nothing to do here
         */
    }


}
