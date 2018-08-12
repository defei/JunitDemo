package org.codelogger.tutorial.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.codelogger.tutorial.powermock.Dependency;
import org.codelogger.tutorial.powermock.SystemUnderTest;
import org.codelogger.tutorial.powermock.UtilityClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ UtilityClass.class})
public class PowerMockitoMockingStaticMethodTest {

	@Mock
	private Dependency dependencyMock;

	@InjectMocks
	private SystemUnderTest systemUnderTest;

    /**
     * 静态方法调用验证
     */
	@Test
	public void powerMockito_MockingAStaticMethodCall() {

		when(dependencyMock.retrieveAllStats()).thenReturn(
				Arrays.asList(1, 2, 3));

		PowerMockito.mockStatic(UtilityClass.class);

		when(UtilityClass.staticMethod(anyLong())).thenReturn(150);

		assertEquals(150, systemUnderTest.methodCallingAStaticMethod());

		//验证表态方法的调用
		//第一步 : 调用 PowerMockito.verifyStatic()
		//第二步 : 调用需要验证的静态方法
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(1 + 2 + 3);

		//验证实际调用次数
		PowerMockito.verifyStatic(Mockito.times(1));

	}
}