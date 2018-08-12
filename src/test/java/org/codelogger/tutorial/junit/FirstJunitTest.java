package org.codelogger.tutorial.junit;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Junit测试代码在maven中默认都在目录`src/test/java`目录下，测试资源文件目录默认为`src/test/resources`
 * <br/>
 * 所有Junit测试方法都以注解 {@link Test} 为入口，且方法必须为public的
 * <br/>
 * Junit在 {@link Assert} 中提供了常用的测试断言
 */
public class FirstJunitTest {

    @Test
    public void test() {

        String expected = "ab";
        String target = "a" + "b";

        Assert.assertEquals(expected, target);
        Assert.assertTrue(expected.equals(target));
    }

    @Test
    public void testArraySort_RandomArray() {
        int[] numbers = { 12, 3, 4, 1 };
        int[] expected = { 1, 3, 4, 12 };
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

}
