package org.codelogger.tutorial.junit.suite;

import org.codelogger.tutorial.junit.ArrayListTest;
import org.codelogger.tutorial.junit.helper.StringHelperTest;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * {@link RunWith} 标签可指定Junit按指定的{@link Runner} 运行测试用例
 * <br/>
 * {@link SuiteClasses} 指定一整套完成的测试，按顺序依次执行
 */
@RunWith(Suite.class)
@SuiteClasses({StringHelperTest.class, ArrayListTest.class})
public class DummyTestSuite {

}
