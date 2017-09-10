package com.hanbin.reflect;

public class Animal {
	public int legs;

	public void breath(int intevalTime) throws Exception {
		System.out.println("我可以间隔" + intevalTime + "秒呼吸一次！");
	}
}
