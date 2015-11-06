package com.acme.edu;

/**
 * Created by user on 06.11.2015.
 */
public class LoggerException extends Exception {
    public LoggerException() {
    }

    public LoggerException(String message) {
        super(message);
    }

    public LoggerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoggerException(Throwable cause) {
        super(cause);
    }

    public LoggerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
