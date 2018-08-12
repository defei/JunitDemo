package org.codelogger.tutorial.junit;

import org.junit.*;

/**
 * 测试用例执行顺序示例
 */
public class QuickBeforeAfterTest {

    /**
     * {@link BeforeClass} 标记的static方法在整个测试开始之前会被执行一次，且只执行一次
     * <br/>
     * 一般用于准备全局数据
     */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    /**
     * 在每个 {@link Test} 方法执行之前，都会被执行一次
     * <br/>
     * 一般用于重置测试环境数据
     */
    @Before
    public void setup() {
        System.out.println("Before Test");
    }

    @Test
    public void test1() {
        System.out.println("test1 executed");
    }

    @Test
    public void test2() {
        System.out.println("test2 executed");
    }

    /**
     * 在每个 {@link Test} 方法执行之后，都会被执行一次
     * <br/>
     * 一般用于清理数据或做统一验证
     */
    @After
    public void teardown() {
        System.out.println("After test");
    }

    /**
     * {@link AfterClass} 标记的static方法在整个测试开始之前会被执行一次，且只执行一次
     * <br/>
     * 一般用于清理全局数据
     */
    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

}
