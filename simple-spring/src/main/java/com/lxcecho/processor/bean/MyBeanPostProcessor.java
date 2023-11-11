package com.lxcecho.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * Bean 组件的 PostProcessor，后置处理器：初始化前后进行处理goon工作，将后置处理器加入到容器中
 *
 * @author lxcecho 909231497@qq.com
 * @since 20.06.2021
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	public MyBeanPostProcessor() {
		System.out.println("MyBeanPostProcessor.......Constructor");
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor...postProcessAfterInitialization..." + bean + "==>" + beanName);
		return bean;
	}

	/**
	 * 初始化之前的增强处理，可以改变之前创建的 Bean 实例
	 *
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor...postProcessBeforeInitialization..." + bean + "==>" + beanName);
		return bean;
	}


}
