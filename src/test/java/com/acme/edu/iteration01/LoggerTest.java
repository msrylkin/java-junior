package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.SysOutPrinter;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given

    private static final String SEP = System.lineSeparator();
    @Before
    public void setUpSystemOut() throws IOException {
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test @Ignore
    public void shouldLogInteger() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log(1);
        logger.log(0);
        logger.log(-1);
        logger.close();
        //endregion

        //region then
        //assertSysoutContains("primitive: ");
        //assertSysoutEquals("primitive: 1"+SEP+"primitive: 0"+SEP+"primitive: -1"+SEP);
        assertSysoutEquals("0"+SEP);
        //endregion
    }

    @Test @Ignore
    public void shouldLogByte() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log((byte)1);
        logger.log((byte)0);
        logger.log((byte)-1);
        logger.close();
        //endregion

        //region then
//        assertSysoutContains("primitive: ");
//        assertSysoutContains("1");
//        assertSysoutContains("0");
//        assertSysoutContains("-1");
        assertSysoutEquals("0" + SEP);
        //endregion
    }

    /*
    TODO: implement Logger solution to match specification as tests

*/
    @Test @Ignore
    public void shouldLogChar() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log('a');
        logger.log('b');
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test @Ignore
    public void shouldLogString() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log("test string 1");
        logger.log("other str");
        logger.close();
        //endregion

        //region then
        //assertSysoutEquals("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }


    @Test @Ignore
    public void shouldLogBoolean() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log(true);
        logger.log(false);
        logger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }


    @Test @Ignore
    public void shouldLogReference() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log(new Object());
        logger.close();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }


}