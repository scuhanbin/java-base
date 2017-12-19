package com.hanbin.proxy;

import org.junit.Test;

public class DynamicProxyTest {
	@Test
	public void test() {

		Human human = (Human) new DynamicProxy(new Man()).createProxy();

		human.eat();
	}
}
