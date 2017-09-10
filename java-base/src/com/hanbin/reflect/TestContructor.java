package com.hanbin.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class TestContructor {
	Class<Dog> clazz = null;

	@Before
	public void before() {
		clazz = Dog.class;
	}

	@Test
	public void testGetContructors() {
		// getConstructors()获取public的构造函数
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}

		System.out.println();

		// getDeclaredConstructors()获取所有构造函数
		Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : declaredConstructors) {
			System.out.println(constructor);
		}
	}

	@Test
	public void testInformationOfConstructor() throws Exception {
		// 获取指定的构造函数
		Constructor<Dog> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
		int modifiers = declaredConstructor.getModifiers();

		System.out.println("构造方法的访问权限修饰符为：" + Modifier.toString(modifiers));

		Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
		System.out.println("构造方法的参数类型为：");
		for (Class<?> class1 : parameterTypes) {
			System.out.print(class1.getName() + " ");
		}
	}

	// 通过反射获取的构造函数创建类的对象
	@Test
	public void testUseContructor() throws Exception {
		Constructor<Dog> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
		Dog dog = declaredConstructor.newInstance("旺财", 3);
		System.out.println(dog);

		// 私有构造函数创建对象时需要先设置构造函数的accessible属性为true，否则会报IllegalAccessException异常
		Constructor<Dog> declaredConstructor2 = clazz.getDeclaredConstructor(String.class);
		declaredConstructor2.setAccessible(true);
		Dog dog2 = declaredConstructor2.newInstance("小黑");
		System.out.println(dog2);
	}
}
