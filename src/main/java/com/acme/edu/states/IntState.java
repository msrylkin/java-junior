package com.acme.edu.states;

import com.acme.edu.printers.Printer;
import com.acme.edu.printers.PrinterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
    public void log(String message){
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
    public void clearBuffer(){
        Iterator<Printer> it = this.printers.iterator();
        while (it.hasNext()){
            Printer item = it.next();
            try {
                item.print(buffer+"");
            } catch (PrinterException e) {
                System.err.println("Error at printing message in " + item.getClass().getSimpleName());
                e.printStackTrace();
                it.remove();
            }
        }
//        for (Printer printer : this.printers){
//            try {
//                printer.print(buffer+"");
//            } catch (PrinterException e) {
//                System.err.println("Error at printing message in " + printer.getClass().getSimpleName());
//                e.printStackTrace();
//                this.printers.remove(printer);
//            }
//        }
        buffer = 0;

    }

    public void close(){
        clearBuffer();
        Iterator<Printer> it = this.printers.iterator();
        while (it.hasNext()){
            Printer item = it.next();
            try {
                item.close();
            } catch (PrinterException e) {
                System.err.println("Error at closing "+item.getClass().getSimpleName());
                e.printStackTrace();
                it.remove();
            }
        }
//        for (Printer printer : this.printers){
//            try {
//                printer.close();
//            } catch (PrinterException e) {
//                System.err.println("Error at closing " + printer.getClass().getSimpleName());
//                e.printStackTrace();
//                this.printers.remove(printer);
//            }
//        }
    }
}
