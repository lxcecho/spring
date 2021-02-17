package com.xc.joy.ioc.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lxcecho
 * @since 2021/2/16
 */
@Component
public class MyFactoryBean implements FactoryBean<Object> {
	@Override
	public Object getObject() throws Exception {
		return new ReentrantLock();
	}

	@Override
	public Class<?> getObjectType() {
		return ReentrantLock.class;
	}
}
