package org.codelogger.tutorial.junit;

import java.util.ArrayList;
import java.util.Arrays;
import org.codelogger.tutorial.mockito.MockTest;
import org.junit.Test;

/**
 * @author defei
 * @since 9/28/18.
 */
public class ArrayListTest {

    /**
     * 异常期待
     * <br/>
     * 空ArrayList调用 {@link ArrayList#get(int)} 是会抛出 {@link IndexOutOfBoundsException} 异常
     * <br/>
     * 但通过Mockito模拟,调用模拟对象的 {@link ArrayList#get(int)} 方法，在没有数据的时候也不会抛出异常，详见 {@link
     * MockTest#calledListGetMethod_listIsEmpty_NoExceptionHappened()}
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void calledListGetMethod_listIsEmpty_NoExceptionHappened() {

        ArrayList list = new ArrayList();
        list.get(0);
    }

    /**
     * 性能测试，可以设置超时时间
     */
    @Test(timeout = 100)
    public void testPerformance() {
        for (int i = 0; i < 1000000; i++) {
            Arrays.sort(new int[]{i, i - 1, i + 1});
        }
    }
}
