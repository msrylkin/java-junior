package com.acme.edu;



public class Logger {

    /**
     * String constants
     */
    private static final String REFERENCE = "reference: ";
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";

    /**
     * temp flags and variables for sum and counter
     */
    private static int sum = 0;
    private static boolean summFlag = false;
    private static String lastString = null;
    private static int strCounter = 0;


    //region logIntegerMethods

    /**
     * printing message with prefix
     * @param message - message for print
     */
    public static void log(int message) {
        mySout(PRIMITIVE, String.valueOf(message));
    }

    /**
     * if isNumberForSum true and next value is int, prints sum
     * @param number - number for sum or printing
     * @param isNumberForSum - if true, prints sum
     */
    public static void log(int number, boolean isNumberForSum){
        lastPrint();
        if (isNumberForSum){
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

    //endregion

    //region logByteMethods
    /**
     * printing message with prefix
     * @param message - message for print
     */
    public static void log(byte message) {
        mySout(PRIMITIVE, String.valueOf(message));
    }

    /**
     * if isNumberForSum true and next number byte, printing sum of numbers
     * @param number - number for printing or summation
     * @param isNumberForSum - if true, summarize with neht int value
     */
    public static void log(byte number, boolean isNumberForSum){
        if (isNumberForSum){
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

    //endregion

    //region logBooleanMethods
    /**
     * printing message with prefix
     * @param message - message for print
     */

    public static void log(boolean message) {
        mySout(PRIMITIVE,String.valueOf(message));
    }

    //endregion

    //region logCharMethods

    /**
     * printing message with prefix
     * @param message - message for print
     */
    public static void log(char message) {
        mySout(CHAR, String.valueOf(message));
    }

    //endregion

    //region logStringMethods
    /**
     * printing message with prefix
     * @param message - message for print
     */
    public static void log(String message) {
        Logger.log(message,true);
    }

    /**
     * prints a string with or without prefix
     * @param message - message for print
     * @param isTypePrintNeeded - if true, prints with prefix
     */
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
                    lastString = message;
                }
            }
            lastString = message;
        } else {
            mySout(STRING,message);
        }
    }

    /**
     * prints vararg of strings, each on new line
     * @param arr - strings for print
     */
    public static void log(String... arr){
        for (String x : arr){
            System.out.println(x);
        }
    }

    //endregion

    //region logObjectMethods

    /**
     * printing object.toString with prefix
     * @param object - reference for print as string
     */
    public static void log(Object object) {
        mySout(REFERENCE, object.toString());
    }

    //endregion

    //region logInt[]Methods

    /**
     * prints vararg of int's
     * @param arr - int's for print
     */
    public static void log(int... arr){
        Logger.log(arr,true);
    }
    /**
     * printing array
     * @param arr - array for print
     * @param isMark - if true, printing with prefix
     */
    public static void log(int[] arr, boolean isMark){
        if (isMark){
            System.out.print("primitives array: ");
        }
        System.out.print("{");
        for (int i=0;i<arr.length;i++){
            if (i==0){
                System.out.print(arr[i]);
            }else if (i==arr.length-1){
                System.out.print(", "+arr[i]);
            } else {
                System.out.print(", "+arr[i]);
            }
        }
        System.out.println("}");


    }
    /**
     * printing array with prefix
     * @param arr - array for printing
     */
    public static void log(int[][] arr){
        log(arr,true);
    }

    /**
     * printing array
     * @param arr - array for print
     * @param isMark - if true, printing with prefix
     */
    public static void log(int[][] arr,boolean isMark){
        if (isMark){
            System.out.print("primitives matrix: ");
        }
        System.out.println("{");
        for (int[] x : arr){
            log(x,false);
        }
        System.out.println("}");
    }

    /**
     * printing array with prefix
     * @param arr - array for printing
     */
    public static void log(int[][][][] arr){
        System.out.println("primitives multimatrix: {");
        for (int[][][] x : arr){
            System.out.println("{");
            for (int[][] y : x){
                System.out.println("{");
                for (int[] z : y){
                    System.out.println("{");
                    for (int num : z){
                        System.out.print(num);
                    }
                    System.out.println(System.lineSeparator()+"}");
                }
                System.out.println("}");
            }
            System.out.println("}");
        }
        System.out.println("}");
    }

    //endregion

    //region SysMethods

    /**
     * cleaning buffers and links
     */
    public static void close(){
        Logger.sum = 0;
        Logger.strCounter = 0;
        Logger.lastString = null;
        Logger.summFlag = false;
    }

    /**
     * custom System.out
     * @param word - type of message
     * @param message - message
     */
    private static void mySout(String word,String message) {
        System.out.println(word + message);
    }

    /**
     * function which checks global string variable. If it not null, prints it
     */
    private static void lastPrint(){
        {
            if (lastString!=null){
                if (strCounter!=0){
                    mySout("",lastString+" (x"+strCounter+")");
                    strCounter = 0;
                } else {
                    mySout("",lastString);
                }
                lastString = null;
            }
        }
    }

    //endregion
}
