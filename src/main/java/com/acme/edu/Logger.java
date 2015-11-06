package com.acme.edu;




public class Logger {

    public static void main(String[] args) throws LoggerException{
        Logger logger = new Logger(new StateFactory(new ConsolePrinter(),new FilePrinter("D://temp.txt")));
        logger.log('a');
        logger.log(123);
        logger.log('a');
        logger.log(123);
        logger.log('a');
        logger.close();
    }

    /**
     * String constants
     */
    public static final String REFERENCE_PREFIX = "reference: ";
    public static final String PRIMITIVES_MULTIMATRIX = "primitives multimatrix: {";
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";

    /**
     * State machine vars
     */
    private final IntState intState;
    private final StringState stringState;
    private final EmptyBufferState emptyBufferState;


    /**
     * Current state of the our app
     */
    private State currerntState;


    /**
     * Constructor
     * @param stateFactory - factory of our states
     */
    public Logger(StateFactory stateFactory){
        if (stateFactory==null) throw new NullPointerException("StateFactory can't be null!");

        this.intState = stateFactory.getIntState();
        this.stringState = stateFactory.getStringState();
        this.emptyBufferState = stateFactory.getEmptyBufferState();
        this.currerntState = this.emptyBufferState;
    }

    /**
     * printing message with prefix
     * @param message - message for log
     */
    public void log(int message) throws LoggerException{
        switchState(this.intState);
        this.currerntState.log(message + "");
    }


    /**
     * printing message with prefix
     * @param message - message for log
     */
    public void log(byte message) throws LoggerException{
        log((int)message);
    }



    /**
     * printing message with prefix
     * @param message - message for log
     */

    public void log(boolean message) throws LoggerException{
        switchState(this.emptyBufferState);
        this.currerntState.log(PRIMITIVE_PREFIX + message);
        //mySout(PRIMITIVE_PREFIX + String.valueOf(message));
        //new PrefixCommand(PRIMITIVE_PREFIX,String.valueOf(message),currerntState,printer);
    }


    /**
     * printing message with prefix
     * @param message - message for log
     */
    public void log(char message) throws LoggerException{
//        close();
        //mySout(CHAR_PREFIX + String.valueOf(message));
        switchState(this.emptyBufferState);
        this.currerntState.log(CHAR_PREFIX + message);
    }


    /**
     * printing message with prefix
     * @param message - message for log
     */
    public void log(String message) throws LoggerException{
        switchState(this.stringState);
        this.currerntState.log(message + "");
    }



    /**
     * prints vararg of strings, each on new line
     * @param arr - strings for log
     */
    public void log(String... arr) throws LoggerException{
        switchState(this.stringState);
        //this.currerntState.log(PRIMITIVE_PREFIX+message);
        for (String x : arr){
            log(x);
        }
    }


    /**
     * printing object.toString with prefix
     * @param object - reference for log as string
     */
    public void log(Object object) throws LoggerException{
        switchState(this.emptyBufferState);
        this.currerntState.log(REFERENCE_PREFIX + object);
        //mySout(REFERENCE_PREFIX + object.toString());
    }


    /**
     * prints vararg of int's
     * @param arr - int's for log
     */
    public void log(int... arr) throws LoggerException{
        if (arr.length==1){
            log(arr[0]);
        } else {
            log(arr,true);
        }
    }

    /**
     * printing array
     * @param arr - array for log
     * @param isPrefixShouldBePrinted - if true, printing with prefix
     */
    public void log(int[] arr, boolean isPrefixShouldBePrinted) throws LoggerException{
        switchState(this.emptyBufferState);
        if (isPrefixShouldBePrinted){
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
    public void log(int[][] arr) throws LoggerException{
        switchState(this.emptyBufferState);
        log(arr,true);
    }

    /**
     * printing array
     * @param arr - array for log
     * @param isPrefixShouldBePrinted - if true, printing with prefix
     */
    public void log(int[][] arr,boolean isPrefixShouldBePrinted) throws LoggerException{
        switchState(this.emptyBufferState);
        if (isPrefixShouldBePrinted){
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
    public  void log(int[][][][] arr) throws LoggerException{

        switchState(this.emptyBufferState);
        //StringBuilder stringBuilder = new StringBuilder(PRIMITIVES_MULTIMATRIX);
        mySout(PRIMITIVES_MULTIMATRIX);
        for (int[][][] x : arr){
            mySout("{");
            //stringBuilder.append("{");
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
    public void close() throws LoggerException{
        if (this.currerntState != null){
            this.currerntState.close();
            this.currerntState = null;
        }
    }


    private void switchState(State state) throws LoggerException{
        if (this.currerntState == state){
            return;
        }
        this.currerntState.clearBuffer();
        this.currerntState = state;
    }
    private void mySout(String message) {
       //this.printer.log(message);
        System.out.println(message);
    }

}
