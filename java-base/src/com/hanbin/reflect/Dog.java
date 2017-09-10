package com.hanbin.reflect;

public class Dog extends Animal implements CommonInterface {
	public String name;
	private int age;

	@Override
	public void say() {
		System.out.println("ÍôÍô");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
		System.out.println("ÒªË¯¾õÁË");
	}
}
