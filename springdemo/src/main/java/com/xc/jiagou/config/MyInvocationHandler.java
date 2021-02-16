package com.xc.jiagou.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class MyInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke");
		return null;
	}
}
