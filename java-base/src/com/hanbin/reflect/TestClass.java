package com.hanbin.reflect;

import org.junit.Test;

public class TestClass {

	// ���Ի�ȡClass���ʵ��
	@Test
	public void testGetClass() throws ClassNotFoundException {
		// 1��ͨ������ʱ�౾���.class���Ի�ȡ
		Class clazz = Dog.class;
		System.out.println(clazz);

		// 2��ͨ������ʱ��Ķ����ȡ
		Class clazz1 = new Dog().getClass();
		System.out.println(clazz1);

		// 3��ͨ��Class�ľ�̬����forName()��ȡ
		Class clazz2 = Class.forName("com.hanbin.reflect.Dog");
		System.out.println(clazz2);

		// ͨ�����������ȡ
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class clazz3 = classLoader.loadClass("com.hanbin.reflect.Dog");
		System.out.println(clazz3);
	}
}
