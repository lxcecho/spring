package com.xc.joy.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho
 * @since 2021/2/16
 */
@Component
public class A {
	//@Autowired
	private B b;

	public A(B b){
		this.b = b;
	}
}
