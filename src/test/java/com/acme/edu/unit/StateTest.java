package com.acme.edu.unit;

import com.acme.edu.logger.Logger;
import com.acme.edu.logger.LoggerException;
import com.acme.edu.printers.Printer;
import com.acme.edu.printers.PrinterException;
import com.acme.edu.states.IntState;
import com.acme.edu.states.State;
import com.acme.edu.states.StringState;
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
    public void setUpTest() throws LoggerException {
        printerMock = mock(Printer.class);
        intState = new IntState(printerMock);
        stringState = new StringState(printerMock);
        loggerMock = mock(Logger.class);
    }

    @Test
    public void shouldPrintWhenIntBufferOverFLow() throws PrinterException{
        intState.log(String.valueOf(Integer.MAX_VALUE));
        intState.log("1");

        verify(printerMock).print(String.valueOf(Integer.MAX_VALUE));
    }

    @Test
    public void shouldConcatStrings() throws PrinterException{
        stringState.log("asd");
        stringState.log("asd");
        stringState.log("asd");
        stringState.clearBuffer();

        verify(printerMock).print("asd (x3)");
    }

    @Test
    public void shouldNotCallPrinter() throws PrinterException{
        stringState.clearBuffer();

        verify(printerMock, times(0)).print("");
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNPE() throws PrinterException{
        State sut = new IntState(null);
        sut.clearBuffer();
    }
}
