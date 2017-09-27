package com.hanbin.collection;

import org.junit.Test;

public class MyArrayListTest {
	@Test
	public void test() {
		MyArrayList list = new MyArrayList(4);

		list.add("1231");
		list.add(1212);
		list.add("1231");
		list.add("aaa");
		list.add("bbb");
		list.add("1231");
		list.add("1231");

		System.out.println(list.size());// 7
		System.out.println(list.get(5));// 1231
		System.out.println(list.contains("bbb"));// true
		System.out.println(list.indexOf("1231"));// 0
		System.out.println(list.lastIndexOf("1231"));// 6
	}
}
