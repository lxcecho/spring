package com.xc.joy.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20.06.2021
 *
 * TODO Bean 进行代理增强期间进行使用
 */
@Component
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

	public MySmartInstantiationAwareBeanPostProcessor() {
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...");
	}

	/**
	 * 预测 Bean 的类型，最后一次改变组件类型
	 *
	 * @param beanClass the raw class of the bean
	 * @param beanName  the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...predictBeanType=>" + beanClass + "--" + beanName);
		return null;
	}

	/**
	 * 返回我们要使用的构造器候选列表
	 *
	 * @param beanClass the raw class of the bean (never {@code null})
	 * @param beanName  the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName)
			throws BeansException {
		// 会被调用两次：第一次是获取所有监听器的时候 第二次是按照类型获取别的组件的时候 —— cat 都没被创建
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...determineCandidateConstructors=>" + beanClass + "--" + beanName);
		// 返回一个我们指定的构造器
		return null;
	}

	/**
	 * 返回早期的 Bean 引用
	 *
	 * @param bean     the raw bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...getEarlyBeanReference=>" + bean + "--" + beanName);
		return bean;
	}

}
