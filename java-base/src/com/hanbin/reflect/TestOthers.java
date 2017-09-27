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
		// 获取父类
		Class<? super Dog> superclass = clazz.getSuperclass();
		System.out.println("父类:" + superclass.getName());

		// 获取实现的接口
		Class<?>[] interfaces = clazz.getInterfaces();
		System.out.println("接口:");
		for (Class<?> iface : interfaces) {
			System.out.print(iface.getName() + " ");
		}

		System.out.println();

		// 取类所在的包
		Package package1 = clazz.getPackage();
		System.out.println("包：" + package1.getName());

		// 获取类的runtime生命周期的注解
		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
	}
}
