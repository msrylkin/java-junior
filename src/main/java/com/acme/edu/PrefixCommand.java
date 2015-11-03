package com.acme.edu;

/**
 * Created by user on 03.11.2015.
 */
public class PrefixCommand extends FormatCommand{
    private String prefix;
    private String message;
    private State state;
    private Printer printer;

    public PrefixCommand(String prefix, String message, State state, Printer printer) {
        this.prefix = prefix;
        this.message = message;
        this.state = state;
        this.printer = printer;
        execute();
    }

    @Override
    void getData() {

    }

    @Override
    void execute() {
        if (state!=null){
            state.clearBuffer();
            state = null;
        }
        printer.print(prefix + message);
    }
}
