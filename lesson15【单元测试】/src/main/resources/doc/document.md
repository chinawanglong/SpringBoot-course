[toc]

# Junit单元测试

JUnit是一个Java编程语言的单元测试框架。Junit在测试驱动的开发方面有很重要的发展，是起源于JUnit的一个统称为xUnit的单元


* 优点
 
>
>可以书写一系列的测试方法，对项目所有的接口或者方法进行单元测试
>
>启动后，自动化测试，并判断执行结果，不需要人为的干预
>
>只需要查看最后结果，就知道整个项目的方法接口是否通畅
>
>每个单元测试用例相对独立，由Junit启动，自动调用，不需要添加额外的调用语句
>
>添加、删除、屏蔽测试方法，不影响其它的测试方法，开源框架都对JUnit有相应的支持
>


* Junit断言

1 void assertEquals(boolean expected, boolean actual) 检查两个变量或者等式是否平衡

2 void assertTrue(boolean expected, boolean actual) 检查条件为真

3 void assertFalse(boolean condition) 检查条件为假

4 void assertNotNull(Object object) 检查对象不为空

5 void assertNull(Object object) 检查对象为空

6 void assertSame(boolean condition) assertSame检查两个相关对象是否指向同一个对象

7 void assertNotSame(boolean condition) assertNotSame检查两个相对对象是否不指向同一个对象

8 void assertArrayEquals(expectedArray, resultArray) assertArrayEquals()检查两个数组是否相等

* Junit注解

1. @Test 这个注释说明依附在JUnit的public void 方法可以作为一个测试案例

2 @Before 有些测试在运行前需要创造几个相似的对象， 在public void 方法加该注解是因为该方法需要在test方法前运行

3 @After 如果你将外部资源在Before方法中分配，那么你需要在测试运行后释放他们，在public void方法加该注解是因为该方法需要在test方法后运行

4 @BeforeClass 在public void方法加该注解是因为该方法需要在类中所有方法前运行

5 @AfterClass 它将会使方法在所有测试结束后执行，这个可以用来进行清理活动

6 @Ignore 这个注解是用来忽略有关不需要执行的测试


* 原则

1。 测试方法上必须使用@Test进行修饰

2。 测试方法必须使用public void进行修饰， 不能带任何参数

3。 新建一个源代码目录来存放我们的测试代码，将测试代码和业务代码分开

4。 测试类所在的包名应该和被测试类的包名保持一致

5。 测试单元中的每个方法必须可以独立测试，测试方法间不能有任何的依赖
 




