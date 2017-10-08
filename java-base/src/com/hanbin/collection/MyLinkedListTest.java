package com.hanbin.collection;

public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();

		list.add("aaa");
		list.add("BB");
		list.add("C");
		list.add("DD");
		list.add("EFG");
		list.add("fghf");

		System.out.println(list.get(0));// aaa
		System.out.println(list.get(3));// DD
		System.out.println(list.get(4));// EFG

		System.out.println(list.removeFirst());// aaa
		System.out.println(list.removeLast());// fghf
		System.out.println(list.get(0));// BB

		list.add(0, "H");

		System.out.println(list.size());// 5
		System.out.println(list.get(0));// H
		System.out.println(list.get(1));// BB
	}

}
