package com.hanbin.reflect;

public class Dog extends Animal implements CommonInterface {
	public String name;
	private int age;

	@Override
	public void say() {
		System.out.println("����");
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
		System.out.println(name + "Ҫ˯����");
	}

	@Override
	public void breath(int intevalTime) throws Exception {
		super.breath(intevalTime);
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}

}
