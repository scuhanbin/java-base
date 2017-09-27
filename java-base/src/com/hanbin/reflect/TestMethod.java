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
		// 获取运行时类及其父类的public方法
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}

		System.out.println();

		// 获取运行时类内部声明的所有方法
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
	}

	// 测试获取方法的信息：注解、权限访问修饰符、返回值类型、名称、形参列表、异常
	@Test
	public void testInformationOfMethod() throws Exception {
		Method declaredMethod = clazz.getDeclaredMethod("breath", int.class);

		// 只有生命周期为runtime的注解才能获取，override不能获取
		Annotation[] annotations = declaredMethod.getAnnotations();
		System.out.print("注解：");
		for (Annotation annotation : annotations) {
			System.out.print(annotation);
		}

		System.out.println();

		int modifiers = declaredMethod.getModifiers();
		System.out.println("权限访问修饰符：" + Modifier.toString(modifiers));

		Class<?> returnType = declaredMethod.getReturnType();
		System.out.println("返回值类型：" + returnType.getName());

		System.out.println("方法名：" + declaredMethod.getName());

		Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
		System.out.print("形参列表：");
		for (Class<?> parameterType : parameterTypes) {
			System.out.print(parameterType.getName() + " ");
		}

		Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
		System.out.println();
		System.out.println("异常：");
		for (Class<?> exceptionType : exceptionTypes) {
			System.out.print(exceptionType.getName() + " ");
		}
	}

	// 测试执行方法
	@Test
	public void testUseMethod() throws Exception {
		Constructor<Dog> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
		Dog dog = declaredConstructor.newInstance("����", 3);

		// 公有方法直接执行
		Method say = clazz.getDeclaredMethod("say");
		say.invoke(dog);

		// 私有方法执行前要设置accessible属性为true，否则会报IllegalAccessException异常
		Method sleep = clazz.getDeclaredMethod("sleep");
		sleep.setAccessible(true);
		sleep.invoke(dog);

		// 静态方法执行直接用Class实例
		Method run = clazz.getDeclaredMethod("run");
		run.invoke(Dog.class);
	}
}
