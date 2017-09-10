package com.hanbin.reflect;

@MyAnnotation
public class Dog extends Animal implements CommonInterface {
	public String name;
	private int age;

	@Override
	public void say() {
		System.out.println("汪汪");
	}

	public static void run() {
		System.out.println("我能跑");
	}

	public Dog() {
		super();
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private Dog(String name) {
		super();
		this.name = name;
	}

	private void sleep() {
		System.out.println(name + "要睡觉了");
	}

	@MyAnnotation(value = "haha")
	@Override
	public void breath(int intevalTime) throws Exception {
		super.breath(intevalTime);
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}

}
