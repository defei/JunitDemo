package org.codelogger.tutorial.powermock;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class PowerMockitoTestingPrivateMethodTest {

    @Mock
    private Dependency dependencyMock;

    @InjectMocks
    private SystemUnderTest systemUnderTest;

    /**
     * 测试 private 方法调用
     */
    @Test
    public void powerMockito_CallingAPrivateMethod() throws Exception {

        when(dependencyMock.retrieveAllStats()).thenReturn(
                Arrays.asList(1, 2, 3));

        long value = Whitebox.invokeMethod(systemUnderTest,
                "privateMethodUnderTest");

        assertEquals(6, value);
    }
}