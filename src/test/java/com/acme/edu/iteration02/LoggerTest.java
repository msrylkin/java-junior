package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysOutPrinter;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

@Ignore
public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        captureSysout();
    }
    //endregion

    @After
    public void tearDown() {
        resetOut();

    }

    private static final String SEP = System.lineSeparator();

   // TODO: implement Logger solution to match specification as tests


    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
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


    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
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


    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
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
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
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