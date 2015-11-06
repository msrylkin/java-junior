package com.acme.edu.unit;

import com.acme.edu.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by user on 04.11.2015.
 */
public class StateTest {

    private IntState intState;
    private StringState stringState;
    private Logger loggerMock;
    private Printer printerMock;

    @Before
    public void setUpTest() throws LoggerException{
        printerMock = mock(Printer.class);
        intState = new IntState(printerMock);
        stringState = new StringState(printerMock);
        loggerMock = mock(Logger.class);
    }

    @Test
    public void shouldPrintWhenIntBufferOverFLow() throws LoggerException{
        intState.log(String.valueOf(Integer.MAX_VALUE));
        intState.log("1");

        verify(printerMock).print(String.valueOf(Integer.MAX_VALUE));
    }

    @Test
    public void shouldConcatStrings() throws  LoggerException{
        stringState.log("asd");
        stringState.log("asd");
        stringState.log("asd");
        stringState.clearBuffer();

        verify(printerMock).print("asd (x3)");
    }

    @Test
    public void shouldNotCallPrinter() throws LoggerException{
        stringState.clearBuffer();

        verify(printerMock, times(0)).print("");
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNPE() throws LoggerException{
        State sut = new IntState(null);
        sut.clearBuffer();
    }
}
