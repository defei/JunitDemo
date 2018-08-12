package org.codelogger.tutorial.powermock;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * 必须以 {@link PowerMockRunner} 运行有PowerMock功能的测试类，并且对需要模拟表态方法对应的类需要使用{@link PrepareForTest}做初始化准备
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SystemUnderTest.class})
public class PowerMockitoMockingConstructorTest {

    private static final int SOME_DUMMY_SIZE = 100;

    @Mock
    private Dependency dependencyMock;

    @InjectMocks
    private SystemUnderTest systemUnderTest;

    @Test
    public void powerMockito_MockingAConstructor() throws Exception {

        ArrayList<String> mockList = mock(ArrayList.class);

        stub(mockList.size()).toReturn(SOME_DUMMY_SIZE);

        //模拟内部ArrayList的初始化后得到的值
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(
                mockList);

        int size = systemUnderTest.methodUsingAnArrayListConstructor();

        assertEquals(SOME_DUMMY_SIZE, size);
        verify(dependencyMock, never()).retrieveAllStats();
    }
}