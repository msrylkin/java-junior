package com.acme.edu.states;


import com.acme.edu.printers.Printer;
import com.acme.edu.printers.PrinterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
//        for (Printer printer : this.printers){
//            try {
//                printer.print(message);
//            } catch (PrinterException e) {
//                System.err.println("Error at printing message in" + printer.getClass().getSimpleName());
//                e.printStackTrace();
//                this.printers.remove(printer);
//            }
//        }
        //this.printer.print(message);
    }



    /**
     * useless method
     */
    @Override
    public void clearBuffer(){

    }

    public void close(){
        clearBuffer();
        Iterator<Printer> it = this.printers.iterator();
//        for (Printer printer : this.printers){
//            try {
//                printer.close();
//            } catch (PrinterException e) {
//                System.err.println("Error at printing message in" + printer.getClass().getSimpleName());
//                e.printStackTrace();
//                this.printers.remove(printer);
//            }
//        }
        while (it.hasNext()){
            Printer item = it.next();
            try {
                item.close();
            } catch (PrinterException e) {
                System.err.println("Error at printing message in" + item.getClass().getSimpleName());
                e.printStackTrace();
                it.remove();
            }
        }
    }
}
