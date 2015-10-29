package com.acme.edu;


public class Logger {

    /**
     * String constants
     */
    public static final String REFERENCE = "reference: ";
    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";

    /**
     *
     * @param word - type of message
     * @param message - message
     */
    private static void mySout(String word,String message) {
        System.out.println(word + message);
    }

    //region logMethods

    /**
     *
     * @param message - message for print
     */
    public static void log(int message) {
        mySout(PRIMITIVE,String.valueOf(message));
    }

    /**
     *
     * @param message - message for print
     */
    public static void log(byte message) {
        mySout(PRIMITIVE,String.valueOf(message));
    }

    /**
     *
     * @param message - message for print
     */

    public static void log(boolean message) {
        mySout(PRIMITIVE,String.valueOf(message));
    }

    /**
     *
     * @param message - message for print
     */

    public static void log(char message) {
        mySout(CHAR,String.valueOf(message));
    }

    /**
     *
     * @param message - message for print
     */

    public static void log(String message) {
        mySout(STRING,message);
    }

    /**
     *
     * @param object - reference for print as string
     */
    public static void log(Object object) {
        mySout(REFERENCE,object.toString());
    }

    //endregion
}
