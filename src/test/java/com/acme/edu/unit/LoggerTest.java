package com.acme.edu.unit;

import com.acme.edu.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class LoggerTest {

    private IntState intState;
    private StringState stringState;
    private Printer printer;
    private Logger sut;
    private StateFactory stateFactory;

    @Before
    public void setUpTest(){
        intState = mock(IntState.class);
        stringState = mock(StringState.class);
        printer = mock(Printer.class);
        stateFactory = mock(StateFactory.class);
        when(stateFactory.getIntState()).thenReturn(intState);
        when(stateFactory.getStringState()).thenReturn(stringState);
        sut = new Logger(stateFactory);
    }


    @Test
    public void shouldLogIntegers(){
        sut.log(1);
        sut.log(1);
        sut.log(1);
        sut.log("asdzxc");

        verify(intState,times(3)).printOrSum("1");
    }

    @Test
    public void shouldLogSumOfStrings(){
        sut.log("asd");
        sut.log("asd");
        sut.log("asd");
        sut.log("zxc");

        verify(stringState,times(3)).printOrSum("asd");
        verify(stringState).printOrSum("zxc");
    }

    @Test @Ignore
    public void shouldLogPrimitivies(){
        sut.log('a');
        sut.log('b');
        sut.log(true);

        verify(printer).print("char: a");
        verify(printer).print("char: b");
        verify(printer).print("primitive: true");
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfPrinterIsNull(){
        Logger sut = new Logger(null);
    }

}
