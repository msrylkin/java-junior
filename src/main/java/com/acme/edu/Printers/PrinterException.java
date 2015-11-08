package com.acme.edu.printers;

import com.acme.edu.logger.LoggerException;

/**
 * Created by user on 06.11.2015.
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
