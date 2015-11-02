package com.acme.edu;


public class StringState implements State{
    private Printer printer;
    private int strCounter = 0;
    private String buffer = null;

    public StringState(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void printOrSum(String message) {
        if (message.equals(buffer)){
            strCounter++;
        } else {
            clearBuffer();
            this.buffer = message;
            strCounter = 1;
        }
    }

    @Override
    public void clearBuffer() {
        switch (this.strCounter){
            case 0: return;
            case 1: this.printer.print(this.buffer);
                break;
            default:
                this.printer.print(this.buffer+" (x"+this.strCounter+")");
        }
//        if (this.strCounter==1){
//            this.printer.print(Logger.STRING_PREFIX + this.buffer);
//        } else {
//            this.printer.print(Logger.STRING_PREFIX + );
//        }
        this.strCounter = 0;
        this.buffer = null;
    }
}
