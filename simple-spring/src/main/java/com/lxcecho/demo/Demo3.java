package com.lxcecho.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author lxcecho
 * @since 08.04.2021
 */
@Component
public class Demo3 implements ApplicationContextAware {

	@Autowired
	Demo1 demo1;

	public Demo3() {
		System.out.println("Z created");
	}

	/**
	 * 生命周期初始化回调方法
	 */
	@PostConstruct
	public void zInit() {
		System.out.println("Call z lifecycle init callback");
	}

	/**
	 * ApplicationContextAware 回调方法
	 *
	 * @param applicationContext the ApplicationContext object to be used by this object
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("call aware callback");
	}


}
