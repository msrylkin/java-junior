package com.acme.edu;



public abstract class Logger {

    /**
     * String constants
     */
    public static final String PRIMITIVES_ARRAY = "primitives array: ";
    public static final String REFERENCE = "reference: ";
    public static final String CHAR = "char: ";
    public static final String PRIMITIVE = "primitive: ";
    public static final String PRIMITIVES_MULTIMATRIX = "primitives multimatrix: {";
    public static final String PRIMITIVES_MATRIX = "primitives matrix: ";

    /**
     * printing int or sum of int's
     * @param message - number for print
     */
    public abstract void log(int message);

    /**
     * printing byte or sum of bytes
     * @param message - number for print
     */
    public abstract void log(byte message);

    /**
     * printing String or String with counter
     * @param message - str for printing
     */
    public abstract void log(String message);

    /**
     * close method, should be called after logging
     */
    public abstract void close();

    /**
     * printing boolean with prefix
     * @param message - bool for printing
     */
    public void log(boolean message) {
        System.out.println(PRIMITIVE + message);
    }

    /**
     * printing char with prefix
     * @param message - char for printing
     */
    public void log(char message) {
        System.out.println(CHAR + message);
    }

    /**
     * printing object reference
     * @param message - object for printing
     */
    public void log(Object message) {
        System.out.println(REFERENCE + message.toString());
    }

    /**
     * printing vararg of int's
     * @param arr - vararg for print
     */
    public void log(int... arr) {
        if (arr.length == 1) {
            this.log(arr[0]);
        } else {
            this.log(arr, true);
        }
    }

    /**
     * printing matrix
     * @param arr - matrix for print
     */
    public void log(int[][] arr) {
        this.log(arr, true);
    }


    /**
     * printing multimatrix
     * @param arr - multimatrix for printing
     */
    public void log(int[][][][] arr) {
        System.out.println(PRIMITIVES_MULTIMATRIX);
        for (int[][][] x : arr) {
            System.out.println("{");
            for (int[][] y : x) {
                System.out.println("{");
                for (int[] z : y) {
                    System.out.println("{");
                    for (int num : z) {
                        System.out.print(num);
                    }
                    System.out.println(System.lineSeparator() + "}");
                }
                System.out.println("}");
            }
            System.out.println("}");
        }
        System.out.println("}");
    }

    /**
     * printing vararg of String's
     * @param arr - vararg for printing
     */
    public void log(String... arr) {
        if (arr.length == 1) {
            this.log(arr[0]);
        } else {
            for (String x : arr) {
                System.out.println(x);
            }
        }
    }

    /**
     * printing array with or without prefix
     * @param arr - array for printing
     * @param isMark - if true, printing with prefix
     */
    private void log(int[] arr, boolean isMark) {
        if (isMark) {
            System.out.print(PRIMITIVES_ARRAY);
        }
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else if (i == arr.length - 1) {
                System.out.print(", " + arr[i]);
            } else {
                System.out.print(", " + arr[i]);
            }
        }
        System.out.println("}");
    }

    /**
     * printing array with or without prefix
     * @param arr - array for printing
     * @param isMark - if true, printing with prefix
     */
    private void log(int[][] arr, boolean isMark) {
        if (isMark) {
            System.out.print(PRIMITIVES_MATRIX);
        }
        System.out.println("{");
        for (int[] x : arr) {
            this.log(x, false);
        }
        System.out.println("}");
    }


}