package com.selfdev.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
 */
@Configuration
public class CustomizedBeanPostProcessor implements BeanPostProcessor {
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + "调用了 postProcessBeforeInitialization() ");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + "调用了 postProcessAfterInitialization() ");
		return bean;
	}
}
