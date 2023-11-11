package com.lxcecho.entity.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 02.05.2022
 *
 * 肯定成功的
 */
@Component
public class B {

	private A a;

	public B() {
		System.out.println("B Constructor...");
	}

	@Autowired
	public void setA(A a) {
		this.a = a;
	}

}
