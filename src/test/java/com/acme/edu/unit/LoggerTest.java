package com.acme.edu.unit;

import com.acme.edu.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

/**
 * Created by user on 03.11.2015.
 */
public class LoggerTest {



    @Test
    public void shouldLogSumOfIntAfterClose(){
        Printer mock = mock(Printer.class);
        Logger sut = new Logger(mock);

        sut.log(1);
        sut.log(1);
        sut.close();

        verify(mock).print("2");
    }

    @Test
    public void shouldDublicateStrings(){
        Printer mock = mock(Printer.class);
        State sut = new StringState(mock);

        sut.printOrSum("qwe");
        sut.printOrSum("qwe");
        sut.printOrSum("qwe");
        sut.printOrSum("str 3");
        sut.clearBuffer();

        verify(mock).print("qwe (x3)");
        verify(mock).print("str 3");
    }


    @Test
    public void shouldSumInt(){
        Printer mock = mock(Printer.class);
        State sut = new IntState(mock);

        sut.printOrSum("1");
        sut.printOrSum("10");
        sut.printOrSum("100");
        sut.clearBuffer();

        verify(mock).print("111");
    }


}
