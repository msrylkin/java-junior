package com.acme.edu;

/**
 * Logger realization.
 * Summarize ONLY: String, int, byte. Other types just print to console without modify
 */
public class SumLogger extends SimpleLogger {


    /**
     * local flags and buffers
     */
    private int sum = 0;
    private boolean sumFlag = false;
    private String lastStr = null;
    private int strCounter = 0;

    /**
     * prints sum of int's
     * @param message - number for print
     */
    @Override
    public void log(int message){
        printLast();
        long test = (long)message + sum;
        if (test>Integer.MAX_VALUE||test<Integer.MIN_VALUE){
            setSumFlagAndPrint(message,true);
        } else {
            setSumFlagAndPrint(message,false);
        }
    }

    /**
     * prints sum of byte's
     * @param message - number for print
     */
    @Override
    public void log(byte message){
        printLast();
        long test = (long)sum + message;
        if (test>Byte.MAX_VALUE||test<Byte.MIN_VALUE){
            setSumFlagAndPrint(message,true);
        } else {
            setSumFlagAndPrint(message,false);
        }
    }

    /**
     * prints counted strings
     * @param message - str for printing
     */
    @Override
    public void log(String message){
        printSum();
        if (lastStr!=null){
            if (lastStr.equals(message)){
                strCounter++;
            } else {
                printLast();
            }
        }
        lastStr = message;
    }

    /**
     * method to clean local variables and print from buffer
     */
    @Override
    public void close(){
        printLast();
        printSum();
    }

    private void printLast(){
        if (lastStr!=null){
            if (strCounter==0){
                super.log(lastStr);
                lastStr = null;
            } else {
                System.out.printf("%s (x%d)"+System.lineSeparator(),lastStr,++strCounter);
                strCounter = 0;
            }
        }
    }

    private void printSum(){
        if (sumFlag){
            super.log(sum);
            sum = 0;
            sumFlag = false;
            lastStr = null;
        }
    }

    private void setSumFlagAndPrint(int message,boolean isOverFlow){
        if (isOverFlow){
            super.log(sum);
            super.log(message);
            sum = 0;
            sumFlag = false;
        } else {
            sum += message;
            sumFlag = true;
        }
    }


}
