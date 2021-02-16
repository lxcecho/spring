package com.xc.joy.ioc3.proxy;

import org.aopalliance.aop.Advice;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Component
public class FoxProxy {

	public void query() {
		System.out.print("=========query===========");
	}
}
