package com.xc.joy;

import com.xc.joy.ioc.bean.User;
import com.xc.joy.ioc.config.AppConfig;
import com.xc.joy.ioc2.dao.AccountMapper;
import com.xc.joy.ioc2.dao.UserMapper;
import com.xc.joy.ioc3.bean.Fox;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class IOCTest {

	@Test
	public void test() {

		// ioc容器
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		//((AnnotationConfigApplicationContext) context).close();

		//NoSuchBeanDefinitionException
		// BeanDefinition   bean定义  承载bean的属性   init-method  scope
		// BeanDefinitionRegistry 注册器
		// registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
		// BeanDefinitionMap    key(beanName)  value: BeanDefinition（Fox.class）
		// beanFactoryPostProcessor
//		BeanFactory beanFactory = ((AnnotationConfigApplicationContext) context).getDefaultListableBeanFactory();
		// 注册 Cat.class 的beanDefinition
		// 实现了 BeanDefinitionRegistry   BeanFactory
//		BeanDefinition beanDefinition = new RootBeanDefinition(Cat.class);
//		((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("cat",beanDefinition);

		// singletonObjects   map 缓存单例bean  beanName---singletonObject
//		Cat cat = new Cat();
//		((DefaultListableBeanFactory) beanFactory).registerSingleton("cat",cat);

		//System.out.println(context.getBean("myFactoryBean"));
		//	System.out.println(context.getBean("&myFactoryBean")); //  singletonObjects

		//	DefaultListableBeanFactory defaultListableBeanFactory = ((AnnotationConfigApplicationContext) context).getDefaultListableBeanFactory();


		Object userService = context.getBean("userService");
		System.out.println(userService);
	}

	@Test
	public void testXml() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		//NoSuchBeanDefinitionException   BeanDefinition
//		context.getBean("fox");
		// ResourceLoader
		///ResourceLoader resourceLoader = new DefaultResourceLoader();
		//Resource resource = resourceLoader.getResource("spring.xml");

		//BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		// beanFactory   BeanDefinitionRegistry
		DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

		BeanDefinition beanDefinition = new RootBeanDefinition(User.class);
		beanDefinition.getPropertyValues().add("name", "fox");
		//beanDefinition.setBeanClassName("bat.ke.qq.com.bean.Fox");
		registry.registerBeanDefinition("user", beanDefinition);

		//reader.loadBeanDefinitions(resource);

		System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));

		System.out.println(registry.getBean("user")); //

	}

	@Test
	public void testIOC2() {
		//ioc容器
		ApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);

		// FactoryBean既可以是本身，也可以是特殊bean(getObject())
		//System.out.println(context.getBean("myFactoryBean"));
		//	System.out.println(context.getBean("&myFactoryBean"));

		// jdk动态代理
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		System.out.println(userMapper.query());

		userMapper.query();

		AccountMapper accountMapper = (AccountMapper) context.getBean("accountMapper");
		accountMapper.query();

		//  将userMapper交给spring管理

		// NoSuchBeanDefinitionException
		// BeanDefinition   承载bean属性的文件
		// BeanDefinitionMap   key: id/name  beanName  value: BeanDefinition

//		BeanFactory beanFactory = ((AnnotationConfigApplicationContext) context).getDefaultListableBeanFactory();
//		// 注册BeanDefinition
////		BeanDefinition beanDefinition = new RootBeanDefinition(Fox.class);
////		((DefaultListableBeanFactory) beanFactory)
////				.registerBeanDefinition("fox",beanDefinition);
//
//		// singletonObjects 单例对象池   Map :  key: beanName value:  bean对象 object
//		((DefaultListableBeanFactory) beanFactory)
//				.registerSingleton("fox",new Fox());
//
//		context.getBean("fox");

	}

	@Test
	public void testIOC3() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(com.xc.joy.ioc3.config.AppConfig.class);

//		System.out.println(context.getBean("myFactoryBean")); //getObject
//		System.out.println(context.getBean("&myFactoryBean")); //myFactoryBean
//

		// userService,userService2    UserService.class
		// beanDefinitionMap  beanName---beanDefinition
		//context.getBean(UserService.class);// type-beanName ---getBean(beanName)

//		UserService userService = (UserService) context.getBean("userService");
//
//		userService.find();


		//context.close();


//		// 拿到工厂
//		DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
//
//		//创建一个beanDefinition
//		RootBeanDefinition beanDefinition = new RootBeanDefinition(Monkey.class);
//
//		// 注册
//		beanFactory.registerBeanDefinition("monkey",beanDefinition);
//
//		//填充属性
//		//beanDefinition.getPropertyValues().add("name","xxxx");
//
//		// autowireMode==3  构造器贪婪模式
//		//beanDefinition.setAutowireMode(3);
//
//		System.out.println(context.getBean("monkey"));

	}

	@Test
	public void testIOC4() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("Spring.xml");

		Fox fox = (Fox) context.getBean("fox22");
		System.out.println(fox);

		//创建一个简单注册器   map  key---beanDefinition
		//BeanDefinitionRegistry register = new SimpleBeanDefinitionRegistry();

//		//创建一个实现了注册器的工厂   即是一个工厂，又是一个注册器
//		BeanDefinitionRegistry register = new DefaultListableBeanFactory();
//	//创建bean定义读取器
//		BeanDefinitionReader reader = new XmlBeanDefinitionReader(register);
//
//		reader.loadBeanDefinitions("spring.xml");
//
//		System.out.println(Arrays.toString(register.getBeanDefinitionNames()));
//		System.out.println(register.getBeanDefinition("fox22"));
//
//		System.out.println(((DefaultListableBeanFactory) register).getBean("fox22"));
//

		// 创建资源读取器
		//DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

		// 装载Bean的定义

		// 打印构建的Bean 名称
		//System.out.println(Arrays.toString(register.getBeanDefinitionNames());

		// 工厂调用getBean方法
		//	System.out.println(register.getBean("user"));
	}

}

