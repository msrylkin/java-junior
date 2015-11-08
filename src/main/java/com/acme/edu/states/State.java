package com.acme.edu.states;

import com.acme.edu.printers.Printer;
import com.acme.edu.printers.PrinterException;

import java.util.Iterator;
import java.util.List;

/**
 * State
 */
public abstract class State {
    protected List<Printer> printers;

    /**
     * Summarize or log current message and buffer
     * @param message - message for printing
     */
    public abstract void log(String message);


    /**
     * Cleaning buffer. You must call that after all operations
     */
    public abstract void clearBuffer();

    /**
     * closing States and printers streams
     */
    public void close(){
        clearBuffer();
        Iterator<Printer> it = this.printers.iterator();
        while (it.hasNext()){
            Printer item = it.next();
            try {
                item.close();
            } catch (PrinterException e) {
                System.err.println("Error at closing " + item.getClass().getSimpleName());
                //e.printStackTrace();
                it.remove();
            }
        }
    }
}
