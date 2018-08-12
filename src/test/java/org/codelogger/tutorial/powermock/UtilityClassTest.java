package org.codelogger.tutorial.powermock;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author defei
 * @since 9/28/18.
 */
public class UtilityClassTest {

    @Test(expected = RuntimeException.class)
    public void staticMethod() throws Exception {

        UtilityClass.staticMethod(1);
    }

}