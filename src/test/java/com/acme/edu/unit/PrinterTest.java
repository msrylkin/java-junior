package com.acme.edu.unit;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.logger.Logger;
import com.acme.edu.logger.LoggerException;
import com.acme.edu.printer.*;
import com.acme.edu.states.EmptyBufferState;
import com.acme.edu.states.IntState;
import com.acme.edu.states.State;
import com.acme.edu.states.StringState;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.FileWriter;
import java.util.Objects;

import static org.mockito.Mockito.mock;

/**
 * Created by user on 08.11.2015.
 */
public class PrinterTest implements SysoutCaptureAndAssertionAbility {
    private ConsolePrinter consolePrinter;
    private NetworkPrinter networkPrinter;
    private FilePrinter filePrinter;
    private State mockState;
    private Logger mockLogger;



    @Before
    public void setUpTest() throws LoggerException {
        captureSysout();
        captureSyserr();
        consolePrinter = new ConsolePrinter();
        networkPrinter = new NetworkPrinter("127.0.0.1",6666,"UTF-8");
        filePrinter = new FilePrinter("temp.txt","UTF8");
        mockLogger = mock(Logger.class);
    }

    @After
    public void tearDown(){
        resetErr();
        resetOut();
    }

    @Test
    public void shouldLogWhenMessagesOver50() {
        for (int i=1;i<52;i++){
            consolePrinter.print(i+"");
        }

        assertSysoutContains("1");
        assertSysoutContains("49");
        assertSysoutContains("50");

    }

    @Test
    public void shouldNotLogWhenFilePrinterBufferNotFull() throws PrinterException{
        filePrinter.print("str1");
        filePrinter.print("str2");
        filePrinter.print("str3");

        assertSysoutEquals("");
    }

    @Test
    public void shouldLogToFile() throws PrinterException{
        filePrinter.print("asd");
    }

//    @Test
//    public void shouldLog
}
