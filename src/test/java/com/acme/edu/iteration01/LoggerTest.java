package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.PrefixLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
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

    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        Logger logger = new PrefixLogger();
        logger.log(1);
        logger.log(0);
        logger.log(-1);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1"+SEP+"primitive: 0"+SEP+"primitive: -1"+SEP);
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger logger = new PrefixLogger();
        logger.log((byte)1);
        logger.log((byte) 0);
        logger.log((byte) -1);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    /*
    TODO: implement Logger solution to match specification as tests

*/
    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Logger logger = new PrefixLogger();
        logger.log('a');
        logger.log('b');
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Logger logger = new PrefixLogger();
        logger.log("test string 1");
        logger.log("other str");
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }


    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        Logger logger = new PrefixLogger();
        logger.log(true);
        logger.log(false);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }


    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Logger logger = new PrefixLogger();
        logger.log(new Object());
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }


}