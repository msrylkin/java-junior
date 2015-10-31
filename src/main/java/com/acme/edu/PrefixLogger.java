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
    @Override
    public void log(int message){
        System.out.println(Logger.PRIMITIVE + message);
    }

    /**
     * printing byte with prefix
     * @param message - number for print
     */
    @Override
    public void log(byte message) {
        System.out.println(Logger.PRIMITIVE + message);
    }


    /**
     * printing string with prefix
     * @param message - str for printing
     */
    @Override
    public void log(String message){
        System.out.println(STRING + message);
    }

    /**
     * I had to implement it.
     */
    @Override
    public void close(){
        throw new UnsupportedOperationException();
    }

}
