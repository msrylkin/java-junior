package com.acme.edu.states;


import com.acme.edu.printers.Printer;
import com.acme.edu.printers.PrinterException;
import com.acme.edu.states.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StringState extends State {
    /**
     * Buffer var's
     */

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
                //e.printStackTrace();
                it.remove();
            }
        }
//        for (Printer printer : this.printers){
//            try {
//                if (strCounter==1){
//                    printer.print(this.buffer);}
//                else {
//                    printer.print(this.buffer+" (x"+this.strCounter+")");
//                }
//            } catch (PrinterException e) {
//                System.err.println("Error at printing message in " + printer.getClass().getSimpleName());
//                e.printStackTrace();
//                this.printers.remove(printer);
//            }
//        }
    }

}
