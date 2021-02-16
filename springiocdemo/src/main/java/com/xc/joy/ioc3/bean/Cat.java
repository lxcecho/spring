package com.xc.joy.ioc3.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.function.Supplier;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Component
public class Cat  implements BeanFactoryAware, ApplicationContextAware, InitializingBean {

	private BeanFactory beanFactory;
	private ApplicationContext applicationContext;



	public Cat() {
		System.out.println("===new Cat==");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//		DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;
//		System.out.println(factory.getBeanDefinition("user"));
		this.beanFactory = beanFactory;
	}

	public void init() throws Exception {
		System.out.println("======xml init======");
	}




	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("======InitializingBean======");
	}

	@PostConstruct
	public void init2() throws Exception {
		System.out.println("======PostConstruct init2======");
	}

	@PostConstruct
	public void init3() throws Exception {
		System.out.println("======PostConstruct init3======");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		applicationContext.getAutowireCapableBeanFactory();
	}

	public void destory() throws Exception {
		System.out.println("======xml destory======");
	}

	@PreDestroy
	public void destory2() throws Exception {
		System.out.println("======PreDestroy destory======");
	}


}
