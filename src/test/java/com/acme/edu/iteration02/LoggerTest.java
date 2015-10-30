package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
        Logger.close();
    }

    private static final String SEP = System.lineSeparator();

   // TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1",false);
        Logger.log(1,true);
        Logger.log(2,true);
        Logger.log("str 2",false);
        Logger.log(0,false);
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
        Logger.log("str 1",false);
        Logger.log(10,true);
        Logger.log(Integer.MAX_VALUE,true);
        Logger.log("str 2",false);
        Logger.log(0,false);
        //Logger.close();
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
        Logger.log("str 1",false);
        Logger.log((byte)10,true);
        Logger.log((byte)Byte.MAX_VALUE,true);
        Logger.log("str 2",false);
        Logger.log(0,false);
        //Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "str 1" + SEP +
                        "10" + SEP +
                        Byte.MAX_VALUE + SEP +
                        "str 2" + SEP +
                        "0" + SEP
        );
        //endregion
    }



    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.log("str 1",false);
        Logger.log("str 2",false);
        Logger.log("str 2",false);
        Logger.log(0,true);
        Logger.log("str 2",false);
        Logger.log("str 3",false);
        Logger.log("str 3",false);
        Logger.log("str 3",false);
        Logger.log(0,false);
        //Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "str 1" + SEP +
                        "str 2 (x2)" + SEP +
                        "0" + SEP +
                        "str 2" + SEP +
                        "str 3 (x3)" + SEP +
                        "0" + SEP
        );
        //endregion
    }


}