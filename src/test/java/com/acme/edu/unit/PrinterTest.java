package com.acme.edu.unit;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.logger.Logger;
import com.acme.edu.logger.LoggerException;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.FilePrinter;
import com.acme.edu.printer.NetworkPrinter;
import com.acme.edu.printer.Printer;
import com.acme.edu.states.EmptyBufferState;
import com.acme.edu.states.IntState;
import com.acme.edu.states.State;
import com.acme.edu.states.StringState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        captureSyserr();
        consolePrinter = new ConsolePrinter();
        networkPrinter = new NetworkPrinter("127.0.0.1",6666,"UTF-8");
        //FilePrinter filePrinter = new FilePrinter()
        mockLogger = mock(Logger.class);
    }

    @After
    public void tearDown(){
        resetErr();
    }

//    @Test
//    public void shouldlogWhenMessagesOver50() {
//        for (int i=1;i<52;i++){
//            consolePrinter.print(i+"");
//        }
//
//
//    }
}
