package com.acme.edu;



public class PrefixLogger extends Logger {


    /**
     * String constant
     */
    private static final String STRING = "string: ";

    /**
     * printing int with prefix
     * @param message - number for print
     */
    public void log(int message){
        System.out.println(Logger.PRIMITIVE + message);
    }

    /**
     * printing byte with prefix
     * @param message - number for print
     */
    public void log(byte message) {
        System.out.println(Logger.PRIMITIVE + message);
    }


    /**
     * printing string with prefix
     * @param message - str for printing
     */
    public void log(String message){
        System.out.println(STRING + message);
    }

    /**
     * I had to implement it.
     */
    public void close(){

    }

}
