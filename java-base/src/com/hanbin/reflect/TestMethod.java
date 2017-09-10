package com.hanbin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class TestMethod {
	Class<Dog> clazz = null;

	@Before
	public void before() {
		clazz = Dog.class;
	}

	@Test
	public void testGetMethods() {
		// ��ȡ����ʱ�༰�丸���public����
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}

		System.out.println();

		// ��ȡ����ʱ���ڲ����������з���
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
	}

	// ���Ի�ȡ��������Ϣ��ע�⡢Ȩ�޷������η�������ֵ���͡����ơ��β��б��쳣
	@Test
	public void testInformationOfMethod() throws Exception {
		Method declaredMethod = clazz.getDeclaredMethod("breath", int.class);

		// ֻ����������Ϊruntime��ע����ܻ�ȡ��override���ܻ�ȡ
		Annotation[] annotations = declaredMethod.getAnnotations();
		System.out.print("ע�⣺");
		for (Annotation annotation : annotations) {
			System.out.print(annotation);
		}

		System.out.println();

		int modifiers = declaredMethod.getModifiers();
		System.out.println("Ȩ�޷������η���" + Modifier.toString(modifiers));

		Class<?> returnType = declaredMethod.getReturnType();
		System.out.println("����ֵ���ͣ�" + returnType.getName());

		System.out.println("��������" + declaredMethod.getName());

		Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
		System.out.print("�β��б�");
		for (Class<?> parameterType : parameterTypes) {
			System.out.print(parameterType.getName() + " ");
		}

		Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
		System.out.println();
		System.out.println("�쳣��");
		for (Class<?> exceptionType : exceptionTypes) {
			System.out.print(exceptionType.getName() + " ");
		}
	}

	// ����ִ�з���
	@Test
	public void testUseMethod() throws Exception {
		Constructor<Dog> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
		Dog dog = declaredConstructor.newInstance("����", 3);

		// ���з���ֱ��ִ��
		Method say = clazz.getDeclaredMethod("say");
		say.invoke(dog);

		// ˽�з���ִ��ǰҪ����accessible����Ϊtrue������ᱨIllegalAccessException�쳣
		Method sleep = clazz.getDeclaredMethod("sleep");
		sleep.setAccessible(true);
		sleep.invoke(dog);

		// ��̬����ִ��ֱ����Classʵ��
		Method run = clazz.getDeclaredMethod("run");
		run.invoke(Dog.class);
	}
}
