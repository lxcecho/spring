package com.xc.joy.ioc3.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
//@Component
public class MyBeanFactoryPostProcesser implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		DefaultListableBeanFactory factory = (DefaultListableBeanFactory)beanFactory;
//		AbstractBeanDefinition beanDefinition = new RootBeanDefinition(Tiger.class);
//		beanDefinition.setPrimary(true);
//		//    mybatis-spring
//		factory.registerBeanDefinition("tiger22",beanDefinition);

		AbstractBeanDefinition beanDefinition  = (AbstractBeanDefinition)
				beanFactory.getBeanDefinition("monkey");

		//System.out.println("autowireMode:"+beanDefinition.getAutowireMode());

		beanDefinition.setAutowireMode(3); // 构造器贪婪模式 （参数最多  bean）

	}
}
