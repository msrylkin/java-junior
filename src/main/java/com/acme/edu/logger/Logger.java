package com.acme.edu.logger;



import com.acme.edu.states.*;



/**
 * our Logger class. Prints message to special printer
 */
public class Logger{


    /**
     * String constants
     */
    public static final String REFERENCE_PREFIX = "reference: ";
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
        if (stateFactory==null) {
            throw new NullPointerException("StateFactory can't be null!");
        }

        this.intState = stateFactory.getIntState();
        this.stringState = stateFactory.getStringState();
        this.emptyBufferState = stateFactory.getEmptyBufferState();
        this.currerntState = this.emptyBufferState;
    }

    /**
     * printing message with prefix
     * @param message - message for log
     */
    public void log(int message){
        switchState(this.intState);
        this.currerntState.log(message + "");
    }


    /**
     * printing message with prefix
     * @param message - message for log
     */
    public void log(byte message){
        log((int)message);
    }



    /**
     * printing message with prefix
     * @param message - message for log
     */

    public void log(boolean message){
        switchState(this.emptyBufferState);
        this.currerntState.log(PRIMITIVE_PREFIX + message);
    }


    /**
     * printing message with prefix
     * @param message - message for log
     */
    public void log(char message){
        switchState(this.emptyBufferState);
        this.currerntState.log(CHAR_PREFIX + message);
    }


    /**
     * printing message with prefix
     * @param message - message for log
     */
    public void log(String message){
        switchState(this.stringState);
        this.currerntState.log(message + "");
    }



    /**
     * prints vararg of strings, each on new line
     * @param arr - strings for log
     */
    public void log(String... arr){
        for (String x : arr){
            log(x);
        }
    }


    /**
     * printing object.toString with prefix
     * @param object - reference for log as string
     */
    public void log(Object object){
        switchState(this.emptyBufferState);
        this.currerntState.log(REFERENCE_PREFIX + object);
    }


    /**
     * prints vararg of int's
     * @param arr - int's for log
     */
    public void log(int... arr){
        for (int number : arr){
            log(number);
        }
    }


    /**
     * printing array with prefix
     * @param arr - array for printing
     */
    public void log(int[][] arr){
        for (int[] simpleArray : arr){
            log(simpleArray);
        }
    }



    /**
     * printing array with prefix
     * @param arr - array for printing
     */
    public  void log(int[][][][] arr){
        for (int[][][] treeDimensionArray : arr){
            for (int[][] twoDimensionArray : treeDimensionArray){
                log(twoDimensionArray);
            }
        }
    }


    /**
     * cleaning buffers and links
     */
    public void close(){
        this.currerntState.close();
    }


    private void switchState(State state){
        if (this.currerntState == state){
            return;
        }
        this.currerntState.clearBuffer();
        this.currerntState = state;
    }


}
