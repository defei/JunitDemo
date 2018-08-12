package org.codelogger.tutorial.mockito;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link Mockito#mock(java.lang.Class)} 模拟给定的类，并监听的所有行为, 但不会真实实例会这个类，也不会调用真实实现.
 */
@SuppressWarnings("unchecked")
public class MockTest {

    /**
     * 调用模拟对方的 {@link ArrayList#get(int)} 方法，在没有数据的时候也不会抛出异常
     * <br/>
     * 但真实情况是会抛出异常的，请参考
     */
    @Test
    public void calledListGetMethod_listIsEmpty_NoExceptionHappened() {

        ArrayList list = mock(ArrayList.class);
        list.get(0);
    }

    /**
     * 模拟方法返回值，不管调用多少次，都是相同的值
     */
    @Test
    public void letsMockListSize() {

        List list = mock(List.class);
        when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
        assertEquals(10, list.size());
    }

    /**
     * 模拟多次方法返回值，调用的返回值按模拟顺寻以此返回，先进先出，超出模拟次数的调用，返回最后一次模拟的值
     * <br/>
     * 可以用于模拟循环调用时，调用同一个方法，给不同的返回值，比如分页查询
     */
    @Test
    public void letsMockListSizeWithMultipleReturnValues() {
        List list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size()); // 第1次调用
        assertEquals(20, list.size()); // 第2次调用
        assertEquals(20, list.size()); // 第3次调用
    }

    /**
     * 模拟指定传参的方法调用的返回值
     */
    @Test
    public void letsMockListGet() {
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("codelogger");
        assertEquals("codelogger", list.get(0));
        assertNull(list.get(1));
    }

    /**
     * 模拟通用传参的方法调用的返回值
     */
    @Test
    public void letsMockListGetWithAny() {
        List<String> list = mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn("codelogger");
        // If you are using argument matchers, all arguments
        // have to be provided by matchers.
        assertEquals("codelogger", list.get(0));
        assertEquals("codelogger", list.get(1));
    }

    /**
     * 模拟指定方法调用抛出异常
     */
    @Test(expected = RuntimeException.class)
    public void letsMockListGetToThrowException() {
        List<String> list = mock(List.class);
        when(list.get(Mockito.anyInt())).thenThrow(
                new RuntimeException("Something went wrong"));
        list.get(0);
    }

    /**
     * BDD风格的撒气
     */
    @Test
    public void bddAliases_UsingGivenWillReturn() {

        List<String> list = mock(List.class);

        //given
        given(list.get(Mockito.anyInt())).willReturn("codelogger");

        //then
        assertThat("codelogger", is(list.get(0)));
        assertThat("codelogger", is(list.get(1)));
    }
}
