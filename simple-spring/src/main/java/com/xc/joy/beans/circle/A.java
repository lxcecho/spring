package com.xc.joy.beans.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 02.05.2022
 */
@Component
public class A {

	private B b;

	public A() {
		System.out.println("A Constructor...");
	}

	@Autowired
	public void setA(B b) {
		this.b = b;
	}

}
