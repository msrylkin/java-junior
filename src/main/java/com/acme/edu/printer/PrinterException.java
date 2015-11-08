package com.acme.edu.printer;



/**
 * Exception if something wrong at creating printer, printing message or closing our printer
 */
public class PrinterException extends Exception {
    public PrinterException() {
    }

    public PrinterException(String message) {
        super(message);
    }

    public PrinterException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrinterException(Throwable cause) {
        super(cause);
    }

    public PrinterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
