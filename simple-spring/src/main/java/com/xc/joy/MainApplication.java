package com.xc.joy;

import com.xc.joy.conf.AppConfig;
import com.xc.joy.dao.IndexDao;
import com.xc.joy.entity.Users;
import com.xc.joy.service.Demo1;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 07.04.2021
 */
public class MainApplication {
	public static void main(String[] args) {
		System.out.println("Hello,lxcecho.");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(IndexDao.class);
		context.refresh();
		IndexDao dao = context.getBean(IndexDao.class);
		dao.query();
	}

	public static void main2(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean(Demo1.class));
	}

	public static void main3(String[] args) {
		// 定义一个 BeanDefinition
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		// 当前 Bean 对象的类型
		beanDefinition.setBeanClass(Users.class);

		// 设置  Bean 的其他属性

		/*// 设置作用域
		beanDefinition.setScope("prototype");
		// 设置初始化方法
		beanDefinition.setInitMethodName("init");
		// 设置自动装配类型
		beanDefinition.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);*/

		// 将 BeanDefinition 注册到 BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registerBeanDefinition("user", beanDefinition);
		// 获取 Bean
		System.out.println(beanFactory.getBean("user"));
	}

	public static void main4(String[] args) {
		/*DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
		// 将 Users.class 解析为 BeanDefinition
		annotatedBeanDefinitionReader.register(Users.class);
		System.out.println(beanFactory.getBean(Users.class));*/

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		int i = xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");
		System.out.println(beanFactory.getBean("user"));

		/**
		 * ClassPathBeanDefinitionScanner
		 * 这个并不是BeanDefinitionReader，但是它的作用和BeanDefinitionReader类似，它可以进行扫描，扫描某个包路径，
		 * 对扫描到的类进行解析，比如，扫描到的类上如果存在@Component注解，那么就会把这个类解析为一个BeanDefinition。
		 */
	}

	public static void main5(String[] args) {
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(Users.class);

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 注册 BeanDefinition
		beanFactory.registerBeanDefinition("user",beanDefinition);
		// 注册别名
		beanFactory.registerAlias("user","user11");
		//注册 BeanPostProcessor
		beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
			@Override
			public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
				return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
			}

			@Override
			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
				return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
			}
		});
		// 获取 Bean 对象
		System.out.println(beanFactory.getBean("user11"));
		// 根据类型获取 beanNames
		String[] beanNamesForType = beanFactory.getBeanNamesForType(Users.class);
		for (String s : beanNamesForType) {
			System.out.println(s);
		}
		System.out.println(beanFactory.getBeanNamesForType(Users.class));
	}

	public static void main6(String[] args) {

	}



























}
