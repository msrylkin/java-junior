package com.acme.edu.unit;

import com.acme.edu.IntState;
import com.acme.edu.Logger;
import com.acme.edu.Printer;
import com.acme.edu.StringState;
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
    public void setUpTest(){
        printerMock = mock(Printer.class);
        intState = new IntState(printerMock);
        stringState = new StringState(printerMock);
        loggerMock = mock(Logger.class);
    }

    @Test
    public void shouldPrintWhenIntBufferOverFLow(){
        intState.printOrSum(String.valueOf(Integer.MAX_VALUE));
        intState.printOrSum("1");

        verify(printerMock).print(String.valueOf(Integer.MAX_VALUE));
    }

    @Test
    public void shouldConcatStrings(){
        stringState.printOrSum("asd");
        stringState.printOrSum("asd");
        stringState.printOrSum("asd");
        stringState.clearBuffer();

        verify(printerMock).print("asd (x3)");
    }

    @Test
    public void shouldNotCallPrinter(){
        stringState.clearBuffer();

        verify(printerMock, times(0)).print("");
    }
}
