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
		// getConstructors()��ȡpublic�Ĺ��캯��
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}

		System.out.println();

		// getDeclaredConstructors()��ȡ���й��캯��
		Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : declaredConstructors) {
			System.out.println(constructor);
		}
	}

	@Test
	public void testInformationOfConstructor() throws Exception {
		// ��ȡָ���Ĺ��캯��
		Constructor<Dog> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
		int modifiers = declaredConstructor.getModifiers();

		System.out.println("���췽���ķ���Ȩ�����η�Ϊ��" + Modifier.toString(modifiers));

		Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
		System.out.println("���췽���Ĳ�������Ϊ��");
		for (Class<?> class1 : parameterTypes) {
			System.out.print(class1.getName() + " ");
		}
	}

	// ͨ�������ȡ�Ĺ��캯��������Ķ���
	@Test
	public void testUseContructor() throws Exception {
		Constructor<Dog> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
		Dog dog = declaredConstructor.newInstance("����", 3);
		System.out.println(dog);

		// ˽�й��캯����������ʱ��Ҫ�����ù��캯����accessible����Ϊtrue������ᱨIllegalAccessException�쳣
		Constructor<Dog> declaredConstructor2 = clazz.getDeclaredConstructor(String.class);
		declaredConstructor2.setAccessible(true);
		Dog dog2 = declaredConstructor2.newInstance("С��");
		System.out.println(dog2);
	}
}
