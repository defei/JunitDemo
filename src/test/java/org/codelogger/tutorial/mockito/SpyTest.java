package org.codelogger.tutorial.mockito;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * {@link Mockito#spy(java.lang.Object)} 模拟给定的类，并包装该类的真实实例，通过包装类监听的所有行为,并会调用真实实现.
 */
@SuppressWarnings("unchecked")
public class SpyTest {

    /**
     * 监听对象
     */
    @Test
    public void test() {

        String target = "foo";

        List list = new LinkedList();
        List spy = spy(list);
        //等同于
        //List spy = spy(LinkedList.class);

        //异常: 根据默认配置 spy.get(0) 会调用真实方法，现在List里面没有数据，所以会跑出 IndexOutOfBoundsException
        //when(spy.get(0)).thenReturn("foo");

        //不过我们可以通过 doReturn() 方法模拟数据返回
        doReturn(target).when(spy).get(0);

        assertEquals(target, spy.get(0));
    }

    /**
     * 验证监听对象的操作及结果
     */
    @Test
    public void creatingASpyOnArrayList() {

        String target1 = "Defei";
        String target2 = "codelogger";
        List<String> listSpy = spy(ArrayList.class);

        listSpy.add(target1);
        listSpy.add(target2);
        //验证被监听的对象调用了指定方法次数，verify默认的times为1
        verify(listSpy).add(target1);
        verify(listSpy).add(target2);

        listSpy.add(target1);
        verify(listSpy, times(2)).add(target1);

        assertEquals(3, listSpy.size());
        assertEquals(target1, listSpy.get(0));
    }


    /**
     * 模拟方法返回结果
     */
    @Test
    public void creatingASpyOnArrayList_overridingSpecificMethods() {

        String target = "Defei";

        List<String> listSpy = spy(ArrayList.class);
        listSpy.add(target);
        listSpy.add("codelogger");

        assertEquals(2, listSpy.size());
        //以下3个模拟结果是相同的
        stub(listSpy.size()).toReturn(-1);
        //when(listSpy.size()).thenReturn(-1); //这个方法虽然也会调用真实方法，但真实方法本身没有抛出异常，所以可以在外层模拟返回值
        //doReturn(-1).when(listSpy).size();

        assertEquals(-1, listSpy.size());
        assertEquals(target, listSpy.get(0));
    }

}