package com.acme.edu;



public interface Logger {


    /**
     * printing int
     * @param message - number for print
     */
    void log(int message);

    /**
     * printing byte
     * @param message - number for print
     */
    void log(byte message);

    /**
     * printing String
     * @param message - str for printing
     */
    void log(String message);

    /**
     * close method, should be called after logging
     */
    void close();

    /**
     * printing boolean
     * @param message - bool for printing
     */
    void log(boolean message);

    /**
     * printing char
     * @param message - char for printing
     */
    void log(char message);

    /**
     * printing object
     * @param message - object for printing
     */
    void log(Object message);

    /**
     * printing vararg of int's
     * @param arr - vararg for print
     */
    void log(int... arr);

    /**
     * printing matrix
     * @param arr - matrix for print
     */
    void log(int[][] arr);


    void log(int[][][][] arr);

    /**
     * printing vararg of String's
     * @param arr - vararg for printing
     */
    void log(String... arr);



}