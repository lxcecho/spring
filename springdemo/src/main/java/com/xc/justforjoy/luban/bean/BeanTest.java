package com.xc.justforjoy.luban.bean;

import com.xc.justforjoy.entity.User;
import com.xc.justforjoy.postprocessor.CustomizedBeanPostProcessor;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

/**
 * @author lxcecho
 * @since 2021/1/8
 */
public class BeanTest {
	/**
	 * 国际化
	 *
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("message");
		return resourceBundleMessageSource;
	}

	public static void main1(String[] args) {
		// 定义了一个 BeanDefinition
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		// 当前的Bean对象类型
		beanDefinition.setBeanClass(User.class);

		// 还可以通过 BeanDefinition 设置一个Bean的其他属性

		// 设置作用域 prototype
		beanDefinition.setScope("singleton");
		// 设置初始化方法
		beanDefinition.setInitMethodName("init");
		// 设置自动装配模型
		beanDefinition.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);

		// 将 BeanDefinition 注册到BeanFactory中
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registerBeanDefinition("user", beanDefinition);

		// 获取bean
		System.out.println(beanFactory.getBean("user"));
		System.out.println(beanFactory.getBean("user"));
	}

	public static void main2(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
		// 将 User.class，解析为 BeanDefinition
		annotatedBeanDefinitionReader.register(User.class);
		System.out.println(beanFactory.getBean("user"));

		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		int i = xmlBeanDefinitionReader.loadBeanDefinitions("/spring/spring-config.xml");
		System.out.println(beanFactory.getBean("user1"));
	}

	public static void main3(String[] args) {
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(User.class);

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 注册 BeanDefinition
		beanFactory.registerBeanDefinition("user", beanDefinition);
		// 注册别名
		beanFactory.registerAlias("user", "useruser");
		// 注册 BeanPostProcessor
		beanFactory.addBeanPostProcessor(new CustomizedBeanPostProcessor());

		// 获取 Bean 对象
		System.out.println(beanFactory.getBean("useruser"));
		// 根据类型获取beanNames
		System.out.println(beanFactory.getBeanNamesForType(User.class));
	}

	/**
	 * 资源加载
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main4(String[] args) throws IOException {
		/**
		 * 这个功能用到了策略模式。
		 */
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		/*Resource resource = annotationConfigApplicationContext.getResource("file:///G:\\spring-framework\\springdemo\\src\\main\\java\\com\\xc\\justforjoy\\entity\\User.java");
		System.out.println(resource.contentLength());*/

		/*Resource resource = annotationConfigApplicationContext.getResource("classpath:com/xc/justforjoy/entity/User.class");
		System.out.println(resource.contentLength());*/

		// 可以一次性获取多个
		Resource[] resources = annotationConfigApplicationContext.getResources("classpath:com/xc/justforjoy/service/*.class");
		for (Resource resource : resources) {
			System.out.println(resource.contentLength());
		}
	}

	/**
	 * 获取运行时环境
	 *
	 * @param args
	 */
	public static void main5(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		// 获取 JVM 所允许的操作系统的环境
		Map<String, Object> systemEnvironment = annotationConfigApplicationContext.getEnvironment().getSystemEnvironment();
		System.out.println(systemEnvironment);
		// 获取JVM本身的一些属性，包括 -D 所设置的
		Map<String, Object> systemProperties = annotationConfigApplicationContext.getEnvironment().getSystemProperties();
		System.out.println(systemProperties);
		// 还可以直接获取某个环境或properties文件中的属性
		String joy = annotationConfigApplicationContext.getEnvironment().getProperty("joy");
		System.out.println(joy);
	}

	/**
	 * 事件发布
	 *
	 * @param args
	 */
	/*public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.publishEvent("kkkk");
	}

	@Bean
	public ApplicationListener applicationListener(){
		return new ApplicationListener() {
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				System.out.println("接收到了一个事件...");
			}
		};
	}*/

}
