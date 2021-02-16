package com.xc.joy.ioc2.core;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class MyMapperProxy implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		// sql
				System.out.println(method.getAnnotation(Select.class).value()[0]);
		//
		//		// sqlsession

		return null;
	}
}
