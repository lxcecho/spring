package com.xc.joy.proxy.dynamic;

import com.xc.joy.proxy.dao.IndexDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 17.04.2021
 */
public class CustomInvocationHandler implements InvocationHandler {

	/**
	 * target object
	 */
	private Object obj;

	public CustomInvocationHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 代理的 before 业务逻辑
		System.out.println("-------------before----------------");
		// 执行目标对象得方法
		Object result = method.invoke(obj, args);
		System.out.println(result);
		// 代理的 after 业务逻辑
		System.out.println("-------------after----------------");
		return result;
	}
}
