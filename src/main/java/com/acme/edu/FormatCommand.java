package com.acme.edu;

import com.acme.edu.printers.PrinterException;

/**
 * Created by user on 03.11.2015.
 */
public abstract class FormatCommand {

    abstract void getData();

    abstract void execute() throws PrinterException;
}
