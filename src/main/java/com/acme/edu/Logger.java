package com.acme.edu;



public class Logger {

    /**
     * String constants
     */
    public static final String REFERENCE_PREFIX = "reference: ";
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";

    /**
     * State machine vars
     */
    private final State intState;
    private final State stringState;

    private Printer printer;

    /**
     * Current state of the our app
     */
    private State currerntState;




    /**
     * Constructor.
     * @param printer - type of printer to out our data
     */
    public Logger(Printer printer) {
        this.printer = printer;
        this.intState = new IntState(this.printer);
        this.stringState = new StringState(this.printer);
    }

    /**
     * printing message with prefix
     * @param message - message for print
     */
    public void log(int message) {
        if (currerntState!=intState&&currerntState!=null){
            currerntState.clearBuffer();
        }
        this.currerntState = intState;
        this.currerntState.printOrSum(message+"");
    }


    /**
     * printing message with prefix
     * @param message - message for print
     */
    public void log(byte message) {
        log((int)message);
    }



    /**
     * printing message with prefix
     * @param message - message for print
     */

    public void log(boolean message) {
        mySout(PRIMITIVE_PREFIX + String.valueOf(message));
    }


    /**
     * printing message with prefix
     * @param message - message for print
     */
    public void log(char message) {
        mySout(CHAR_PREFIX + String.valueOf(message));
    }


    /**
     * printing message with prefix
     * @param message - message for print
     */
    public void log(String message) {
        if (this.currerntState!=stringState&&this.currerntState!=null){
            this.currerntState.clearBuffer();
        }
        this.currerntState = stringState;
        this.currerntState.printOrSum(message+"");
    }



    /**
     * prints vararg of strings, each on new line
     * @param arr - strings for print
     */
    public void log(String... arr){
        for (String x : arr){
            mySout(x);
        }
    }


    /**
     * printing object.toString with prefix
     * @param object - reference for print as string
     */
    public void log(Object object) {
        mySout(REFERENCE_PREFIX + object.toString());
    }


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
                log(y,false);
            }
            mySout("}");
        }
        mySout("}");
    }


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
        this.printer.print(message);
    }

}
