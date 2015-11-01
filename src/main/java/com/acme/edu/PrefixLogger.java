package com.acme.edu;


/**
 * Logger realization for print all types with special prefix
 */
public class PrefixLogger extends SimpleLogger {


    /**
     * String constant
     */
    private static final String STRING_PREFIX = "string: ";
    private static final String PRIMITIVES_ARRAY = "primitives array: ";
    private static final String REFERENCE = "reference: ";
    private static final String CHAR = "char: ";
    private static final String PRIMITIVE = "primitive: ";
    private static final String PRIMITIVES_MULTIMATRIX = "primitives multimatrix: ";
    private static final String PRIMITIVES_MATRIX = "primitives matrix: ";

    /**
     * printing int with prefix
     * @param message - number for print
     */
    @Override
    public void log(int message){
        super.log(PRIMITIVE + message);
    }

    /**
     * printing byte with prefix
     * @param message - number for print
     */
    @Override
    public void log(byte message) {
        this.log((int)message);
    }


    /**
     * printing string with prefix
     * @param message - str for printing
     */
    @Override
    public void log(String message){
        super.log(STRING_PREFIX + message);
    }

    /**
     * printing boolean with prefix
     * @param message - bool for printing
     */
    @Override
    public void log(boolean message) {
        super.log(PRIMITIVE + message);
    }

    /**
     * printing char with prefix
     * @param message - char for printing
     */
    @Override
    public void log(char message) {
        super.log(CHAR + message);
    }

    /**
     * printing object reference
     * @param message - object for printing
     */
    @Override
    public void log(Object message) {
        super.log(REFERENCE + message.toString());
    }

    /**
     * printing vararg of int's
     * @param arr - vararg for print
     */
    public void log(int... arr) {
        if (arr.length==1){
            log(arr[0]);
        } else {
            System.out.print(PRIMITIVES_ARRAY);
            printArray(arr);
        }
    }

    /**
     * printing vararg of String's
     * @param arr - vararg for printing
     */
    public void log(String... arr) {
        if (arr.length==1){
            super.log(arr[0]);
        } else {
            for (String str : arr){
                super.log(str);
            }
        }
    }

    /**
     * printing matrix with prefix
     * @param arr - matrix for print
     */
    public void log(int[][] arr) {
        System.out.println(PRIMITIVES_MATRIX+"{");
        for (int[] subArray : arr){
            printArray(subArray);
        }
        System.out.println("}");
    }

    /**
     * printing multimatrix with prefix
     * @param arr - multimatrix for printing
     */
    public void log(int[][][][] arr) {
        System.out.println(PRIMITIVES_MULTIMATRIX + "{");
        for (int[][][] level3Array: arr){
            System.out.println("{");
            for (int[][] level2Array : level3Array){
                System.out.println("{");
                for (int[] array : level2Array){
                    printArray(array);
                }
                System.out.println("}");
            }
            System.out.println("}");
        }
        System.out.println("}");
    }

    private void printArray(int[] arr){
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else {
                System.out.print(", " + arr[i]);
            }
        }
        System.out.println("}");
    }
}
