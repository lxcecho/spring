package com.xc.joy.demo.targetsource;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.target.SingletonTargetSource;

/**
 * @author lxcecho
 * @since 2021/1/8
 */
public class UsageDemo {
	public static void main(String[] args) {
		Target target = new Target();
		SingletonTargetSource singletonTargetSource = new SingletonTargetSource(target);
		// 使用Spring AOP框架的代理工厂直接创建对象
		Target proxy = (Target) ProxyFactory.getProxy(singletonTargetSource);
		System.out.println("getName : " + proxy.getClass().getName());
		System.out.println("getTargetClass : " + singletonTargetSource.getTargetClass());
		System.out.println("getTarget : " + singletonTargetSource.getTarget());
		System.out.println("isStatic : " + singletonTargetSource.isStatic());
	}
}
