package com.hanbin.reflect;

import org.junit.Test;

public class TestClass {

	// 测试获取Class类的实例
	@Test
	public void testGetClass() throws ClassNotFoundException {
		// 1、通过运行时类本身的.class属性获取
		Class clazz = Dog.class;
		System.out.println(clazz);

		// 2、通过运行时类的对象获取
		Class clazz1 = new Dog().getClass();
		System.out.println(clazz1);

		// 3、通过Class的静态方法forName()获取
		Class clazz2 = Class.forName("com.hanbin.reflect.Dog");
		System.out.println(clazz2);

		// 通过类加载器获取
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class clazz3 = classLoader.loadClass("com.hanbin.reflect.Dog");
		System.out.println(clazz3);
	}
}
