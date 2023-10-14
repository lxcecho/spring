package com.lxcecho.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20.06.2021
 */
@Component
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
	public MyMergedBeanDefinitionPostProcessor() {
		System.out.println("MyMergedBeanDefinitionPostProcessor.......Constructor");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyMergedBeanDefinitionPostProcessor...postProcessBeforeInitialization...=>" + bean + "--" + beanName);
		return bean;// null
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyMergedBeanDefinitionPostProcessor...postProcessAfterInitialization..=>" + bean + "--" + beanName);
		return null;
	}

	/**
	 * 处理合并 bd 定义信息，再修改 bean 定义信息
	 *
	 * @param beanDefinition the merged bean definition for the bean
	 * @param beanType       the actual type of the managed bean instance
	 * @param beanName       the name of the bean
	 */
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		System.out.println("MyMergedBeanDefinitionPostProcessor...postProcessMergedBeanDefinition..=>" + beanName + "--" + beanType + "---" + beanDefinition);
	}

	@Override
	public void resetBeanDefinition(String beanName) {
		System.out.println("MyMergedBeanDefinitionPostProcessor...resetBeanDefinition.." + beanName);
	}
}
