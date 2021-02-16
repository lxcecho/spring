package com.xc.joy.ioc.proccessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author lxcecho
 * @since 2021/2/16
 */
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//		if(beanClass.equals(User.class)){
//			Enhancer enhancer = new Enhancer();
//			enhancer.setSuperclass(beanClass);
//			enhancer.setCallback(new MethodInterceptor() {
//				@Override
//				public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//					return methodProxy.invokeSuper(o,objects);
//				}
//			});
//			Object proxy = enhancer.create();
//
//			System.out.println("代理对象:"+proxy);
//			return proxy;
//
//		}
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//		if(beanName.equals("user")){
////			return false;
////		}
		return true;
	}
}
