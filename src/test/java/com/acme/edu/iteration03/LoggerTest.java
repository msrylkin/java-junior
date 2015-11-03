package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysOutPrinter;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    private static final String SEP = System.lineSeparator();

    //TODO: implement Logger solution to match specification as tests

    @Test @Ignore
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());

        logger.log(new int[]{-1, 0, 1});
        logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "primitives array: {-1, 0, 1}" + SEP
        );
        //endregion
    }


    @Test @Ignore
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        logger.close();
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {" +SEP+
                "{-1, 0, 1}" +SEP+
                "{1, 2, 3}" +SEP+
                "{-1, -2, -3}" +SEP+
            "}"+SEP
        );
        //endregion
    }


    @Test @Ignore
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log(new int[][][][] {{{{0}}}});
        logger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "primitives multimatrix: {" + SEP +
                        "{" + SEP + "{" + SEP + "{" +
                        "0" +
                        "}" + SEP + "}" + SEP + "}" + SEP +
                        "}" + SEP
        );
        //endregion
    }


    @Test @Ignore
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log("str1", "string 2", "str 3");
        logger.close();
        //endregion

        //region then
        assertSysoutContains("str1" + SEP + "string 2" + SEP + "str 3");
        //endregion
    }

    @Test @Ignore
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log(-1, 0, 1, 3);
        logger.close();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test @Ignore
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        Logger logger = new Logger(new SysOutPrinter());
        logger.log(1);
        logger.log("str");
        logger.log(Integer.MAX_VALUE - 10);
        logger.log(11);
        logger.close();
        //endregion

        //region then
        assertSysoutContains("1");
        assertSysoutContains("str");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE - 10));
        assertSysoutContains("11");
        //endregion
    }


}