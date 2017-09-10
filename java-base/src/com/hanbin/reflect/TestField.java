package com.hanbin.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class TestField {
	Class clazz = null;

	@Before
	public void before() {
		clazz = Dog.class;
	}

	@Test
	public void testGetFields() throws Exception {
		// getFields()获取运行时类和父类中public属性
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			System.out.print(field.getName() + " ");
		}

		System.out.println();

		// getDeclaredFields()获取运行时类中声明的所有属性
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.print(field.getName() + " ");
		}

		System.out.println();

		// 获取指定的属性
		Field declaredField = clazz.getDeclaredField("age");
		System.out.println(declaredField.getName());
	}

	// 测试获取属性相关的信息:访问权限修饰符、类型、名称
	@Test
	public void testInfomationOfField() throws Exception {
		Field age = clazz.getDeclaredField("age");

		int modifiers = age.getModifiers();
		System.out.println("访问权限修饰符：" + Modifier.toString(modifiers));

		Class type = age.getType();
		System.out.println("类型为：" + type.getName());

		System.out.println("属性名为：" + age.getName());
	}

	// 通过反射给属性赋值：公有、私有
	@Test
	public void testUseField() throws Exception {
		Dog dog = new Dog();
		Field name = clazz.getDeclaredField("name");
		name.set(dog, "旺财");

		System.out.println(dog);

		// 给私有属性赋值前要设置属性的accessible属性为true，否则会报IllegalAccessException异常
		Field age = clazz.getDeclaredField("age");
		age.setAccessible(true);
		age.set(dog, 3);

		System.out.println(dog);
	}
}
