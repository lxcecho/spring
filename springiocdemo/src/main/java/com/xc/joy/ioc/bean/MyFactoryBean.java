package com.xc.joy.ioc.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lxcecho
 * @since 2021/2/16
 */
@Component
public class MyFactoryBean implements FactoryBean {

	public Object getObject(){
		return new ReentrantLock();
	}

	public Class<?> getObjectType(){
		return ReentrantLock.class;
	}
}
