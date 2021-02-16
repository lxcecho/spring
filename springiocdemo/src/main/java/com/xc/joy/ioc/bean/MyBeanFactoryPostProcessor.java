package com.xc.joy.ioc.bean;

import com.xc.joy.ioc.proccessor.MyInstantiationAwareBeanPostProcessor;
import com.xc.joy.ioc.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho
 * @since 2021/2/16
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		//((DefaultListableBeanFactory) beanFactory).registerSingleton("cat",new Cat());

		// 承载bean的属性的    class.newInstance()
		AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("user");
		// user -->cat  Cat.newInstance()   bat.ke.qq.com.bean.Cat@3c407114
		//beanDefinition.setBeanClassName("bat.ke.qq.com.bean.Cat");

		// 构造器贪婪模式
		// Autowiring mode  自动装配模式    xml     setter  constructor
		// @Autowired  field.set    setter  constructor
	    //beanDefinition.setAutowireMode(3);

		// 属性填充
		beanDefinition.getPropertyValues().add("name","fox");

		beanDefinition.getPropertyValues().add("age",30);


		//BeanDefinition cat = beanFactory.getBeanDefinition("cat");
		//cat.setBeanClassName("bat.ke.qq.com.bean.Fox");

		beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());



		beanFactory.registerSingleton("userService",new UserService());
	}
}
