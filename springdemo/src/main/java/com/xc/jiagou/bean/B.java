package com.xc.jiagou.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Component
public class B {

	@Autowired
	private A a;

	public B(){

	}
	public B(A a){
		this.a = a;
		System.out.println(a);
	}
}
