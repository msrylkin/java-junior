package com.acme.edu.iteration01;

import com.acme.edu.*;
import com.acme.edu.logger.Logger;
import com.acme.edu.logger.LoggerException;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.states.StateFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given

    private static final String SEP = System.lineSeparator();
    @Before
    public void setUpSystemOut() throws LoggerException {
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test @Ignore
    public void shouldLogInteger() throws LoggerException {
        //region when
        Logger logger = new Logger(new StateFactory(new ConsolePrinter()));
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
    public void shouldLogByte() throws LoggerException {
        //region when
        Logger logger = new Logger(new StateFactory(new ConsolePrinter()));
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
    public void shouldLogChar() throws LoggerException {
        //region when
        Logger logger = new Logger(new StateFactory(new ConsolePrinter()));
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
    public void shouldLogString() throws LoggerException {
        //region when
        Logger logger = new Logger(new StateFactory(new ConsolePrinter()));
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
    public void shouldLogBoolean() throws LoggerException {
        //region when
        Logger logger = new Logger(new StateFactory(new ConsolePrinter()));
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
    public void shouldLogReference() throws LoggerException {
        //region when
        Logger logger = new Logger(new StateFactory(new ConsolePrinter()));
        logger.log(new Object());
        logger.close();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }


}