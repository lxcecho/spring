package com.xc.joy.ioc3.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Component
public class A {
	@Autowired   // field.set(obj,value)
	private B b;

	//  clazz.newInstance(constructor)
	public A(){
		this.b = b;
	}
}
