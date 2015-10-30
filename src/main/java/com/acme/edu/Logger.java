package com.acme.edu;


import java.util.Arrays;

public class Logger {

    /**
     * String constants
     */
    public static final String REFERENCE = "reference: ";
    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    private static int sum = 0;
    private static boolean summFlag = false;
    private static String lastString = null;
    private static int strCounter = 0;


    /**
     *
     * @param word - type of message
     * @param message - message
     */
//    public static void main(String[] args) {
//        Logger.log("asd");
//    }
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

    public static void log(byte number, boolean isNumberForSumm){
        if (isNumberForSumm){
            long test = (long)sum+number;
            if (test>Byte.MAX_VALUE||test<Byte.MIN_VALUE){
                Logger.log(sum,false);
                Logger.log(number, false);
                summFlag = false;
            } else {
                sum+=number;
                summFlag = true; }
        } else {
            mySout("",number+"");
        }
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
        Logger.log(message,true);
        //mySout(STRING, message);
    }

    /**
     *
     * @param object - reference for print as string
     */
    public static void log(Object object) {
        mySout(REFERENCE,object.toString());
    }

    public static void log(int[] arr){
        Logger.log(arr,true);
    }

    public static void log(int[] arr, boolean isMark){
        if (isMark){
            System.out.print("primitives array: ");
        }
        System.out.print("{");
        for (int i=0;i<arr.length;i++){
            if (i==0){
                System.out.print(arr[i]+",");
            }else if (i==arr.length-1){
                System.out.print(", "+arr[i]);
            } else {
                System.out.print(" "+arr[i]);
            }
        }
        System.out.println("}");


    }

    public static void log(int[][] arr){
        log(arr,true);
    }

    public static void log(int[][] arr,boolean isMark){
        if (isMark){
            System.out.println("primitives matrix: {");
        }
        for (int[] x : arr){
            log(x,false);
        }
        System.out.println("}");
    }

    public static void log(int[][][] arr){

    }

    public static void log(int[][][] arr, boolean isMark){

    }

    public static void log(int number, boolean isNumberForSumm){
        lastPrint();
        if (isNumberForSumm){
            long test = (long)sum+number;
            if (test>Integer.MAX_VALUE||test<Integer.MIN_VALUE){
                Logger.log(sum,false);
                Logger.log(number, false);
                summFlag = false;
            } else {
                sum+=number;
                summFlag = true;
            }
        } else {
            mySout("",number+"");
        }
    }


    public static void log(String message, boolean isTypePrintNeeded){
        if (summFlag){
            mySout("",sum+"");
            sum = 0;
            summFlag = false;
        }
        if (!isTypePrintNeeded){
            if (lastString!=null) {
                if (lastString.equals(message)){
                    strCounter++;
                } else {
                    if (strCounter==0){
                        mySout("",lastString);
                        strCounter++;
                    }
                    else{
                        mySout("",lastString+" (x"+strCounter+")");
                        strCounter = 0;
                    }
                    //mySout("",message);
                    lastString = message;
                }
            }
            lastString = message;
        } else {
            mySout(STRING,message);
        }
    }

    private static void lastPrint(){
        {
            if (lastString!=null){
            if (strCounter!=0){
                mySout("",lastString+" (x"+strCounter+")");
                strCounter = 0;
            } else {
                mySout("",lastString);
            }
            lastString = null;}
        }
    }

    public static void close(){
        Logger.sum = 0;
        Logger.strCounter = 0;
        Logger.lastString = null;
        Logger.summFlag = false;
    }

    //endregion
}
