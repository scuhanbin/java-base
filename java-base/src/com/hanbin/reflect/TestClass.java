package com.hanbin.reflect;

import org.junit.Test;

public class TestClass {
	@Test
	public void testGetClass() throws ClassNotFoundException {
		Class clazz = Dog.class;
		System.out.println(clazz);

		Class clazz1 = new Dog().getClass();
		System.out.println(clazz1);

		Class clazz2 = Class.forName("com.hanbin.reflect.Dog");
		System.out.println(clazz2);

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class clazz3 = classLoader.loadClass("com.hanbin.reflect.Dog");
		System.out.println(clazz3);
	}
}
