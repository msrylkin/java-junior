package com.acme.edu.unit;

import com.acme.edu.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class LoggerTest {

    private IntState intState;
    private StringState stringState;
    private Printer printer;
    private Logger sut;
    private StateFactory stateFactory;
    private EmptyBufferState emptyBufferState;

    @Before
    public void setUpTest(){
        intState = mock(IntState.class);
        stringState = mock(StringState.class);
        emptyBufferState = mock(EmptyBufferState.class);
        printer = mock(Printer.class);
        stateFactory = mock(StateFactory.class);
        when(stateFactory.getIntState()).thenReturn(intState);
        when(stateFactory.getStringState()).thenReturn(stringState);
        when(stateFactory.getEmptyBufferState()).thenReturn(emptyBufferState);
        sut = new Logger(stateFactory);
    }


    @Test
    public void shouldLogIntegers() throws LoggerException{
        sut.log(1);
        sut.log(1);
        sut.log(1);
        sut.log("asdzxc");

        verify(intState,times(3)).log("1");
    }

    @Test
    public void shouldLogSumOfStrings() throws LoggerException{
        sut.log("asd");
        sut.log("asd");
        sut.log("asd");
        sut.log("zxc");

        verify(stringState,times(3)).log("asd");
        verify(stringState).log("zxc");
    }

    @Test
    public void shouldLogPrimitivies() throws LoggerException{
        sut.log('a');
        sut.log('b');
        sut.log(true);

        verify(emptyBufferState).log("char: a");
        verify(emptyBufferState).log("char: b");
        verify(emptyBufferState).log("primitive: true");
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfPrinterIsNull(){
        Logger sut = new Logger(null);
    }

}
