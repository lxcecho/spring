package com.lxcecho.processor.factory;

import com.lxcecho.entity.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20.06.2021
 * <p>
 * BeanFactory的后置处理器, PriorityOrdered, Ordered
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	public MyBeanDefinitionRegistryPostProcessor() {
		System.out.println("MyBeanDefinitionRegistryPostProcessor....Constructor");
	}

	@Override  // 紧接着执行
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor....postProcessBeanFactory...");
		// TODO Auto-generated method stub
		System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量：" + beanFactory.getBeanDefinitionCount());
	}

	/**
	 * BeanDefinitionRegistry Bean 定义信息的保存中心，以后 BeanFactory 就是按照 BeanDefinitionRegistry 里面保存的每一个 bean 定义信息创建 bean 实例；
	 *
	 * @param registry the bean definition registry used by the application context
	 * @throws BeansException
	 */

	@Override  // 先执行的
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor...postProcessBeanDefinitionRegistry...");
		// 增强 bean 定义信息的注册中心，比如自己注册组件
		// TODO Auto-generated method stub
		System.out.println("postProcessBeanDefinitionRegistry...bean 的数量：" + registry.getBeanDefinitionCount());
		// RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
		registry.registerBeanDefinition("hello", beanDefinition);
	}

}
