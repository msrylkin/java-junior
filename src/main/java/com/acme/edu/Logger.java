package com.acme.edu;



public class Logger {

    /**
     * String constants
     */
    public static final String REFERENCE_PREFIX = "reference: ";
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    //public static final String STRING_PREFIX = "string: ";

    /**
     * temp flags and variables for sum and counter
     */
//    private static int sum = 0;
//    private static boolean summFlag = false;
//    private static String lastString = null;
//    private static int strCounter = 0;

    private final State intState;
    private final State stringState;
    //private final State emptyState;

    private State currerntState;

    //region logIntegerMethods


    public Logger(Printer printer) {
        this.intState = new IntState(printer);
        this.stringState = new StringState(printer);
        //this.emptyState = emptyState;
    }

    /**
     * printing message with prefix
     * @param message - message for print
     */
    public void log(int message) {
//        mySout(PRIMITIVE_PREFIX, String.valueOf(message));

        if (currerntState!=intState&&currerntState!=null){
            currerntState.clearBuffer();
        }
        this.currerntState = intState;
        this.currerntState.printOrSum(message+"");
    }



//    /**
//     * if isNumberForSum true and next value is int, prints sum
//     * @param number - number for sum or printing
//     * @param isNumberForSum - if true, prints sum
//     */
//    public static void log(int number, boolean isNumberForSum){
//        lastPrint();
//        if (isNumberForSum){
//            long test = (long)sum+number;
//            if (test>Integer.MAX_VALUE||test<Integer.MIN_VALUE){
//                Logger.log(sum,false);
//                Logger.log(number, false);
//                summFlag = false;
//            } else {
//                sum+=number;
//                summFlag = true;
//            }
//        } else {
//            mySout("",number+"");
//        }
//    }

    //endregion

    //region logByteMethods
    /**
     * printing message with prefix
     * @param message - message for print
     */
    public void log(byte message) {
        log((int)message);
    }

//    /**
//     * if isNumberForSum true and next number byte, printing sum of numbers
//     * @param number - number for printing or summation
//     * @param isNumberForSum - if true, summarize with neht int value
//     */
//    public static void log(byte number, boolean isNumberForSum){
//        if (isNumberForSum){
//            long test = (long)sum+number;
//            if (test>Byte.MAX_VALUE||test<Byte.MIN_VALUE){
//                Logger.log(sum,false);
//                Logger.log(number, false);
//                summFlag = false;
//            } else {
//                sum+=number;
//                summFlag = true; }
//        } else {
//            mySout("",number+"");
//        }
//    }

    //endregion

    //region logBooleanMethods
    /**
     * printing message with prefix
     * @param message - message for print
     */

    public void log(boolean message) {
        mySout(PRIMITIVE_PREFIX + String.valueOf(message));
    }

    //endregion

    //region logCharMethods

    /**
     * printing message with prefix
     * @param message - message for print
     */
    public void log(char message) {
        mySout(CHAR_PREFIX + String.valueOf(message));
    }

    //endregion

    //region logStringMethods
    /**
     * printing message with prefix
     * @param message - message for print
     */
    public void log(String message) {

//        Logger.log(message,true);
        if (this.currerntState!=stringState&&this.currerntState!=null){
            this.currerntState.clearBuffer();
        }
        this.currerntState = stringState;
        this.currerntState.printOrSum(message+"");
    }


//    /**
//     * prints a string with or without prefix
//     * @param message - message for print
//     * @param isTypePrintNeeded - if true, prints with prefix
//     */
//    public static void log(String message, boolean isTypePrintNeeded){
//        if (summFlag){
//            mySout("",sum+"");
//            sum = 0;
//            summFlag = false;
//        }
//        if (!isTypePrintNeeded){
//            if (lastString!=null) {
//                if (lastString.equals(message)){
//                    strCounter++;
//                } else {
//                    if (strCounter==0){
//                        mySout("",lastString);
//                        strCounter++;
//                    }
//                    else{
//                        mySout("",lastString+" (x"+strCounter+")");
//                        strCounter = 0;
//                    }
//                    lastString = message;
//                }
//            }
//            lastString = message;
//        } else {
//            mySout(STRING_PREFIX,message);
//        }
//    }

    /**
     * prints vararg of strings, each on new line
     * @param arr - strings for print
     */
    public void log(String... arr){
        for (String x : arr){
            mySout(x);
        }
    }

    //endregion

    //region logObjectMethods

    /**
     * printing object.toString with prefix
     * @param object - reference for print as string
     */
    public void log(Object object) {
        mySout(REFERENCE_PREFIX + object.toString());
    }

    //endregion

    //region logInt[]Methods

    /**
     * prints vararg of int's
     * @param arr - int's for print
     */
    public void log(int... arr){
        if (arr.length==1){
            log(arr[0]);
        } else {
            log(arr,true);
        }
    }
    /**
     * printing array
     * @param arr - array for print
     * @param isMark - if true, printing with prefix
     */
    public void log(int[] arr, boolean isMark){
        close();
        if (isMark){
            System.out.print("primitives array: ");
        }
        System.out.print("{");
        for (int i=0;i<arr.length;i++){
            if (i==0){
                System.out.print(arr[i]);
            } else {
                System.out.print(", "+arr[i]);
            }
        }
        mySout("}");


    }
    /**
     * printing array with prefix
     * @param arr - array for printing
     */
    public void log(int[][] arr){
        close();
        log(arr,true);
    }

    /**
     * printing array
     * @param arr - array for print
     * @param isMark - if true, printing with prefix
     */
    public void log(int[][] arr,boolean isMark){
        close();
        if (isMark){
            System.out.print("primitives matrix: ");
        }
        mySout("{");
        for (int[] x : arr){
            log(x,false);
        }
        mySout("}");
    }

    /**
     * printing array with prefix
     * @param arr - array for printing
     */
    public  void log(int[][][][] arr){
        close();
        mySout("primitives multimatrix: {");
        for (int[][][] x : arr){
            mySout("{");
            for (int[][] y : x){
//                mySout("{");
//                for (int[] z : y){
//                    mySout("{");
//                    for (int num : z){
//                        System.out.print(num);
//                    }
//                    mySout(System.lineSeparator()+"}");
//                }
//                mySout("}");
                log(y,false);
            }
            mySout("}");
        }
        mySout("}");
    }

    //endregion

    //region SysMethods

    /**
     * cleaning buffers and links
     */
    public void close(){
        if (this.currerntState!=null){
            this.currerntState.clearBuffer();
            this.currerntState = null;
        }
    }




    private void mySout(String message) {
        System.out.println(message);
    }



    //endregion
}
