package com.xc.joy.ioc2.core;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class MyFactoryBean implements FactoryBean<Object> {

	private Class<?> mapperInterface;

	public MyFactoryBean(Class<?> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {
		// jdk 动态代理
		return Proxy.newProxyInstance(
				this.getClass().getClassLoader(),
				new Class<?>[]{mapperInterface},
				new MyMapperProxy());
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}
}
