package com.acme.edu.unit;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.logger.Logger;
import com.acme.edu.logger.LoggerException;
import com.acme.edu.printer.*;
import com.acme.edu.states.EmptyBufferState;
import com.acme.edu.states.IntState;
import com.acme.edu.states.State;
import com.acme.edu.states.StringState;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
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
    private File testFile;


    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUpTest() throws Exception {
        captureSysout();
        captureSyserr();
        testFile = temporaryFolder.newFile();
        consolePrinter = new ConsolePrinter();
        networkPrinter = new NetworkPrinter("127.0.0.1",6666,"UTF-8");
        filePrinter = new FilePrinter(testFile.getPath(),"UTF-8");
        mockLogger = mock(Logger.class);
    }


    @After
    public void tearDown() throws Exception{
        testFile.delete();
        //filePrinter.close();
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
    public void shouldLogToFile() throws Exception{
        filePrinter.print("asd");
        filePrinter.close();

        Assert.assertEquals("asd"+System.lineSeparator(), FileUtils.readFileToString(testFile));
    }

    @Test
    public void shouldThrowExceptionAtCreatingFilePrinter() throws Exception{
        filePrinter = new FilePrinter("ZXC://","UTF-4");

        assertSyserrContains("Error at creating");
    }

    @Test
    public void shouldAutoFlushWhenMessagesLowerThan50() throws Exception{
        String dummyData = "";
        for (int i = 0; i < 50; i++) {
            filePrinter.print(i+"");
            dummyData += i+System.lineSeparator();
        }

        Assert.assertEquals(dummyData,FileUtils.readFileToString(testFile));
    }

    @Test (expected = PrinterException.class)
    public void shouldCatchExceptionWhenFilePrinterClosing() throws PrinterException{
        filePrinter = new FilePrinter("ZXC://","UTF-4");
        filePrinter.close();
    }



//    @Test
//    public void shouldLog
}
