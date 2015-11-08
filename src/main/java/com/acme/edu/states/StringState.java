package com.acme.edu.states;


import com.acme.edu.printer.Printer;
import com.acme.edu.printer.PrinterException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * State if we printing String variable
 */
public class StringState extends State {
    /**
     * Buffer var's
     */

    private int strCounter = 0;
    private String buffer = null;

    /**
     * Constructor
     * @param printers - data printer
     */
    public StringState(Printer... printers) {
        this.printers = new ArrayList<Printer>(Arrays.asList(printers));
    }

    /**
     * Printing or sum
     * @param message - message for printing
     */
    @Override
    public void log(String message) {
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
    public void clearBuffer(){
        if (strCounter==0){
            return;
        }
        print();
        this.strCounter = 0;
        this.buffer = null;

    }

    /**
     * prints our buffer
     */
    private void print() {
        Iterator<Printer> it = this.printers.iterator();
        while (it.hasNext()){
            Printer item = it.next();
            try {
                if (strCounter==1){
                    item.print(buffer);
                } else {
                    item.print(this.buffer+" (x"+this.strCounter+")");
                }
            } catch (PrinterException e) {
                System.err.println("Error at printing message in " + item.getClass().getSimpleName());
                e.printStackTrace();
                it.remove();
            }
        }
    }

}
