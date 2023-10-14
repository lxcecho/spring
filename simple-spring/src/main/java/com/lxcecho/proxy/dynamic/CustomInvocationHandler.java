package com.lxcecho.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类：要实现接口：InvocationHandler
 *
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

	/**
	 *
	 * @param proxy the proxy instance that the method was invoked on 代理类的实例
	 *
	 * @param method the {@code Method} instance corresponding to 目标对象要调用的方法对象
	 * the interface method invoked on the proxy instance.  The declaring
	 * class of the {@code Method} object will be the interface that
	 * the method was declared in, which may be a superinterface of the
	 * proxy interface that the proxy class inherits the method through.
	 *
	 * @param args an array of objects containing the values of the 目标对象所要调用的方法的参数
	 * arguments passed in the method invocation on the proxy instance,
	 * or {@code null} if interface method takes no arguments.
	 * Arguments of primitive types are wrapped in instances of the
	 * appropriate primitive wrapper class, such as
	 * {@code java.lang.Integer} or {@code java.lang.Boolean}.
	 *
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("proxy: " + proxy.getClass());

		// 代理的 before 业务逻辑
		System.out.println("-------------before----------------");
		// 执行目标对象得方法 call target object method
		Object result = method.invoke(obj, args);
		System.out.println(result);
		// 代理的 after 业务逻辑
		System.out.println("-------------after----------------");
		return result;
	}
}
