package org.codelogger.tutorial.powermock;

public class UtilityClass {

    static int staticMethod(long value) {

        throw new RuntimeException("请不要实际执行我");
    }
}
