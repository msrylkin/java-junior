package com.acme.edu.iteration02;

import com.acme.edu.*;
import com.acme.edu.logger.Logger;
import com.acme.edu.logger.LoggerException;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.states.StateFactory;
import org.junit.Ignore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws LoggerException {
        captureSysout();
    }
    //endregion

    @After
    public void tearDown() {
        resetOut();
    }

    private static final String SEP = System.lineSeparator();

   // TODO: implement Logger solution to match specification as tests


    @Test @Ignore
    public void shouldLogSequentIntegersAsSum() throws LoggerException {
        //region when
        Logger logger = new Logger(new StateFactory(new ConsolePrinter()));
        logger.log("str 1");
        logger.log(1);
        logger.log(2);
        logger.log("str 2");
        logger.log(0);
        logger.close();
        //Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "str 1" + SEP +
                        "3" + SEP +
                        "str 2" + SEP +
                        "0" + SEP
        );
        //endregion
    }


    @Test @Ignore
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws LoggerException{
        //region when
        Logger logger = new Logger(new StateFactory(new ConsolePrinter()));
        logger.log("str 1");
        logger.log(10);
        logger.log(Integer.MAX_VALUE);
        logger.log("str 2");
        logger.log(0);
        logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "str 1" + SEP +
                        "10" + SEP +
                        Integer.MAX_VALUE + SEP +
                        "str 2" + SEP +
                        "0" + SEP
        );
        //endregion
    }


    @Test @Ignore
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws LoggerException{
        //region when
        Logger logger = new Logger(new StateFactory(new ConsolePrinter()));
        logger.log("str 1");
        logger.log((byte)10);
        logger.log((byte) Byte.MAX_VALUE);
        logger.log("str 2");
        logger.log(0);
        logger.close();
        //Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "str 1" + SEP +
                        "137" + SEP +
                        "str 2" + SEP +
                        "0" + SEP
        );
        //endregion
    }



    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws LoggerException {
        //region when
        Logger logger = new Logger(new StateFactory(new ConsolePrinter()));
        logger.log("str 1");
        logger.log("str 2");
        logger.log("str 2");
        logger.log(0);
        logger.log("str 2");
        logger.log("str 3");
        logger.log("str 3");
        logger.log("str 3");
        logger.close();
        //Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "str 1" + SEP +
                        "str 2 (x2)" + SEP +
                        "0" + SEP +
                        "str 2" + SEP +
                        "str 3 (x3)" + SEP
        );
        //endregion
    }


}