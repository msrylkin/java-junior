package com.acme.edu;

/**
 * Created by user on 03.11.2015.
 */
public abstract class FormatCommand {

    abstract void getData();

    abstract void execute() throws PrinterException;
}
