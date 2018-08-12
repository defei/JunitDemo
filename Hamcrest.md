JUnit4.4引入了Hamcrest框架，Hamcest提供了一套匹配符Matcher，这些匹配符更接近自然语言，可读性高，更加灵活。

##### 核心：

- anything - 总是匹配,如果你不关心测试下的对象是什么是有用的
- describedAs - 添加一个定制的失败表述装饰器
- is - 改进可读性装饰器 - 见下 “Sugar”

##### 逻辑：

- allOf - 如果所有匹配器都匹配才匹配,像Java里的&&
- anyOf - 如果任何匹配器匹配就匹配,像Java里的||
- not - 如果包装的匹配器不匹配器时匹配,反之亦然

##### 对象

- equalTo - 测试对象相等使用Object.equals方法
- hasToString - 测试Object.toString方法
- instanceOf, isCompatibleType - 测试类型
- notNullValue, nullValue - 测试null
- sameInstance - 测试对象实例

##### Beans：

- hasProperty - 测试JavaBeans属性

#####集合：

- array - 测试一个数组元素test an array’s elements against an array of matchers
- hasEntry, hasKey, hasValue - 测试一个Map包含一个实体,键或者值
- hasItem, hasItems - 测试一个集合包含一个元素
- hasItemInArray - 测试一个数组包含一个元素

##### 数字

- closeTo - 测试浮点值接近给定的值
- greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - 测试次序

##### 文本

- equalToIgnoringCase - 测试字符串相等忽略大小写
- equalToIgnoringWhiteSpace - 测试字符串忽略空白
- containsString, endsWith, startsWith - 测试字符串匹配
    
----

```java
    //Junit风格
    @Test
    public void test_with_junit_assert() {
        int expected = 51;
        int actual = 51;
 
        assertEquals("failure - They are not same!", expected, actual);
    }
 
    //Hamcrest风格
    @Test
    public void test_with_hamcrest_assertThat() {
        int expected = 51;
        int actual = 51;
 
        assertThat("failure - They are not same!", actual, equalTo(expected));
    }
```

两个明显的区别：

1. 参数顺序。两者的expected 和 actual 前后顺序是相反的。
2. Hamcrest 几乎总是直接使用对象。它的语法更符合函数式编程的风格。

这点很好理解了，Junit 总是获取值后再比较，因为比较的是简单的值，因此被比较的放在前面更符合习惯。
而Hamcrest 是直接对测试结果的对象进行一些更复杂的匹配。
 
