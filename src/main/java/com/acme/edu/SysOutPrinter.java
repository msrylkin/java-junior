package com.acme.edu;

/**
 * Created by user on 02.11.2015.
 */
public class SysOutPrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
