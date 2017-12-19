package com.hanbin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

	private Object obj;

	public DynamicProxy(Object obj) {
		super();
		this.obj = obj;
	}

	@Override
	public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {

		Object result = method.invoke(obj, arg2);

		return result;
	}

	public Object createProxy() {

		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);

	}

}
