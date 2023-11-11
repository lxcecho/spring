package com.lxcecho.entity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class Apple implements ApplicationContextAware {

	//@Autowired
	private ApplicationContext applicationContext;

	public Apple() {
		System.out.println("dog constructor...");
	}

	/**
	 * 对象创建并赋值之后调用
	 */
	@PostConstruct
	public void init() {
		System.out.println("Dog....@PostConstruct...");
	}

	/**
	 * 容器移除对象之前
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("Dog....@PreDestroy...");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}


}
