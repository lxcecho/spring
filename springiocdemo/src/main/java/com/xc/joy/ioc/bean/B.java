package com.xc.joy.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho
 * @since 2021/2/16
 */
@Component
public class B {
	//@Autowired
	private A a;  //populateBean   beanFactory.getBean("a")  prototype  @Lookup

	public B(@Lazy A a) {
		this.a = a;
	}
}
