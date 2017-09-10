package com.hanbin.reflect;

import java.lang.annotation.Annotation;

import org.junit.Before;
import org.junit.Test;

public class TestOthers {
	Class<Dog> clazz = null;

	@Before
	public void before() {
		clazz = Dog.class;
	}

	@Test
	public void test() {
		// ��ȡ����
		Class<? super Dog> superclass = clazz.getSuperclass();
		System.out.println("���ࣺ" + superclass.getName());

		// ��ȡʵ�ֵĽӿ�
		Class<?>[] interfaces = clazz.getInterfaces();
		System.out.println("�ӿڣ�");
		for (Class<?> iface : interfaces) {
			System.out.print(iface.getName() + " ");
		}

		System.out.println();

		Package package1 = clazz.getPackage();
		System.out.println("����" + package1.getName());

		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
	}
}
