package com.acme.edu;

public class Logger {
    public static void log(int message) {
        mySout("primitive: ",String.valueOf(message));
    }

    private static void mySout(String word,String message) {
        System.out.println(word + message);
    }

    public static void log(byte message) {
        mySout("primitive: ",String.valueOf(message));
    }

    public static void log(boolean message) {
        mySout("primitive: ",String.valueOf(message));
    }

    public static void log(char message) {
        mySout("char: ",String.valueOf(message));
    }


    public static void main(String[] args) {

    }
}
