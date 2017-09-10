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
		// getFields()��ȡ����ʱ��͸�����public����
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			System.out.print(field.getName() + " ");
		}

		System.out.println();

		// getDeclaredFields()��ȡ����ʱ������������������
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.print(field.getName() + " ");
		}

		System.out.println();

		// ��ȡָ��������
		Field declaredField = clazz.getDeclaredField("age");
		System.out.println(declaredField.getName());
	}

	// ���Ի�ȡ������ص���Ϣ:����Ȩ�����η������͡�����
	@Test
	public void testInfomationOfField() throws Exception {
		Field age = clazz.getDeclaredField("age");

		int modifiers = age.getModifiers();
		System.out.println("����Ȩ�����η���" + Modifier.toString(modifiers));

		Class type = age.getType();
		System.out.println("����Ϊ��" + type.getName());

		System.out.println("������Ϊ��" + age.getName());
	}

	// ͨ����������Ը�ֵ�����С�˽��
	@Test
	public void testUseField() throws Exception {
		Dog dog = new Dog();
		Field name = clazz.getDeclaredField("name");
		name.set(dog, "����");

		System.out.println(dog);

		// ��˽�����Ը�ֵǰҪ�������Ե�accessible����Ϊtrue������ᱨIllegalAccessException�쳣
		Field age = clazz.getDeclaredField("age");
		age.setAccessible(true);
		age.set(dog, 3);

		System.out.println(dog);
	}
}
