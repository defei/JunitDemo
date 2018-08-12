package org.codelogger.tutorial.powermock;

import java.util.ArrayList;
import java.util.List;

interface Dependency {
	List<Integer> retrieveAllStats();
}

public class SystemUnderTest {

	private Dependency dependency;

	public int methodUsingAnArrayListConstructor() {
		ArrayList list = new ArrayList();
		return list.size();
	}

	public int methodCallingAStaticMethod() {

		//privateMethodUnderTest calls static method SomeClass.staticMethod
		List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;
		for (int stat : stats) {
            sum += stat;
        }
		return UtilityClass.staticMethod(sum);
	}

    /**
     * private方法调用测试 {@linkplain org.codelogger.tutorial.powermock.PowerMockitoTestingPrivateMethodTest#powerMockito_CallingAPrivateMethod()}
     */
	private long privateMethodUnderTest() {
		List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;
		for (int stat : stats) {
            sum += stat;
        }
		return sum;
	}
}
