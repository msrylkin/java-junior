package com.acme.edu.unit;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.logger.Logger;
import com.acme.edu.logger.LoggerException;
import com.acme.edu.printer.Printer;
import com.acme.edu.printer.PrinterException;
import com.acme.edu.states.EmptyBufferState;
import com.acme.edu.states.IntState;
import com.acme.edu.states.State;
import com.acme.edu.states.StringState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

/**
 * Created by user on 04.11.2015.
 */
public class StateTest implements SysoutCaptureAndAssertionAbility{

    private IntState intState;
    private StringState stringState;
    private EmptyBufferState emptyBufferState;
    private Logger loggerMock;
    private Printer printerMock;

    @Before
    public void setUpTest() throws LoggerException {
        captureSyserr();
        printerMock = mock(Printer.class);
        intState = new IntState(printerMock);
        stringState = new StringState(printerMock);
        emptyBufferState = new EmptyBufferState(printerMock);
        loggerMock = mock(Logger.class);
    }

    @After
    public void tearDown(){
        resetErr();
    }

    @Test
    public void shouldPrintWhenIntBufferOverFLow() throws PrinterException{
        intState.log(String.valueOf(Integer.MAX_VALUE));
        intState.log("1");

        verify(printerMock).print(String.valueOf(Integer.MAX_VALUE));
    }

    @Test
    public void shouldPrintWhenBufferOverFLowAtNegativeNumbers() throws PrinterException{
        intState.log(String.valueOf(Integer.MIN_VALUE));
        intState.log(String.valueOf("-1"));


        verify(printerMock).print(String.valueOf(Integer.MIN_VALUE));
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
    public void shouldLogInstantlyLogPrimitives() throws PrinterException{
        emptyBufferState.log('a'+"");
        emptyBufferState.log('a'+"");
        emptyBufferState.log('a'+"");

        verify(printerMock, times(3)).print("a");
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

    @Test
    public void shouldCatchPrinterExceptionInStringState() throws PrinterException{
        String dummyMessage = "test";
        Mockito.doThrow(PrinterException.class).when(printerMock).print(dummyMessage);

        stringState.log(dummyMessage);
        stringState.close();

        assertSyserrContains("Error at printing message in");
        assertSyserrContains("com.acme.edu.printer.PrinterException");
    }

    @Test
    public void shouldCatchPrinterExceptionInIntState() throws PrinterException{
        int dummyInt = 123;
        Mockito.doThrow(PrinterException.class).when(printerMock).print(dummyInt+"");

        stringState.log(dummyInt+"");
        stringState.close();

        assertSyserrContains("Error at printing message in");
        assertSyserrContains("com.acme.edu.printer.PrinterException");

    }

    @Test
    public void shouldCatchExceptionInEmptyBufferState() throws PrinterException{
        char dummy = 'a';
        doThrow(PrinterException.class).when(printerMock).print(dummy+"");

        emptyBufferState.log(dummy+"");
        emptyBufferState.close();

        assertSyserrContains("Error at printing message in");
        assertSyserrContains("com.acme.edu.printer.PrinterException");
    }

    @Test
    public void shouldCatchExceptionInState() throws PrinterException{
        doThrow(PrinterException.class).when(printerMock).close();

        emptyBufferState.close();

        assertSyserrContains("Error at closing");
        assertSyserrContains("com.acme.edu.printer.PrinterException");
    }

    @Test
    public void shouldCatchExceptionInIntStateAtCleaningBuffer() throws PrinterException{
        String dummyData = "123";
        doThrow(PrinterException.class).when(printerMock).print(dummyData);

        intState.log(dummyData);
        intState.clearBuffer();

        assertSyserrContains("Error at printing message in");
        assertSyserrContains("com.acme.edu.printer.PrinterException");
    }
}
