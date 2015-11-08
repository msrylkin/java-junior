package com.acme.edu.states;

import com.acme.edu.printers.Printer;
import com.acme.edu.printers.PrinterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * State, if we printing ints. It will sum and print as sum
 */
public class IntState extends State {
    /**
     * Buffer var's
     */
    private int buffer;

    /**
     * Constructor with printers
     * @param printers - printers
     */
    public IntState(Printer... printers) {
        this.printers = new ArrayList<Printer>(Arrays.asList(printers));
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
        buffer = 0;
    }


}
