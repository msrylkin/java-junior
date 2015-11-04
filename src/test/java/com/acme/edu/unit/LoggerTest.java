package com.acme.edu.unit;

import com.acme.edu.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by user on 03.11.2015.
 */
public class LoggerTest {

    private IntState intState;
    private StringState stringState;
    private Printer printer;
    private Logger sut;

    @Before
    public void setUpTest(){
        intState = mock(IntState.class);
        stringState = mock(StringState.class);
        printer = mock(Printer.class);
        sut = new Logger(printer,intState,stringState);
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

    @Test
    public void shouldLogPrimitivies(){
        sut.log('a');
        sut.log('b');
        sut.log(true);

        verify(printer).print("char: a");
        verify(printer).print("char: b");
        verify(printer).print("primitive: true");
    }

}
