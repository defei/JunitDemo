# Junit and Mockito教学

## 目录

* [Maven依赖](#Maven依赖)
* [教学目录](#教学目录)
  - [课程列表](#课程列表)

## Maven依赖

```xml
<dependencies>
	<dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.12</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>org.mockito</groupId>
		<artifactId>mockito-all</artifactId>
		<version>1.10.19</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>org.hamcrest</groupId>
		<artifactId>hamcrest-library</artifactId>
		<version>1.3</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>org.powermock</groupId>
		<artifactId>powermock-api-mockito</artifactId>
		<version>1.6.4</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>org.powermock</groupId>
		<artifactId>powermock-module-junit4</artifactId>
		<version>1.6.4</version>
		<scope>test</scope>
	</dependency>
</dependencies>
```

## 教学目录

### 课程列表

#### JUnit
- Step 01 : 认识Junit，访问类`org.codelogger.tutorial.junit.FirstJunitTest`
- Step 02 : 异常测试，和性能测试 访问类`org.codelogger.tutorial.junit.ArrayListTest`
- Step 03 : 测试用例执行顺序 访问类`org.codelogger.tutorial.junit.QuickBeforeAfterTest`
- Step 04 : 参数化测试 访问类`org.codelogger.tutorial.junit.helper.StringHelperParameterizedTest`
- Step 04 : Hamcrest测试 访问类`org.codelogger.tutorial.junit.HamcrestMatcherTest`, 更多的请看[Hamcrest](Hamcrest.md)

#### Mockito
- Step 01 : 非透传模拟 `org.codelogger.tutorial.mockito.MockTest` 
- Step 02 : 透传模拟 `org.codelogger.tutorial.mockito.SpyTest` 
- Step 03 : 模拟依赖测试逻辑(非注入) `org.codelogger.tutorial.mockito.SpyTest` 
- Step 04 : 模拟依赖测试逻辑(非注入) `org.codelogger.tutorial.mockito.SpyTest` 
- Step 05 : 模拟依赖测试逻辑(非注入) `org.codelogger.tutorial.business.TodoBusinessImplMockitoTest` 
- Step 06 : 模拟依赖测试逻辑(注入并指定运行器) `org.codelogger.tutorial.business.TodoBusinessImplMockitoInjectMocksTest` 
- Step 07 : 模拟依赖测试逻辑(注入并指定规则) `org.codelogger.tutorial.business.TodoBusinessImplMockitoRulesTest`
 
#### PowerMock
 - Step 01 : 构造函数值测试 `org.codelogger.tutorial.mockito.MockTest` 
 - Step 02 : 静态方法测试 `org.codelogger.tutorial.powermock.PowerMockitoMockingStaticMethodTest.powerMockito_MockingAStaticMethodCall` 
 - Step 03 : private方法测试 `org.codelogger.tutorial.powermock.PowerMockitoTestingPrivateMethodTest`
  
  
#### 特别感谢
[in28minutes](https://github.com/in28minutes/MockitoIn28Minutes)
